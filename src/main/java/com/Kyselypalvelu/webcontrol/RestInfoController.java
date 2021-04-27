package com.Kyselypalvelu.webcontrol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@Controller
public class RestInfoController {

	@GetMapping("/resthome")
	public String showHomepage() {
		return "resthome";
	}
}
