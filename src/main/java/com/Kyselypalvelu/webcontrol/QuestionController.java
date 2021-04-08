package com.Kyselypalvelu.webcontrol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Kyselypalvelu.domain.Question;
import com.Kyselypalvelu.domain.QuestionRepository;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository;

	@RequestMapping(value ={"/", "/question"})
    public String question() {	
        return "I am question";
    }
	
	// RESTful service to get all questions
	@GetMapping("/questions")
	public @ResponseBody List<Question> questionsRest() {
		return (List<Question>) questionRepository.findAll();
	}
}
