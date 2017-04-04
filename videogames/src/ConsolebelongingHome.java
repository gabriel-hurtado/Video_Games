// default package
// Generated 4 avr. 2017 18:57:41 by Hibernate Tools 5.1.0.Alpha1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Consolebelonging.
 * @see .Consolebelonging
 * @author Hibernate Tools
 */
public class ConsolebelongingHome {

	private static final Log log = LogFactory.getLog(ConsolebelongingHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Consolebelonging transientInstance) {
		log.debug("persisting Consolebelonging instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Consolebelonging instance) {
		log.debug("attaching dirty Consolebelonging instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Consolebelonging instance) {
		log.debug("attaching clean Consolebelonging instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Consolebelonging persistentInstance) {
		log.debug("deleting Consolebelonging instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Consolebelonging merge(Consolebelonging detachedInstance) {
		log.debug("merging Consolebelonging instance");
		try {
			Consolebelonging result = (Consolebelonging) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Consolebelonging findById(ConsolebelongingId id) {
		log.debug("getting Consolebelonging instance with id: " + id);
		try {
			Consolebelonging instance = (Consolebelonging) sessionFactory.getCurrentSession().get("Consolebelonging",
					id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Consolebelonging> findByExample(Consolebelonging instance) {
		log.debug("finding Consolebelonging instance by example");
		try {
			List<Consolebelonging> results = (List<Consolebelonging>) sessionFactory.getCurrentSession()
					.createCriteria("Consolebelonging").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
