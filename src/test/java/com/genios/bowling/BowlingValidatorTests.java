package com.genios.bowling;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BowlingValidatorTests {


	@Autowired
	private Bowlingvalidator validator;

	@Test//ToDO
	public void testhasErrorsForNegativeScore()
	{
		//validator.validateNullInput(new BowlingForm(), errors);
	}

}
