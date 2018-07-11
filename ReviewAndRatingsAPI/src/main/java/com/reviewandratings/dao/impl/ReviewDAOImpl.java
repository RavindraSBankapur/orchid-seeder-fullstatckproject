package com.reviewandratings.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewandratings.dao.ReviewDAO;
import com.reviewandratings.model.ReviewEntity;

@Repository
public class ReviewDAOImpl implements ReviewDAO{
	
	@Autowired 
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public int addReview(ReviewEntity reviewEntity) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(reviewEntity);
	}
	
	@Override
	@Transactional
	public List<ReviewEntity> getReviews(){
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(ReviewEntity.class);
		return cr.list();
	}

}
