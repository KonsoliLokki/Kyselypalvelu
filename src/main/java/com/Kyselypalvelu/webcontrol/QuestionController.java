package com.Kyselypalvelu.webcontrol;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Kyselypalvelu.domain.Question;
import com.Kyselypalvelu.domain.QuestionRepository;

@CrossOrigin
@Controller
public class QuestionController {

	@Autowired
	private QuestionRepository qrepos;

	// CreateNew()
	@RequestMapping(value = "/createNewQuestion", method = RequestMethod.GET) // << Placeholder
	public String createNewQuestion(Model model) {

		model.addAttribute("question", new Question());
		List<Question> questions = qrepos.findAll();
		model.addAttribute("questions", questions);

		return "redirect:editsurvey";
	}


	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Question q) {
		qrepos.save(q);
		return "redirect:/";
	}

	// <------------------------------ REST START ----------------------------->

	// RESTful service to get all questions
	@GetMapping("/questions")
	public @ResponseBody List<Question> getAllQuestionsRest() {
		return (List<Question>) qrepos.findAll();
	}
	
	
	//RESTful to get question by id
	
	@GetMapping("/question/{id}")
	public @ResponseBody Optional <Question> getQuestionById(@PathVariable("id") long id) {
		return qrepos.findById(id);
	}

	// <------------------------------ REST END ------------------------------->
}
