package tw.hibernatedemo.service;

import java.util.List;

import org.hibernate.Session;

import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.model.CompanyDAO;

public class CompanyService implements CompanyServiceInterface {
	private CompanyDAO comDao;
	
	public CompanyService(Session session) {
		comDao = new CompanyDAO(session);
	}
	
	@Override
	public CompanyBean select(int comId) {
	CompanyBean theCom = comDao.select(comId);
	return theCom;
	
	}

	@Override
	public List<CompanyBean> selectAll() {
//		1.
//	List<CompanyBean> theComs = comDao.selectAll();
//		return theComs;
//		2.
		return comDao.selectAll();
	}

	@Override
	public CompanyBean insert(CompanyBean comBean) {
		CompanyBean oneCom = comDao.insert(comBean);
		return oneCom;
	}

	@Override
	public boolean delete(int comId) {
		boolean boo =comDao.deleteOne(comId);
		return boo;
	}

	@Override
	public CompanyBean updateOne(int comId, String newName) {
		 CompanyBean oneCom= comDao.updateOne(comId , newName);
		return oneCom;
	}

}
