package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.service.CompanyService;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoCompanyServiceActionEx1 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			
			CompanyService comService = new CompanyService(session);
			
//			 CompanyBean comBean = comService.select(1002);
//			 System.out.println(comBean.getCompanyId() + "  " + comBean.getCompanyName());
			
//			 CompanyBean comBean= comService.insert(new CompanyBean(1011,"Metadata"));
//			System.out.println(comBean.getCompanyId());
//			System.out.println(comBean.getCompanyName());
			
			
			
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			e.printStackTrace();
			
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}