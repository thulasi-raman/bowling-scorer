package com.genios.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CalculationServiceTests {

	@Autowired
	private CalculationService calculationService;

	@Test
	public void testCompleteStrike() {
		Integer topScore = 300;
		BowlingForm form = calculationService.calculateScore(BowlingTestsUtil.getBowlingForm(10));
		assertEquals(topScore, form.getScore());
	}

	@Test
	public void testAllSpare() {
		Integer allSpareScore = 150;
		BowlingForm form = calculationService.calculateScore(BowlingTestsUtil.getBowlingForm(5));
		assertEquals(allSpareScore, form.getScore());
	}

	@Test
	public void testAllMiss() {
		Integer missScore = 0;
		BowlingForm form = calculationService.calculateScore(BowlingTestsUtil.getBowlingForm(0));
		assertEquals(missScore, form.getScore());
	}

}
