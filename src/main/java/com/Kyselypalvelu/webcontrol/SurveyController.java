package com.Kyselypalvelu.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

import com.Kyselypalvelu.domain.Survey;
import com.Kyselypalvelu.domain.SurveyRepository;

@Controller
public class SurveyController {
	
	@Autowired
	private SurveyRepository srepo;

	// CreateNew()	
	@RequestMapping(value="/add")			// << Placeholder
	public String addSurvey(Model model) {
		model.addAttribute("survey", new Survey());
		return "PLACEHOLDER";
	}
	
	//RESTful service to get all surveys
	@RequestMapping(value="/surveys", method = RequestMethod.GET)		//Placeholder
	public @ResponseBody List<Survey> surveyListRest() {
		return (List<Survey>) srepo.findAll(); 
	
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Survey survey) {
		srepo.save(survey);
		return "redirect:PLACEHOLDER";
	}
}
