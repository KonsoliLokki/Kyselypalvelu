package com.Kyselypalvelu;

import java.util.ArrayList;
import java.util.List;

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

			// Question types
			QuestionType qtRadio = new QuestionType("radio");
			QuestionType qtText = new QuestionType("text");
			qtrepository.save(qtRadio);
			qtrepository.save(qtText);

			// Question 1
			Question q1 = new Question(qtRadio, "Kuka on suomen presidentti?", true, true, s1);
			qrepository.save(q1);

			Choice choice1 = new Choice("Matti", q1);
			Choice choice2 = new Choice("Sauli Niinistö", q1);
			Choice choice3 = new Choice("Pirkko", q1);
			Choice choice4 = new Choice("Katri-Helena", q1);
			crepository.save(choice1);
			crepository.save(choice2);
			crepository.save(choice3);
			crepository.save(choice4);
			List<Choice> choiceList = new ArrayList<>();
			q1.setChoices(choiceList);
			qrepository.save(q1);
			
			// Question 2
			Question q2 = new Question(qtText, "Kuka on suomen pääministeri?", true, true, s1);
			qrepository.save(q2);

			// Question 3
			Question q3 = new Question(qtRadio, "Kuka on ruotsin kuningas?", true, true, s1);
			qrepository.save(q1);

			Choice choice5 = new Choice("Pete", q1);
			Choice choice6 = new Choice("Markku", q1);
			Choice choice7 = new Choice("Kaarle XVI Kustaa", q1);
			Choice choice8 = new Choice("Sauli Niinistö", q1);
			crepository.save(choice5);
			crepository.save(choice6);
			crepository.save(choice7);
			crepository.save(choice8);
			List<Choice> choiceList2 = new ArrayList<>();
			q1.setChoices(choiceList2);
			qrepository.save(q3);
			
			// Answers
			Answer a1 = new Answer("Pirkko", q1);
			Answer a11 = new Answer("En osaa sanoa", q2);
			Answer a2 = new Answer("Sanna Marin", q2);
			Answer a3 = new Answer("Pete", q3);
			Answer a4 = new Answer("Kaarle XVI Kustaa", q3);
			arepository.save(a1);
			arepository.save(a11);
			arepository.save(a2);
			arepository.save(a3);
			arepository.save(a4);

		};
	}
}
//TESTING