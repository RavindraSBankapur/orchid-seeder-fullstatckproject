package com.reviewandratings.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reviewandratings.dao.LikeAndDislikeDAO;
import com.reviewandratings.model.LikeAndDislikeEntity;

@Repository
public class LikeAndDislikeDAOImpl implements LikeAndDislikeDAO{
	
	@Autowired 
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public int addLikeOrDislike(LikeAndDislikeEntity likeAndDislikeEntity) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(likeAndDislikeEntity);
	}
	
	@Override
	@Transactional
	public LikeAndDislikeEntity getLikeAndDislikeDeatils(int reviewId, int userId){
		Session session = sessionFactory.getCurrentSession();
		Criterion userIdCri = Restrictions.eq("likedOrDislikedBy", userId);
		Criterion reviewIdCri = Restrictions.eq("reviewId", reviewId);
		Criteria cri = session.createCriteria(LikeAndDislikeEntity.class).add(userIdCri).add(reviewIdCri);
		return (LikeAndDislikeEntity) cri.uniqueResult();
	}
	
	@Override
	@Transactional
	public int updateLikeOrDislike(int likeOrDislikeId, int isLikedByUser){
		Session session = sessionFactory.getCurrentSession();
		String hql = "update LikeAndDislikeEntity set likeOrDislikeStatus = :likeOrDislikeStatus where  likeOrDislikeId = :likeOrDislikeId";
		Query query = session.createQuery(hql);
		query.setParameter("likeOrDislikeStatus", isLikedByUser);
		query.setParameter("likeOrDislikeId", likeOrDislikeId);	
		return query.executeUpdate();
	}
	
	@Override
	@Transactional
	public int getTotalLikesCount(int reviewId){
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT * FROM likesAndDislikes WHERE reviewId = "+reviewId+" and likeOrDislikeStatus = 1";
		Query query = session.createSQLQuery(sqlQuery);
		return query.list().size();
	}
	
	@Override
	@Transactional
	public int getTotalDislikesCount(int reviewId){
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "SELECT * FROM likesAndDislikes WHERE reviewId = "+reviewId+" and likeOrDislikeStatus = 0";
		Query query = session.createSQLQuery(sqlQuery);
		return query.list().size();
	}
}
