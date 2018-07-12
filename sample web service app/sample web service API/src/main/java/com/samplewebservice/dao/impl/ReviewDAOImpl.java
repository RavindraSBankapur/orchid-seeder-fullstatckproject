package com.reviewandratings.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
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
		cr.addOrder(Order.desc("createdTimestamp"));
		return cr.list();
	}
	
	@Override
	@Transactional
	public List<Object[]> getRatings(String moduleId){
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT ratings,COUNT(ratings)  FROM reviews WHERE moduleToken = '"+moduleId+"' and ratings > 0 and ratings < 6 GROUP BY ratings ORDER BY ratings ASC";
		Query query = session.createSQLQuery(sqlQuery);
		return query.list();
		
	}
	
	@Override
	@Transactional
	public int getTotalReviewsCount(String moduleId){
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT * FROM reviews WHERE moduleToken = '"+moduleId+"'";
		Query query = session.createSQLQuery(sqlQuery);
		return query.list().size();
	}

}
