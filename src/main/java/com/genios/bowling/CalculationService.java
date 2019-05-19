package com.genios.bowling;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {
	
	private BowlingForm calculateScore(BowlingForm form)
	{
		Integer calculatedScore = form.getScore();
		form.getBowlingFrames().forEach(e -> {
			getScoreForFrame(e, e.getIndex());
		});
		
		return form;
	}
	
	private Integer getScoreForFrame(Frame frame, Integer frameIndex)
	{
		
		return 0;
	}
	
	
	

}
