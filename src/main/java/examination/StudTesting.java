package examination;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

public class StudTesting {

	public void studTesting() {
		Scanner sc = new Scanner(System.in);
		Session session = Meniu.factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Test> cr = cb.createQuery(Test.class);
		
		Root<Test> root = cr.from(Test.class);
		
		Query<Test> query = session.createQuery(cr);
		
		List<Test> testAll = query.getResultList();
		
		System.out.println("Iveskite varda");
		String tempName = sc.nextLine();
		System.out.println("Iveskite pavarde");
		String tempSur = sc.nextLine();
		Student student = new Student(tempName, tempSur);
		
		System.out.println("Iveskite testo, kuri norite laikyti, nr.:");
		for (Test test: testAll) {
			System.out.println("Testo nr: ["+test.getNr()+"] " + test.getName());
		}
		int modNr = sc.nextInt();
		sc.nextLine();
		
		Test test = testAll.get(modNr-1);

		HashMap<Integer,Integer> tempAllAns = new HashMap<Integer, Integer>();
		int tempMarks = 0;
		String tempResult;
		
		for (int i = 0; i< test.getQuestion().size(); i++) {
			System.out.println("["+test.getQuestion().get(i).getNr() + "] klausimas: " + test.getQuestion().get

(i).getQuestion());
			System.out.println("Galimi atsakymai: ");
			for(int j = 0; j < test.getQuestion().get(i).getAnswer().size(); j++) {
				System.out.println("["+test.getQuestion().get(i).getAnswer().get(j).getNr() 
						+ "] atsakymas: " + test.getQuestion().get(i).getAnswer().get

(j).getVairiant());
			}
			System.out.println("Iveskite savo atsakymo nr.:");
			int tempAtsNr = sc.nextInt();
			tempAllAns.put(i, tempAtsNr);
			if (test.getQuestion().get(i).getAnswer().get(tempAtsNr-1).isCorrect() == true) tempMarks++;
		}
		if (tempMarks >= test.getQuestion().size()/2) tempResult = "PASS";
		else tempResult = "FALL";
		
		Testing testing = new Testing(tempMarks, tempResult, tempAllAns);
		
		List <Testing> tempTesting = new ArrayList<Testing>();
		tempTesting.add(testing);
		
		
		student.setTesting(tempTesting);
		testing.setStudent(student);
	    testing.setTest(test);
	    session.save(student);


		tx.commit();
		session.close();
		System.out.println("Jusu rezultatas issaugotas duomenu bazeje.\n"
				+ "");
	}
}

