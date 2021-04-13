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
	
<<<<<<< HEAD

	Survey s1 = new Survey (1,"Kysely opilaiden tietämyksestä Suomesta", 10, true);
	Question q1 = new Question(2,"option","Who is the president of Finland?", true, true);
	Answer a1 = new Answer("Sauli Niinistö", q1);

		qrepository.save(q1);
		srepository.save(s1);
		arepository.save(a1);
		
=======
		Question q1 = new Question(1,"option","Who is the president of Finland?","Sauli Niinistö" ,true, true);
		Question q2 = new Question(2,"option","Who is the prime minister of Finland?","Sanna Marin" ,true, true);
	
		List<Question> qList = new ArrayList<>();
		qList.add(q1);
		qList.add(q2);
		
		Survey s1 = new Survey (1,"Kysely opilaiden tietämyksestä Suomesta", 10, true);
		Survey s2 = new Survey ("Kysely opilaiden tietämyksestä Suomesta", 10, true, qList);
	
		qrepository.save(q1);
		srepository.save(s1);
		srepository.save(s2);
>>>>>>> 3bb1003cef097491cd6182bcaefd194f865da68e
		
	};
	}
}
//TESTING