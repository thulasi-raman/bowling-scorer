package com.genios.bowling;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {

	public BowlingForm calculateScore(BowlingForm form)
	{
		form.getBowlingFrames().forEach(e ->{
			processRolling(e);
		});
		form.getBowlingFrames().forEach(e -> {
			calculateFrameScore(e);
			handleSparesAndStrikes(form);
		});
		form.setScore(form.getBowlingFrames()
				.stream().mapToInt(frame -> frame.getScore()).sum());
		form.setGameOver(form.getBowlingFrames()
				.stream().allMatch(frame -> frame.isComplete()));
		return form;
	}

	private void processRolling(Frame frame)
	{
		frame.setStrike(false);
		frame.setSpare(false);
		frame.setComplete(false);
		if(frame.getRoll1().equals(10)) {
				frame.setStrike(true);
		} else if(frame.getRoll1() + frame.getRoll2() == 10)
		{
			frame.setSpare(true);
		} else if(frame.getRoll1() == 0 || frame.getRoll2() == 0)
		{
			frame.setMiss(true);
		}
	}

	private void calculateFrameScore(Frame frame)
	{
		frame.setScore(frame.getRoll1() + frame.getRoll2());
		if(!frame.isSpare() && !frame.isStrike()) {
			frame.setComplete(true);
		}
	}

	private void handleSparesAndStrikes(BowlingForm form)
	{
		List<Frame> spareFrames = form.getBowlingFrames().
								  stream().
								  filter(frame -> frame.isSpare()).collect(Collectors.toList());
		spareFrames.forEach(e -> calculateSpareScore(e.getIndex(), e, form.getBowlingFrames()));
		List<Frame> strikeFrames = form.getBowlingFrames().
								   stream().
								   filter(frame -> frame.isStrike()).collect(Collectors.toList());
		strikeFrames.forEach(e -> calculateStrikeScoreSwitch(e.getIndex(), e, form.getBowlingFrames()));
	}

	private void calculateSpareScore(Integer index, Frame spareFrame, List<Frame> frames)
	{
		if(!index.equals(10))
		{
			Integer spareBonus = frames.stream().
					filter(frame -> frame.getIndex().equals(index+1)).
					findFirst().get().getRoll1();
			spareFrame.setScore(spareBonus+10);
		} else
		{
			spareFrame.setScore(10 + spareFrame.getRoll3());
		}
		spareFrame.setComplete(true);
	}

	private void calculateStrikeScoreSwitch(Integer index, Frame strikeFrame, List<Frame> frames)
	{
		Integer firstStrikeBonus = 0;
		Integer secondStrikeBonus = 0;
		switch(index) {
		case 10:
			strikeFrame.setScore(10+strikeFrame.getRoll2()+strikeFrame.getRoll3());
			strikeFrame.setComplete(true);
			return;
		case 9:
				secondStrikeBonus = frames.stream().
						filter(frame -> frame.getIndex().equals(index+1)).
						findFirst().get().getRoll2();
				break;
		default:
			boolean isNextAlsoStrike = frames.stream().
			filter(frame -> frame.getIndex().equals(index+1)).
			findFirst().get().isStrike();
			if(isNextAlsoStrike) {
				secondStrikeBonus = frames.stream().
						filter(frame -> frame.getIndex().equals(index+2)).
						findFirst().get().getRoll1();

			} else {
				secondStrikeBonus = frames.stream().
						filter(frame -> frame.getIndex().equals(index+1) && !frame.isStrike()).
						findFirst().get().getRoll2();
			}

		}
		firstStrikeBonus = frames.stream().
				filter(frame -> frame.getIndex().equals(index+1)).
				findFirst().get().getRoll1();
		strikeFrame.setScore(firstStrikeBonus+secondStrikeBonus+10);
		strikeFrame.setComplete(true);
	}

}
