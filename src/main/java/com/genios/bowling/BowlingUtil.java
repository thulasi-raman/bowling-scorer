package com.genios.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingUtil {

	public static final String ERROR_MESSAGE = "errorMessage";
	public static final String ROLL1 = "Roll1";
	public static final String ROLL2 = "Roll2";
	public static final String ROLL3 = "Roll3";
	public static final String NULL_MESSAGE = " should not be null or non numeric";
	public static final String  GREATER_THAN_10 = " should not be greater than 10";
	public static final String  LESSER_THAN_0 = " should not be lesser than 0";

	protected static BowlingForm getBowlingForm()
	{
		List<Frame> frames = new ArrayList<Frame>();
		for(int i =1; i <=10; i++)
		{
			Frame frame = new Frame();
			frame.setIndex(i);
			frame.setRoll1(0);
			frame.setRoll2(0);
			frame.setRoll3(0);
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
