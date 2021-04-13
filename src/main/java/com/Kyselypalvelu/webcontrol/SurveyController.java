package com.Kyselypalvelu.webcontrol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//<<<<<<< HEAD =======
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
=======
import org.springframework.web.bind.annotation.CrossOrigin;
>>>>>>> 3bb1003cef097491cd6182bcaefd194f865da68e
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Kyselypalvelu.domain.QuestionRepository;
import com.Kyselypalvelu.domain.Survey;
import com.Kyselypalvelu.domain.SurveyRepository;

@CrossOrigin
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
	
	// RESTful service to save new survey
	@RequestMapping(value = "/surveys", method = RequestMethod.POST)
	public @ResponseBody Survey saveSurveyRest(@RequestBody Survey survey) {
		return srepo.save(survey);
	}
	

	/*
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Survey survey) {
		srepo.save(survey);
		return "redirect:PLACEHOLDER";
	}
*/
	
}
