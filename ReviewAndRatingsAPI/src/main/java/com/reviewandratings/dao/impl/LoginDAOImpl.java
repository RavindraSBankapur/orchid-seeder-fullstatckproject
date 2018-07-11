package com.reviewandratings.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewandratings.dao.LoginDAO;
import com.reviewandratings.model.UserEntity;

@Repository
public class LoginDAOImpl implements LoginDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public UserEntity getUserDetails(String emailId){
		Session session = sessionFactory.getCurrentSession();
		Criterion emailIdCri = Restrictions.eq("emailId", emailId);
		Criteria cri = session.createCriteria(UserEntity.class).add(emailIdCri);
		return (UserEntity) cri.uniqueResult();
	}
}
