package br.edu.unifacear.projetointegrador4.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sa");
	
	public static EntityManager creatEntityManager() {
		return emf.createEntityManager();
	}
	
	
}
