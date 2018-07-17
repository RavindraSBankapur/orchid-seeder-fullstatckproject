package com.orchid.dao.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.orchid.dao.UserDAO;
import com.orchid.model.UserEntity;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl() {
		System.out.println("User DAO Impl crearted..");
	}

	@Override
	public int registerUser(UserEntity userEntity) {

		Session session = sessionFactory.getCurrentSession();
		int id = (int) session.save(userEntity);
		return id;
	}
	
	@Override
	public UserEntity logoutService(UserEntity userEntity) {
		return null;
	}

	@Override
	public UserEntity getUserDetails(String emailId, long mobileNumber, String password) {
		Session session = sessionFactory.getCurrentSession();
		/*
		 * It is possible to assign the list of fixed values to fetch data from the database by the use of map
		Map<String , Object> userProperties  = new LinkedHashMap<String, Object>();
		userProperties.put("emailId", emailId);
		userProperties.put("mobileNumber", mobileNumber);
		Criterion userCri = Restrictions.allEq(userProperties);
		*/
		Criterion userCri=Restrictions.or(Restrictions.eq("emailId", emailId), Restrictions.eq("mobileNumber", mobileNumber));
		Criteria cri = session.createCriteria(UserEntity.class).add(userCri);
		
		return (UserEntity) cri.uniqueResult();
	}

	@Override
	public List<UserEntity> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		Criteria cri = session.createCriteria(UserEntity.class);
		List<UserEntity> list = (List<UserEntity>) cri.list();
		List<UserEntity> userList = list;
		return userList;
	}

	@Override
	public UserEntity getUserById(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Criterion userCri = Restrictions.eq("userId", userId);
		Criteria cri = session.createCriteria(UserEntity.class).add(userCri);
		UserEntity userEntity = (UserEntity) cri.uniqueResult();
		return userEntity;
	}

	@Override
	public UserEntity getUserByEmailID(String emailId) {

		Session session=sessionFactory.getCurrentSession();
		Criterion userCri = Restrictions.eq("emailId", emailId);
		Criteria cri = session.createCriteria(UserEntity.class).add(userCri);
		UserEntity userEntity = (UserEntity) cri.uniqueResult();
		return userEntity;
	}
	
	
}
