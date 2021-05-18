package com.Kyselypalvelu.webcontrol;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Kyselypalvelu.domain.Choice;
import com.Kyselypalvelu.domain.ChoiceRepository;
import com.Kyselypalvelu.domain.Question;
import com.Kyselypalvelu.domain.QuestionRepository;
import com.Kyselypalvelu.domain.QuestionType;
import com.Kyselypalvelu.domain.QuestionTypeRepository;
import com.Kyselypalvelu.domain.Survey;
import com.Kyselypalvelu.domain.SurveyRepository;

@CrossOrigin
@Controller
public class SurveyController {

	@Autowired
	private SurveyRepository srepos;

	@Autowired
	private QuestionRepository qrepos;
	
	@Autowired
	private QuestionTypeRepository qtrepos;
	
	
	@Autowired
	private ChoiceRepository crepos;

	// CreateNew()
	@RequestMapping(value = { "/" }, method = RequestMethod.GET) // << Placeholder
	public String createNewSurvey(Model model) {

		List<Question> questions = qrepos.findAll();
		model.addAttribute("questions", questions);
		List<Survey> surveys = srepos.findAll();
		model.addAttribute("surveys", surveys);

		return "survey";
	}


	
		//create new survey
	@RequestMapping(value = "/newsurvey", method = RequestMethod.GET)
	public String newSurvey(Model model) {
		model.addAttribute("survey", new Survey());
		return "newsurvey";
	}

	
	//save survey
	@RequestMapping(value = "/saveNewSurvey", method = RequestMethod.POST)
	public String save(Survey survey) {
		
		List <Choice> c = new ArrayList <Choice>();
		List <Question> q = survey.getQuestions();
		
		for(int i = 0 ; i<q.size(); i++) {
			if(q.get(i).getQuestiontype().getTypename().equals("text")) {
				System.out.println(q.get(i).getChoices()+"if tässä");
				
			}else {
				System.out.println(q.get(i).getQuestiontype()+"else tässä");
				
			}
		}
		
		srepos.save(survey);
		return "redirect:/";
		}

	
	// Edit survey
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editSurvey(@PathVariable("id") Long surveyId, Model model) {
		List <QuestionType> qt = qtrepos.findAll();
		model.addAttribute("questiontype", qt);
		model.addAttribute("question", new Question());
		model.addAttribute("choice", new Choice());
		Survey s = srepos.findById(surveyId).get();
		model.addAttribute("survey", s);
		return "editsurvey";
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
