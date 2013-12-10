package com.LFMMS.library.Hibernate;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A data access object (DAO) providing persistence and search support for TeamRank entities.
 * Transaction control of the save(), update() and delete() operations can directly support
 * Spring container-managed transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how to configure it
 * for the desired type of transaction control.
 * 
 * @see com.LFMMS.library.Hibernate.TeamRank
 * @author MyEclipse Persistence Tools
 */

public class TeamRankDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TeamRankDAO.class);
	// property constants
	public static final String PLACE = "place";
	public static final String TURN = "turn";
	public static final String WIN = "win";
	public static final String EVEN = "even";
	public static final String LOST = "lost";
	public static final String GOAL = "goal";
	public static final String LOST_GOAL = "lostGoal";
	public static final String NET_GOAL = "netGoal";
	public static final String POINT = "point";

	public void save(TeamRank transientInstance) {

		log.debug("saving TeamRank instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TeamRank persistentInstance) {

		log.debug("deleting TeamRank instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TeamRank findById(java.lang.Integer id) {

		log.debug("getting TeamRank instance with id: " + id);
		try {
			TeamRank instance = (TeamRank) getSession().get("com.LFMMS.library.Hibernate.TeamRank",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TeamRank> findByExample(TeamRank instance) {

		log.debug("finding TeamRank instance by example");
		try {
			List<TeamRank> results = (List<TeamRank>) getSession()
					.createCriteria("com.LFMMS.library.Hibernate.TeamRank").add(create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {

		log.debug("finding TeamRank instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from TeamRank as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TeamRank> findByPlace(Object place) {

		return findByProperty(PLACE, place);
	}

	public List<TeamRank> findByTurn(Object turn) {

		return findByProperty(TURN, turn);
	}

	public List<TeamRank> findByWin(Object win) {

		return findByProperty(WIN, win);
	}

	public List<TeamRank> findByEven(Object even) {

		return findByProperty(EVEN, even);
	}

	public List<TeamRank> findByLost(Object lost) {

		return findByProperty(LOST, lost);
	}

	public List<TeamRank> findByGoal(Object goal) {

		return findByProperty(GOAL, goal);
	}

	public List<TeamRank> findByLostGoal(Object lostGoal) {

		return findByProperty(LOST_GOAL, lostGoal);
	}

	public List<TeamRank> findByNetGoal(Object netGoal) {

		return findByProperty(NET_GOAL, netGoal);
	}

	public List<TeamRank> findByPoint(Object point) {

		return findByProperty(POINT, point);
	}

	public List findAll() {

		log.debug("finding all TeamRank instances");
		try {
			String queryString = "from TeamRank";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TeamRank merge(TeamRank detachedInstance) {

		log.debug("merging TeamRank instance");
		try {
			TeamRank result = (TeamRank) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TeamRank instance) {

		log.debug("attaching dirty TeamRank instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TeamRank instance) {

		log.debug("attaching clean TeamRank instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}