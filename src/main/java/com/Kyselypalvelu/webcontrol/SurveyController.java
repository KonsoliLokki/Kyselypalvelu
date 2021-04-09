package com.Kyselypalvelu.webcontrol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//<<<<<<< HEAD =======
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Kyselypalvelu.domain.Question;
import com.Kyselypalvelu.domain.QuestionRepository;
import com.Kyselypalvelu.domain.Survey;
import com.Kyselypalvelu.domain.SurveyRepository;

@Controller
public class SurveyController {

	@Autowired
	private SurveyRepository srepo;
	
	@Autowired 
	private QuestionRepository qrepos;
	
	
	
	@RequestMapping(value ={"/survey"})
    public String question() {	
        return "survey";
	}

	/*
	// CreateNew()
	@RequestMapping(value = "/add", method = RequestMethod.GET) //<< Placeholder
	public String addSurvey(Model model) {
		model.addAttribute("survey", new Survey());
		
	//	model.addAttribute("question", new Question());
		//List <Question> questions = qrepos.findAll();
	//	model.addAttribute("questions", questions);
		
		return "survey";
	}
	
	*/
	

	// RESTful service to get all surveys
	@RequestMapping(value = "/surveys", method = RequestMethod.GET) // Placeholder
	public @ResponseBody List<Survey> surveyListRest() {
		return (List<Survey>) srepo.findAll();

	}

	/*
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Survey survey) {
		srepo.save(survey);
		return "redirect:PLACEHOLDER";
	}
*/
	
}
