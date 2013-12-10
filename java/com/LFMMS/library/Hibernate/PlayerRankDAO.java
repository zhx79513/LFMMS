package com.LFMMS.library.Hibernate;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A data access object (DAO) providing persistence and search support for PlayerRank entities.
 * Transaction control of the save(), update() and delete() operations can directly support
 * Spring container-managed transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how to configure it
 * for the desired type of transaction control.
 * 
 * @see com.LFMMS.library.Hibernate.PlayerRank
 * @author MyEclipse Persistence Tools
 */

public class PlayerRankDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(PlayerRankDAO.class);
	// property constants
	public static final String PLACE = "place";
	public static final String GOAL = "goal";

	public void save(PlayerRank transientInstance) {

		log.debug("saving PlayerRank instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PlayerRank persistentInstance) {

		log.debug("deleting PlayerRank instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlayerRank findById(java.lang.Integer id) {

		log.debug("getting PlayerRank instance with id: " + id);
		try {
			PlayerRank instance = (PlayerRank) getSession().get(
					"com.LFMMS.library.Hibernate.PlayerRank", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PlayerRank> findByExample(PlayerRank instance) {

		log.debug("finding PlayerRank instance by example");
		try {
			List<PlayerRank> results = (List<PlayerRank>) getSession()
					.createCriteria("com.LFMMS.library.Hibernate.PlayerRank").add(create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {

		log.debug("finding PlayerRank instance with property: " + propertyName + ", value: "
				+ value);
		try {
			String queryString = "from PlayerRank as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<PlayerRank> findByPlace(Object place) {

		return findByProperty(PLACE, place);
	}

	public List<PlayerRank> findByGoal(Object goal) {

		return findByProperty(GOAL, goal);
	}

	public List findAll() {

		log.debug("finding all PlayerRank instances");
		try {
			String queryString = "from PlayerRank";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PlayerRank merge(PlayerRank detachedInstance) {

		log.debug("merging PlayerRank instance");
		try {
			PlayerRank result = (PlayerRank) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PlayerRank instance) {

		log.debug("attaching dirty PlayerRank instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlayerRank instance) {

		log.debug("attaching clean PlayerRank instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}