package com.genios.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@Autowired
	private CalculationService calculationService;

	@Autowired
	private Bowlingvalidator bowlingValidator;

	@GetMapping(value ={"/home","/"})
    public String getBowlingScoreboard(Model model) {
		model.addAttribute("bowlingForm", BowlingUtil.getBowlingForm());
		return "home";
    }

	@PostMapping(value ={"/home","/"})
    public String processBowlingScoreboard( @ModelAttribute("bowlingForm") BowlingForm bowlingForm, BindingResult result, Model model) {
		bowlingValidator.validate(bowlingForm, result);
		if(result.hasErrors()) return "home";
		calculationService.calculateScore(bowlingForm);
		return "home";
    }

}
