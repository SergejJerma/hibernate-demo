package examination;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Scanner;

public class ModifyTest{

	public void modifyTest() {
		Scanner sc = new Scanner(System.in);
		
		Session session = Meniu.factory.openSession();
		
		Transaction tx = null;
		tx = session.beginTransaction();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Test> cr = cb.createQuery(Test.class);
		
		Root<Test> root = cr.from(Test.class);
		
		Query<Test> query = session.createQuery(cr);
		
		List<Test> testAll = query.getResultList();
		
		System.out.println("Iveskite testo, kuri norite redaguoti, nr.:");
		for (Test test: testAll) {
			System.out.println("Klausimo nr: ["+test.getNr()+"] " + test.getName());
		}
		int modNr = sc.nextInt();
		sc.nextLine();
		
		Test test = testAll.get(modNr-1);
		
		System.out.println("Iveskite klausimo, kuri norite redaguoti, nr.:");
		List<Question> allQues = test.getQuestion();
		for(Question ques : allQues) {
			System.out.println("Klausimo nr: ["+ques.getNr()+"] " + ques.getQuestion());
		}
		modNr = sc.nextInt();
		sc.nextLine();
		System.out.println("Iveskite nauja klausima");
		String modQues = sc.nextLine();
		test.getQuestion().get(modNr-1).setQuestion(modQues);
		
		for (int i = 1; i <= test.getQuestion().get(modNr-1).getAnswer().size();i++) {
			System.out.println("Iveskite atsakymo " + i +" varianta");
			String tempA = sc.nextLine();
			test.getQuestion().get(modNr-1).getAnswer().get(i-1).setVairiant(tempA);
			System.out.println("Ar atsakymo variantas nr. " + i +" teisingas? (true/false)");
			boolean tempC = sc.nextBoolean();
			sc.nextLine();
			test.getQuestion().get(modNr-1).getAnswer().get(i-1).setCorrect(tempC);
			
		}
	
		System.out.println("Pakeitimai issaugoti /n");
		session.save(test);

			tx.commit();
		
	//		sc.close();
		
		session.close();
	}
}


