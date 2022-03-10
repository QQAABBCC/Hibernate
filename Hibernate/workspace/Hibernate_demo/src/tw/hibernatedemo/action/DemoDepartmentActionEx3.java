package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoDepartmentActionEx3 {
    //getgurrentSession方法
	//hibernate.xml必須設定東西
	//橫跨多個DAO時用這個 EX:銀行領錢匯款等等~~
	//使用同一個Session物件
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		Session session =  factory.getCurrentSession();//從連線持拿連線
		
		try {
			session.beginTransaction();//開啟交易
			
			Department dp2 = new Department("sales");
			session.save(dp2);
			
			session.getTransaction().commit();
			
		}catch (Exception e){
			System.out.println("Something Wrong and Rollback!!!!");
			session.getTransaction().rollback();
			e.printStackTrace();
			
		}finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}
