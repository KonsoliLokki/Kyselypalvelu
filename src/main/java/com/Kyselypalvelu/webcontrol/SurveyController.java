package com.Kyselypalvelu.webcontrol;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//<<<<<<< HEAD =======
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	@RequestMapping(value = { "/" }, method = RequestMethod.GET) // << Placeholder
	public String createNewSurvey(Model model) {

		List<Question> questions = qrepos.findAll();
		model.addAttribute("questions", questions);
		List<Survey> surveys = srepos.findAll();
		model.addAttribute("surveys", surveys);

		return "survey";
	}

	@RequestMapping(value = "/newsurvey", method = RequestMethod.GET)
	public String newSurvey(Model model) {
		model.addAttribute("survey", new Survey());
		return "newsurvey";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Survey survey, Question question) {

		// Kesken
		qrepos.save(question);
		srepos.save(survey);
		return "redirect:/";
	}

	// Edit survey
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editSurvey(@PathVariable("id") Long surveyId, Model model) {
		// Kesken
		model.addAttribute("question", new Question());
		model.addAttribute("surveys", srepos.findAll());
		// findById palauttaa optionalin, jonka sisällä itse survey -objekti
		model.addAttribute("surveyobj", srepos.findById(surveyId).get());
		model.addAttribute("questions", qrepos.findAll());
		return "editsurvey";
	}

	@RequestMapping(value = "/edit/saveQuestionToSurvey", method = RequestMethod.POST)
	public String saveQuestionToSurvey(Question question) {
		qrepos.save(question);
		return "redirect:/";
	}

	// <------------------------------ REST START ----------------------------->

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

	// <------------------------------ REST END ------------------------------->
}
