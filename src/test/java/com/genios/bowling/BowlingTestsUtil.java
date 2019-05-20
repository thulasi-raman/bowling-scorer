package com.genios.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingTestsUtil {

	protected static BowlingForm getBowlingForm(Integer rollScore)
	{
		List<Frame> frames = new ArrayList<Frame>();
		for(int i =1; i <=10; i++)
		{
			Frame frame = new Frame();
			frame.setIndex(i);
			frame.setRoll1(rollScore);
			frame.setRoll2(rollScore);
			frame.setRoll3(rollScore);
			frame.setSpare(false);
			frame.setStrike(false);
			frame.setComplete(false);
			frames.add(frame);
		}
		BowlingForm bowlingForm = new BowlingForm();
		bowlingForm.setBowlingFrames(frames);
		bowlingForm.setGameOver(false);
		return bowlingForm;
	}

}
