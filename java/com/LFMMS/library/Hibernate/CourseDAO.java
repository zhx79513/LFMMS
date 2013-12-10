package com.LFMMS.library.Hibernate;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A data access object (DAO) providing persistence and search support for Course entities.
 * Transaction control of the save(), update() and delete() operations can directly support
 * Spring container-managed transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how to configure it
 * for the desired type of transaction control.
 * 
 * @see com.LFMMS.library.Hibernate.Course
 * @author MyEclipse Persistence Tools
 */

public class CourseDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CourseDAO.class);
	// property constants
	public static final String TURN = "turn";
	public static final String HOME_SCORE = "homeScore";
	public static final String AWAY_SCORE = "awayScore";

	public void save(Course transientInstance) {

		log.debug("saving Course instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Course persistentInstance) {

		log.debug("deleting Course instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Course findById(java.lang.Integer id) {

		log.debug("getting Course instance with id: " + id);
		try {
			Course instance = (Course) getSession().get("com.LFMMS.library.Hibernate.Course", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Course> findByExample(Course instance) {

		log.debug("finding Course instance by example");
		try {
			List<Course> results = (List<Course>) getSession()
					.createCriteria("com.LFMMS.library.Hibernate.Course").add(create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {

		log.debug("finding Course instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Course as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Course> findByTurn(Object turn) {

		return findByProperty(TURN, turn);
	}

	public List<Course> findByHomeScore(Object homeScore) {

		return findByProperty(HOME_SCORE, homeScore);
	}

	public List<Course> findByAwayScore(Object awayScore) {

		return findByProperty(AWAY_SCORE, awayScore);
	}

	public List findAll() {

		log.debug("finding all Course instances");
		try {
			String queryString = "from Course";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Course merge(Course detachedInstance) {

		log.debug("merging Course instance");
		try {
			Course result = (Course) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Course instance) {

		log.debug("attaching dirty Course instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Course instance) {

		log.debug("attaching clean Course instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}