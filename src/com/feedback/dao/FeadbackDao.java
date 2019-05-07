package com.feedback.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.feadback.bean.Regbean;

@Repository
public class FeadbackDao {
	
	@Autowired
	SessionFactory factory;
	
	@Transactional
	public void store(Regbean reg) {
		Session session=factory.getCurrentSession();
		session.save(reg);
	}

	@Transactional
	public void delete(int id) {
		Session session=factory.getCurrentSession();
		Regbean del=(Regbean) session.get(Regbean.class, id);
		session.delete(del);
		
	}
	@Transcational
	public List<Regbean> getReg() {
		Session session=factory.getCurrentSession();
		List<Regbean> reg=session.createQuery("from Regbean").list();
		return reg;
	}
}
