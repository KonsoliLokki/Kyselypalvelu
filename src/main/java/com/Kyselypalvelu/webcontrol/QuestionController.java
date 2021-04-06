package com.Kyselypalvelu.webcontrol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionController {


	@RequestMapping(value ={"/", "/question"})
    public String question() {	
        return "I am question";
    }
}
