package com.example.Coronavirustracker.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Coronavirustracker.models.locationState;
import com.example.Coronavirustracker.services.CoronaVirusDataService;

@Controller
public class HomeController {

	@Autowired
	CoronaVirusDataService cvds;
	@GetMapping("/")
	public String Home(Model model) {
		List<locationState> allStates = cvds.getAllStats();
		int TotalCases=allStates.stream().mapToInt(stat->stat.getLatestTotalCases()).sum();
		model.addAttribute("LocationStats",allStates);
		
		model.addAttribute("totalreportedCases",TotalCases);
		return "home";
	}
}
