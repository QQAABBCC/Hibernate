package tw.hibernatedemo.service;

import java.util.List;

import tw.hibernatedemo.model.CompanyBean;

public interface CompanyServiceInterface {
	
	CompanyBean select(int comId);
	List<CompanyBean>selectAll();
	CompanyBean insert(CompanyBean comBean);
	boolean delete(int comId);
	CompanyBean updateOne(int comId ,String conName);
}
