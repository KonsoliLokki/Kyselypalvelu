package com.Kyselypalvelu;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	public CommandLineRunner demo(SurveyRepository srepository, QuestionRepository qrepository) {
	return (args) -> {
	
	Survey s1 = new Survey (1,"Kysely opilaiden tietämyksestä Suomesta", 10, true);
	Question q1 = new Question(2,"option","Who is the president of Finland?","Sauli Niinistö" ,true, true);
		
		qrepository.save(q1);
		srepository.save(s1);
		
	};
	}
}
//TESTING