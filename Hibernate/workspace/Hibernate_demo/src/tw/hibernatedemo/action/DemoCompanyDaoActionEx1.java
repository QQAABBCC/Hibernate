package tw.hibernatedemo.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.model.CompanyDAO;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoCompanyDaoActionEx1 {
	
	//先取得連線,再try catch 開啟連線,有begin就會有commit,如果錯了rollback
	//再做insert動作 
	//把DAO實體化 所以要NEW他 再給一個名字dao 再把Bean實體化 然後把要增加的東西帶進去
	//做update最簡單!!!
	

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//先New 把Dao實體化 才能做CRUD
			CompanyDAO dao = new CompanyDAO(session);
			
			
//			dao.insert(new CompanyBean(1003,"twitter"));
			
//			dao.updateOne(1003, "Block");
			
			
			//做select,要回傳東西給我們,所以要給名字 然後判斷是不是null 不是就給我們印出來
//			CompanyBean com1 =  dao.select(1003);
//			if(com1 != null) {
//				System.out.println(com1.getCompanyId() + " " + com1.getCompanyName());
//			}
			
//			boolean boo = dao.deleteOne(1003);
			
			List<CompanyBean> LCB = dao.selectAll();
			for(CompanyBean com :LCB) {
				System.out.println(com.getCompanyId() + " " + com.getCompanyName());
			}
			session.getTransaction().commit();
		}catch(Exception e){
			System.out.println("Something wrong and rollback!!");
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

}
