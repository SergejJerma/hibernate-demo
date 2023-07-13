package examination;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class WorkWithData {
	public void workWithData() {
	Session session = Meniu.factory.openSession();
	Transaction tx = null;
	tx = session.beginTransaction();

	CriteriaBuilder cb = session.getCriteriaBuilder();
	CriteriaQuery<Testing> cr = cb.createQuery(Testing.class);
	
	Root<Testing> root = cr.from(Testing.class);
	
	Query<Testing> query = session.createQuery(cr);
	
	List<Testing> testingAll = query.getResultList();

	for (Testing element: testingAll) {
		System.out.println(element.getId());
	}
		session.close();
	}
}
