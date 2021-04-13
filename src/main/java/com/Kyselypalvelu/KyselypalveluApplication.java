package com.Kyselypalvelu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Kyselypalvelu.domain.Answer;
import com.Kyselypalvelu.domain.AnswerRepository;
import com.Kyselypalvelu.domain.Question;
import com.Kyselypalvelu.domain.QuestionRepository;
import com.Kyselypalvelu.domain.Survey;
import com.Kyselypalvelu.domain.SurveyRepository;


@SpringBootApplication
public class KyselypalveluApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyselypalveluApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(SurveyRepository srepository, QuestionRepository qrepository
			, AnswerRepository arepository) {
	return (args) -> {
	


	Survey s1 = new Survey ("Kysely opilaiden tietämyksestä Suomesta", true);
		srepository.save(s1);
	
	Question q1 = new Question("option","Who is the president of Finland?", true, true, s1);
	Question q2 = new Question("option","Who is the prime minister of Finland?", true, true, s1);
		qrepository.save(q1);
		qrepository.save(q2);
	
	
	Answer a1 = new Answer("Sauli Niinistö", q1);
	Answer a11 = new Answer("En osaa sanoa", q1);
	Answer a2 = new Answer("Sanna Marin", q2);
		arepository.save(a1);
		arepository.save(a11);
		arepository.save(a2);

		
		
	
		
		
	};
	}
}
//TESTING