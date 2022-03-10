package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoDepartmentActionEx5 {
	//老方法
	//要把tx 先丟到外面 設為null
	//catch裡的rollback才會吃到也才能執行。

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session =  factory.getCurrentSession();
		
		Transaction tx =null;
		try {
			tx = session.beginTransaction();
			
			Department dep = new Department("clothes");
			session.save(dep);
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}
