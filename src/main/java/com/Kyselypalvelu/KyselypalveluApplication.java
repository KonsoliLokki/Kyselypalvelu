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

	// SURVEY 1 and Questions and Answers
			Survey s1 = new Survey("Kysely oppilaiden tietämyksestä Suomesta", true);
			srepository.save(s1);
			
		// Question types
			QuestionType qtRadio = new QuestionType("radio");
			QuestionType qtText = new QuestionType("text");
			qtrepository.save(qtRadio);
			qtrepository.save(qtText);

		// Question 1 for survey 1 (s1)
			Question q1 = new Question(qtRadio, "Kuka on suomen presidentti?", true, true, s1);
			qrepository.save(q1);
		// Choices for question 1
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
			
		// Question 2 for survey 1
			Question q2 = new Question(qtText, "Kuka on suomen pääministeri?", true, true, s1);
			qrepository.save(q2);

		// Question 3 for survey 1
			Question q3 = new Question(qtRadio, "Kuka on ruotsin kuningas?", true, true, s1);
			qrepository.save(q3);
		// Choices for question 3
			Choice choice5 = new Choice("Pete", q3);
			Choice choice6 = new Choice("Markku", q3);
			Choice choice7 = new Choice("Kaarle XVI Kustaa", q3);
			Choice choice8 = new Choice("Sauli Niinistö", q3);
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
	// SURVEY 1 ENDS
			
	// SURVEY 2 STARTS
			Survey s2 = new Survey("Ruokala kysely", true);
			srepository.save(s2);
			
		// Questions 1 (q10) for survey 2 (s2)
			Question q11 = new Question(qtRadio, "Piditkö tämän päivän ruuista?", true, true, s2);
			qrepository.save(q11);
			// Choices for question 1
			Choice choice10 = new Choice("Maukasta", q11);
			Choice choice11 = new Choice("Hyvää", q11);
			Choice choice12 = new Choice("Ihan OK", q11);
			Choice choice13 = new Choice("Ei maistunut :(", q11);
			crepository.save(choice10);
			crepository.save(choice11);
			crepository.save(choice12);
			crepository.save(choice13);
			List<Choice> choiceList10 = new ArrayList<>();
			q11.setChoices(choiceList10);
			qrepository.save(q11);
			
		// Question 2 for survey 2 (s2)
			Question q12 = new Question(qtText, "Mitä ruokaa toivoisit enemmän ja mistä et niin pidä?", true, true, s2);
			qrepository.save(q12);
			
		// Question 3 for survey 2 (s2)
			Question q13 = new Question(qtText, "Miten tyytyväinen olit palvelun sujuvuuteen?", true, true, s2);
			qrepository.save(q13);
			
		// Questions 4 for survey 2 (s2)
			Question q14 = new Question(qtRadio, "Kuinka usein syöt ruokalassa?", true, true, s2);
			qrepository.save(q14);
		// Choices for question 4 
			Choice choice14 = new Choice("3-5 kertaa/vko", q14);
			Choice choice15 = new Choice("1-3 kertaa/vko", q14);
			Choice choice16 = new Choice("Harvemmin", q14);
			crepository.save(choice14);
			crepository.save(choice15);
			crepository.save(choice16);
			List<Choice> choiceList11 = new ArrayList<>();
			q14.setChoices(choiceList11);
			qrepository.save(q14);
			
		// Questions 5 for survey 2 (s2)
			Question q15 = new Question(qtRadio, "Onko hintalaatusuhde mielestäsi sopiva?", true, true, s2);
			qrepository.save(q15);
		// Choices for question 4 
			Choice choice17 = new Choice("Kyllä", q15);
			Choice choice18 = new Choice("Ei", q15);
			crepository.save(choice17);
			crepository.save(choice18);
			List<Choice> choiceList12 = new ArrayList<>();
			q15.setChoices(choiceList12);
			qrepository.save(q15);
			
		// Question 6 for survey 2 (s2)
			Question q16 = new Question(qtText, "Vapaa palaute", true, true, s2);
			qrepository.save(q16);
	// SURVEY 2 ENDS
		};
	}
}
//TESTING