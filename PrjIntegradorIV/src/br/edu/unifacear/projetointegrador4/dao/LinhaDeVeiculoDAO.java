package br.edu.unifacear.projetointegrador4.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.entity.LinhaDeVeiculo;

public class LinhaDeVeiculoDAO {
	
	public LinhaDeVeiculo inserir(LinhaDeVeiculo ldv) {
		
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			
			if(ldv.getId()==null) {
				em.persist(ldv);
			}else {
				em.merge(ldv);
			}
			em.getTransaction().commit();
			
		}catch(Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		return ldv;
		
	}
	
	public LinhaDeVeiculo obter(Long id) {
		EntityManager em = new ConnectionFactory().getConnection();
		LinhaDeVeiculo ldv = null;
		
		try {
			ldv = em.find(LinhaDeVeiculo.class, id);
		}catch(Exception e){
			System.err.println(e);
		}finally {
			em.close();
		}
		return ldv;
	}
	
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
