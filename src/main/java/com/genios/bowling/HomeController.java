package com.genios.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping(value ={"/home","/"})
    public String getBowlingScoreboard(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("bowlingForm", getBowlingForm());
		return "home";
    }
	
	private BowlingForm getBowlingForm()
	{
		Map<Integer, Frame> frames = new TreeMap<Integer, Frame>();
		for(int i =1; i <=10; i++)
		{
			Frame frame = new Frame();
			frames.put(i, frame);
		}
		BowlingForm bowlingForm = new BowlingForm();
		bowlingForm.setBowlingFrames(frames);
		bowlingForm.setGameOver(false);
		return bowlingForm;
	}

}
