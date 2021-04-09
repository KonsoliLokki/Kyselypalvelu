package com.Kyselypalvelu.webcontrol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Kyselypalvelu.domain.Question;
import com.Kyselypalvelu.domain.QuestionRepository;
import com.Kyselypalvelu.domain.Survey;

@Controller
public class QuestionController {

	@Autowired
	private QuestionRepository qrepos;

	// RESTful service to get all questions
	@GetMapping("/questions")
	public @ResponseBody List<Question> questionsRest() {
		return (List<Question>) qrepos.findAll();
	}

	@RequestMapping(value = { "/", "/question" })
	public String question() {
		return "question";
	}

	// CreateNew()
	@RequestMapping(value = "/add", method = RequestMethod.GET) //<< Placeholder
	public String addQuestion(Model model) {

		model.addAttribute("question", new Question());
		List<Question> questions = qrepos.findAll();
		model.addAttribute("questions", questions);

		return "survey";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveQuestion(Question q) {
		qrepos.save(q);
		return "redirect:add";
	}

}
