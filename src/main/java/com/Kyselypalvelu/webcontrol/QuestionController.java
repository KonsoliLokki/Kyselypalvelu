package com.Kyselypalvelu.webcontrol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Kyselypalvelu.domain.Question;
import com.Kyselypalvelu.domain.QuestionRepository;
import com.Kyselypalvelu.domain.Survey;
import com.Kyselypalvelu.domain.SurveyRepository;

@Controller
public class QuestionController {

@Autowired
private QuestionRepository repos;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private SurveyRepository surveyRepository;


	@RequestMapping(value ={"/", "/question"})
    public String question() {	
        return "I am question";
    }
	
	// RESTful service to get all questions
	@GetMapping("/questions")
	public @ResponseBody List<Question> questionsRest() {
		return (List<Question>) questionRepository.findAll();
	}
	
	// RESTful service to get all questions
	@GetMapping("/surveys")
	public @ResponseBody List<Survey> surveysRest() {
		return (List<Survey>) surveyRepository.findAll();
	}
}
