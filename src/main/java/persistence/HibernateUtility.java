package persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtility {
	private static SessionFactory factory;

	private HibernateUtility(){
		
	}
	
	static {
		Configuration cfg = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		factory = cfg.buildSessionFactory(serviceRegistry);
	}
	
	public static SessionFactory getSessionFactory(){
		return factory;
	}
}
