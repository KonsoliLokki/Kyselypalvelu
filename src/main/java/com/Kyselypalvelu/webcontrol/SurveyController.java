package com.Kyselypalvelu.webcontrol;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//<<<<<<< HEAD =======
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Kyselypalvelu.domain.Question;
import com.Kyselypalvelu.domain.QuestionRepository;
import com.Kyselypalvelu.domain.Survey;
import com.Kyselypalvelu.domain.SurveyRepository;

@CrossOrigin
@Controller
public class SurveyController {

	@Autowired
	private SurveyRepository srepos;
	
	@Autowired 
	private QuestionRepository qrepos;
	

	// CreateNew()
	@RequestMapping(value = {"/addSurveys", "/"} , method = RequestMethod.GET) //<< Placeholder
	public String createNewSurvey(Model model) {
		
		model.addAttribute("question", new Question());
		model.addAttribute("survey", new Survey());
		
		List <Question> questions = qrepos.findAll();
		model.addAttribute("questions", questions);
		List<Survey> surveys = srepos.findAll();
		model.addAttribute("surveys", surveys);
	
		return "survey";
	}
	

	@RequestMapping(value = "/saveNewSurvey", method = RequestMethod.POST)
	public String saveNewSurvey(Survey survey) {
		
		srepos.save(survey);
		
		return "redirect:addSurveys";
	}


	@RequestMapping(value = "/saveQuestionToSurvey", method = RequestMethod.POST)
	public String saveQuestionToSurvey(Question question) {
		qrepos.save(question);
	
		return "redirect:addSurveys";
	}
	
	
	// Edit survey
	@GetMapping("edit/{id}")
	public String editSurvey(@PathVariable("id") Long surveyId, Model model) {
		model.addAttribute("survey", srepos.findById(surveyId));
		model.addAttribute("questions", qrepos.findAll());
		return "editsurvey";
	}
	
	// RESTful service to get all surveys
	@RequestMapping(value = "/surveys", method = RequestMethod.GET) // Placeholder
	public @ResponseBody List<Survey> getAllSurveysRest() {
		return (List<Survey>) srepos.findAll();

	}
	
	// RESTful service to save new survey
	@RequestMapping(value = "/surveys", method = RequestMethod.POST)
	public @ResponseBody Survey saveSurveyRest(@RequestBody Survey survey) {
		return srepos.save(survey);
	}
	
	// RESTful service to get survey by id
	@RequestMapping(value = "/surveys/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Survey> getSurveyByIdRest(@PathVariable("id") Long surveyId) {
		return srepos.findById(surveyId);
	}
}
