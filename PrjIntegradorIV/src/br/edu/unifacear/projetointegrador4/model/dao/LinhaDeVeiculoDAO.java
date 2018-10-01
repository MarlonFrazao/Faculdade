package br.edu.unifacear.projetointegrador4.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.model.entity.LinhaDeVeiculo;

public class LinhaDeVeiculoDAO extends DAOGenerico<LinhaDeVeiculo>{
		
	public List<LinhaDeVeiculo> obter(String descricao){
		EntityManager em = new ConnectionFactory().getConnection();
		List<LinhaDeVeiculo> lista = null;
		
		try {
			lista = em.createQuery("from LinhaDeVeiculo WHERE descricao like'%"+descricao+"%'").getResultList();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return lista;
	}
	
	public List<LinhaDeVeiculo> listar(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<LinhaDeVeiculo> lista = null;
		try {
			lista = em.createQuery("from LinhaDeVeiculo").getResultList();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return lista;
	}

}
