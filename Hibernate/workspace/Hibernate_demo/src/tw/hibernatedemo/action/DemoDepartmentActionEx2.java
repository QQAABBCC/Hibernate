package tw.hibernatedemo.action;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoDepartmentActionEx2 {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session = factory.openSession();
		
		session.beginTransaction();//ιεδΊ€ζ
		
		Department d2 = new Department("RD");
		session.save(d2);
		
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();

	}

}
