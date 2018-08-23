package br.edu.unifacear.projetointegrador4.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	//criando a fabrica do entityManager
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("prj_integrador_IV_PU");
	
	
	public EntityManager getConnection () {
		
		
		return emf.createEntityManager();
	}
}
