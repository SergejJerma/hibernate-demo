package examination;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputTest {

	static int testNr = 1;
	
	public void inputTestInfo(){
		Scanner sc = new Scanner(System.in);
		
		Session session = Meniu.factory.openSession();
		
		Transaction tx = null;

		tx = session.beginTransaction();
		
		System.out.println("Iveskite testo pavadinima: ");
		String testName = sc.nextLine();
		System.out.println("Iveskite testo klausimu skaiciu: ");
		int klausSk = sc.nextInt();
		Test test = new Test(testNr++, testName);
		sc.nextLine();
		
		List<Question> tempQues = new ArrayList<Question>();
		List<Answer> tempAnsw = new ArrayList<Answer>();
		
		for (int i = 1; i<= klausSk; i++) {
		System.out.println("Iveskite "+i+" klausima");
		String quesBody = sc.nextLine();
		Question question = new Question(i, quesBody);
		for (int j = 1; j<=3; j++) {
			System.out.println("Iveskite atsakymo " + j +" varianta");
			String tempA = sc.nextLine();
			System.out.println("Ar atsakymo variantas nr. " + j +" teisingas? (true/false)");
			boolean tempC = sc.nextBoolean();
			String tempBag = sc.nextLine();
			Answer answer = new Answer(j, tempA, tempC);
			tempAnsw.add(answer);
			answer.setQuestion(question);
		}
		question.setAnswer(tempAnsw);
		tempQues.add(question);
		question.setTest(test);
		}
		test.setQuestion(tempQues);
		
		session.save(test);

		tx.commit();
		session.close();
		System.out.println("Testas issaugotas duomenu bazeje. \n"
				+ "");
		
	}
}

