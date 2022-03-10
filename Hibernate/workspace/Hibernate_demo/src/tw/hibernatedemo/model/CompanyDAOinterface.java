package tw.hibernatedemo.model;

import java.util.List;
//介面 interface
public interface CompanyDAOinterface {
	CompanyBean insert(CompanyBean comBean);
	CompanyBean select(int comid);
	List<CompanyBean>selectAll();//用list搜尋整筆資料
	CompanyBean updateOne(int comId , String comName); //特過xx搜尋,要更新的資料
	boolean deleteOne(int comId);//Id或者Bean都可以
}
