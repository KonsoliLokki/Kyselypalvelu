package com.Kyselypalvelu.webcontrol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Kyselypalvelu.domain.Answer;
import com.Kyselypalvelu.domain.AnswerRepository;

@CrossOrigin
@Controller
public class AnswerController {

	@Autowired
	private AnswerRepository ansRepo;

	// create new answer
	@GetMapping() // ????
	public String createNewAnswer(Model model) {
		return "";
	}

	// <------------------------------ REST START ----------------------------->

	// RESTful service to save answers
	@RequestMapping(value = "/answers", method = RequestMethod.POST)
	public @ResponseBody String saveAnswersRest(@RequestBody List<Answer> answers) {
		// Save each answer
		for (Answer answer : answers) {
			ansRepo.save(answer);
		}
		return "";
	}

	// RESTful service to get all answers to all questions
	@RequestMapping(value = "/answers", method = RequestMethod.GET)
	public @ResponseBody List<Answer> getAllAnswersRest() {
		return (List<Answer>) ansRepo.findAll();
	}

	// <------------------------------ REST END ------------------------------->
}
