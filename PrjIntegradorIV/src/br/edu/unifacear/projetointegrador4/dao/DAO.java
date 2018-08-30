package br.edu.unifacear.projetointegrador4.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;

public interface DAO{
	
	public Long getId();

	void setStatus(Boolean status);
			
}
