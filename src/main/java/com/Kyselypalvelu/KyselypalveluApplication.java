package com.Kyselypalvelu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Kyselypalvelu.domain.Answer;
import com.Kyselypalvelu.domain.AnswerRepository;
import com.Kyselypalvelu.domain.Choice;
import com.Kyselypalvelu.domain.ChoiceRepository;
import com.Kyselypalvelu.domain.Question;
import com.Kyselypalvelu.domain.QuestionRepository;
import com.Kyselypalvelu.domain.QuestionType;
import com.Kyselypalvelu.domain.QuestionTypeRepository;
import com.Kyselypalvelu.domain.Survey;
import com.Kyselypalvelu.domain.SurveyRepository;

@SpringBootApplication
public class KyselypalveluApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyselypalveluApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(SurveyRepository srepository, QuestionRepository qrepository,
			AnswerRepository arepository, QuestionTypeRepository qtrepository, ChoiceRepository crepository) {
		return (args) -> {

			Survey s1 = new Survey("Kysely oppilaiden tietämyksestä Suomesta", true);
			srepository.save(s1);

			QuestionType qtRadio = new QuestionType("radio");
			QuestionType qtText = new QuestionType("text");
			qtrepository.save(qtRadio);
			qtrepository.save(qtText);

			Question q1 = new Question(qtRadio, "Who is the president of Finland?", true, true, s1);
			Question q2 = new Question(qtText, "Who is the prime minister of Finland?", true, true, s1);
			qrepository.save(q1);
			qrepository.save(q2);

			Choice choice1 = new Choice("Matti", q1);
			Choice choice2 = new Choice("Pekka", q1);
			Choice choice3 = new Choice("Pirkko", q1);
			Choice choice4 = new Choice("Katri-Helena", q1);
			crepository.save(choice1);
			crepository.save(choice2);
			crepository.save(choice3);
			crepository.save(choice4);

			Answer a1 = new Answer("Pirkko", q1);
			Answer a11 = new Answer("En osaa sanoa", q2);
			Answer a2 = new Answer("Sanna Marin", q2);
			arepository.save(a1);
			arepository.save(a11);
			arepository.save(a2);

		};
	}
}
//TESTING