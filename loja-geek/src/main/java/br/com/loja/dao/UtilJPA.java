package br.com.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilJPA {
	
private static  EntityManagerFactory emf =  Persistence.createEntityManagerFactory("loja-geek");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	public static void closeEntityManagerFactory() {
		emf.close();
	}
}
