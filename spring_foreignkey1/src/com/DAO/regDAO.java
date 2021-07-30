package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.LoginVo;
import com.model.RegVo;

@Repository
public class regDAO {

	@Autowired
	private SessionFactory sf;

	public void insertLogin(LoginVo lv) {
		// TODO Auto-generated method stub
		try {
			Session s = sf.openSession();
			Transaction t = s.beginTransaction();
			s.saveOrUpdate(lv);
			t.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertReg(RegVo rv) {
		// TODO Auto-generated method stub
		try {
			Session s = sf.openSession();
			Transaction t = s.beginTransaction();
			s.saveOrUpdate(rv);
			t.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public List SearchReg() {
		List ls=new ArrayList();
		Session s = sf.openSession();
		Query q=s.createQuery("from RegVo");
		ls=q.list();
		s.close();
		return ls;
		
	}
	public void delete(RegVo rv) {
		
		try {
			Session s = sf.openSession();
			Transaction t = s.beginTransaction();
			s.delete(rv);
			t.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void deleteLogin(LoginVo lv) {
		// TODO Auto-generated method stub
		try {
			Session s = sf.openSession();
			Transaction t = s.beginTransaction();
			s.delete(lv);
			t.commit();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public List edit(RegVo rv) {
		
		
		List ls=new ArrayList();
		Session s = sf.openSession();
		Query q=s.createQuery("from RegVo where id="+rv.getId());
		ls=q.list();
		s.close();
		return ls;
	}

}
