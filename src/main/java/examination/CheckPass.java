package examination;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CheckPass {

	public boolean checkPass(String pass) throws Exception {
		Session session = Meniu.factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();

		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Admin> cr = cb.createQuery(Admin.class);
		Root<Admin> root = cr.from(Admin.class);
		Query<Admin> query = session.createQuery(cr);
		
		Admin admin = query.getSingleResult();
		
		String stored = admin.getPass();
		
		if (Password.check(pass,stored)) {
			tx.commit();
			session.close();
			return true;
		}
		else {
			tx.commit();
			session.close();
			return false;
		}
		
	}
	
	public void savePass(String pass) throws Exception {
		
		String passToSave = Password.getSaltedHash(pass);
		
		Session session = Meniu.factory.openSession();
		
		Transaction tx = null;
		tx = session.beginTransaction();
		
		Admin admin = new Admin(passToSave);
		session.save(admin);

		tx.commit();
		session.close();
	}
}
