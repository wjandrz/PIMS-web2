package com.revature.PIMS;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.Reference;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.TypeHelper;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.engine.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;


public class SessionFactoryManager {
	
	// One SessionFactory per database
	private static SessionFactory sf;
	
	private SessionFactoryManager(){}
	
	public static synchronized SessionFactory getInstance(){
		if(sf == null) {
			// Instantiation of SessionFactory (3.6)
			sf = new Configuration().configure().buildSessionFactory();
		}
		return sf;
	}
	
}