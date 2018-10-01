package br.edu.unifacear.projetointegrador4.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.model.entity.Aplicacao;

public class AplicacaoDAO extends DAOGenerico<Aplicacao> {
	
	public List<Aplicacao> obter(String descricao){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Aplicacao> lista = null;		
		try {
			lista = em.createQuery("from Aplicacao WHERE descricao like '%"+descricao+"%'").getResultList();
			
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return lista;
	}
	
	public List<Aplicacao> listar(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Aplicacao> lista = null;
		
		try {
			lista = em.createQuery("from Aplicacao").getResultList();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return lista;
	}

}
