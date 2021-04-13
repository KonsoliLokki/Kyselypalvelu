package com.Kyselypalvelu.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Kyselypalvelu.domain.AnswerRepository;

@Controller
public class AnswerController {
	
	@Autowired
	private AnswerRepository ansRepo;
	
	// create new answer
	@GetMapping() // ????
	public String createNewAnswer(Model model) {
		return "";
	}

}
