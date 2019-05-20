package com.genios.bowling;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class Bowlingvalidator implements Validator{

	@Override
    public boolean supports(Class<?> clazz) {
        return BowlingForm.class.isAssignableFrom(clazz);
    }

	@Override
    public void validate(Object target, Errors errors) {
		BowlingForm bowlingForm = (BowlingForm) target;
		validateNullInput(bowlingForm, errors);
		validateUserInput(bowlingForm, errors);

    }

	public void validateNullInput(BowlingForm bowlingForm, Errors errors)
	{
		bowlingForm.getBowlingFrames()
		.stream()
		.filter(frame ->  frame.getRoll1() == null)
		.collect(Collectors.toList())
		.forEach(frame -> {
			errors.rejectValue(BowlingUtil.ERROR_MESSAGE, BowlingUtil.ERROR_MESSAGE, "Roll1 value for Frame " + frame.getIndex() + BowlingUtil.NULL_MESSAGE);
		});
		bowlingForm.getBowlingFrames()
		.stream()
		.filter(frame -> frame.getRoll2() == null)
		.collect(Collectors.toList())
		.forEach(frame -> {
			errors.rejectValue(BowlingUtil.ERROR_MESSAGE, BowlingUtil.ERROR_MESSAGE, "Roll2 value for Frame " + frame.getIndex() + BowlingUtil.NULL_MESSAGE);
		});
		bowlingForm.getBowlingFrames()
		.stream()
		.filter(frame -> frame.getRoll3() == null)
		.collect(Collectors.toList())
		.forEach(frame -> {
			errors.rejectValue(BowlingUtil.ERROR_MESSAGE, BowlingUtil.ERROR_MESSAGE, "Roll3 value for Frame " + frame.getIndex() + BowlingUtil.NULL_MESSAGE);
		});

		bowlingForm.getBowlingFrames()
		.stream().forEach(frame -> {
			try {
				frame.getRoll1().intValue();
				//Integer.parse(frame.getRoll1());
			} catch(NumberFormatException nfe) {
				errors.rejectValue(BowlingUtil.ERROR_MESSAGE, BowlingUtil.ERROR_MESSAGE, "Roll1 value for Frame " + frame.getIndex() + " should be number");
			}
		});

		/*.forEach(frame -> {
			errors.rejectValue("errorMessage", "errorMessage", "Roll1 value for Frame " + frame.getIndex() + " should not be null");
		});*/
	}

	public void validateUserInput(BowlingForm bowlingForm, Errors errors)
	{
		try{
			 //Custom Validations
			 bowlingForm.getBowlingFrames()
				.stream()
				.filter(frame -> frame.getRoll1().intValue() > 10)
				.collect(Collectors.toList())
				.forEach(frame -> {
					errors.rejectValue(BowlingUtil.ERROR_MESSAGE, "errorMessage", "Roll1 value for Frame " + frame.getIndex() + BowlingUtil.GREATER_THAN_10);
				});
			bowlingForm.getBowlingFrames()
				.stream()
				.filter(frame -> frame.getRoll1().intValue() < 0)
				.collect(Collectors.toList())
				.forEach(frame -> {
					errors.rejectValue(BowlingUtil.ERROR_MESSAGE, BowlingUtil.ERROR_MESSAGE, "Roll1 value for Frame " + frame.getIndex() + BowlingUtil.LESSER_THAN_0);
				});
			bowlingForm.getBowlingFrames()
			.stream()
			.filter(frame -> frame.getRoll2().intValue() > 10)
			.collect(Collectors.toList())
			.forEach(frame -> {
				errors.rejectValue(BowlingUtil.ERROR_MESSAGE, BowlingUtil.ERROR_MESSAGE, "Roll2 value for Frame " + frame.getIndex() + BowlingUtil.GREATER_THAN_10);
			});
			bowlingForm.getBowlingFrames()
				.stream()
				.filter(frame -> frame.getRoll2().intValue() < 0)
				.collect(Collectors.toList())
				.forEach(frame -> {
					errors.rejectValue(BowlingUtil.ERROR_MESSAGE, BowlingUtil.ERROR_MESSAGE, "Roll2 value for Frame " + frame.getIndex() + BowlingUtil.LESSER_THAN_0);
				});
			bowlingForm.getBowlingFrames()
			.stream()
			.filter(frame -> frame.getRoll3().intValue() > 10)
			.collect(Collectors.toList())
			.forEach(frame -> {
				errors.rejectValue(BowlingUtil.ERROR_MESSAGE, BowlingUtil.ERROR_MESSAGE + frame.getIndex() + BowlingUtil.GREATER_THAN_10);
			});
			bowlingForm.getBowlingFrames()
				.stream()
				.filter(frame -> frame.getRoll3().intValue() < 0)
				.collect(Collectors.toList())
				.forEach(frame -> {
					errors.rejectValue(BowlingUtil.ERROR_MESSAGE, BowlingUtil.ERROR_MESSAGE, "Roll1 value for Frame " + frame.getIndex() + BowlingUtil.LESSER_THAN_0);
				});
			bowlingForm.getBowlingFrames()
			.stream()
			.filter(frame -> frame.getRoll1().intValue() + frame.getRoll2().intValue()  > 10)
			.collect(Collectors.toList())
			.forEach(frame -> {
				if(frame.getIndex() != 10)
				errors.rejectValue(BowlingUtil.ERROR_MESSAGE, BowlingUtil.ERROR_MESSAGE, "Sum of Rolls for Frame  " + frame.getIndex() + BowlingUtil.GREATER_THAN_10);
			});

			 bowlingForm.getBowlingFrames()
			.stream()
			.filter(frame -> frame.getRoll3().intValue()  != 0)
			.collect(Collectors.toList())
			.forEach(frame -> {
				if(!frame.getIndex().equals(10))
				errors.rejectValue(BowlingUtil.ERROR_MESSAGE, BowlingUtil.ERROR_MESSAGE, "Only zero is permitted in Roll3 for Frame  " + frame.getIndex());
				else if(frame.getIndex().equals(10)){
					//TODO: Validation to inform user that roll3 score would be considered only in case of Strike/Spare
					/*Integer totalScore = frame.getRoll1() + frame.getRoll2();
					if((totalScore.equals(10)  )|| frame.getRoll1().equals(10)) {
						errors.rejectValue(BowlingUtil.ERROR_MESSAGE, BowlingUtil.ERROR_MESSAGE, "Roll3 score is considered only in case of Strike/Spare for Frame  " + frame.getIndex());
					}*/
				}
			});
			bowlingForm.getBowlingFrames()
			.stream()
			.filter(frame -> frame.getIndex() == 10)
			.collect(Collectors.toList())
			.forEach(frame -> {
				if(frame.getRoll1()  + frame.getRoll2() + frame.getRoll3() > 30)
				errors.rejectValue(BowlingUtil.ERROR_MESSAGE, BowlingUtil.ERROR_MESSAGE, "Sum of Rolls for Frame 10  " +  " cannot be greater than 30");
			});

		} catch(Exception e)
		{
			errors.rejectValue("errorMessage", "errorMessage", "Only numeric and non null Values are allowed");
		}
	}

}
