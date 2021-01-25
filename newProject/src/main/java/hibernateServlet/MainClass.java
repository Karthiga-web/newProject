/**
 * 
 */
package hibernateServlet;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import entity.SweetsEntity;
import hibernate.HibernateUtils;

/**
 * @author grkar
 *
 */
public class MainClass {

	static Session hibernateSession;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			hibernateSession = HibernateUtils.buildSessionFactory().openSession();
			hibernateSession.beginTransaction();
			CriteriaBuilder builder = hibernateSession.getCriteriaBuilder();
			CriteriaQuery<SweetsEntity> criteria = builder.createQuery(SweetsEntity.class);
			criteria.from(SweetsEntity.class);
			List<SweetsEntity> sweets = hibernateSession.createQuery(criteria).getResultList();

			sweets.forEach((r) -> {
				System.out.println("r: " + r.getId() + " name:" + r.getName() + " price:" + r.getPrice());
				System.out.println("====================");
			});

			hibernateSession.getTransaction().commit();
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			if (null != hibernateSession.getTransaction()) {
				hibernateSession.getTransaction().rollback();
			}
		} finally {
			if (hibernateSession != null) {
				hibernateSession.close();
			}
		}
	}
}
