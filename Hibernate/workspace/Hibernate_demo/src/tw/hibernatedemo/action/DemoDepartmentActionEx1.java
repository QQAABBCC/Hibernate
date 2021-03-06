package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernatedemo.model.Department;

public class DemoDepartmentActionEx1 {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		Session session = factory.openSession(); //開啟交易
		session.beginTransaction();//交易開始
		
		Department depart1 = new Department();//對應到SQL的表格,抓bean裡面的東西
		depart1.setDeptname("HR");
		session.save(depart1);//把HR儲存到depart1
		
		session.getTransaction().commit();//取得transaction物件,commit為送出summit得概念
		session.close();
		factory.close();
	}

}
