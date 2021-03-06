package br.edu.unifacear.projetointegrador4.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.model.entity.LinhaDeVeiculo;
import br.edu.unifacear.projetointegrador4.model.entity.Modelo;
import br.edu.unifacear.projetointegrador4.model.entity.Montadora;
import br.edu.unifacear.projetointegrador4.model.entity.Peca;

public class ModeloDAO extends DAOGenerico<Modelo> {
	
	public List<Modelo> obter(String descricao){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Modelo> lista = null;
		
		try {
			lista = em.createQuery("from Modelo WHERE descricao like '%"+descricao+"%'").getResultList();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return lista;
	}
	
	public List<Modelo> listar(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Modelo> lista = null;
		try {
			lista = em.createQuery("from Modelo").getResultList();
			
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return lista;
	}
	
	public List<Modelo> obter(LinhaDeVeiculo ldv){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Modelo> lista = null;
		
		try {
			lista = em.createQuery("from Modelo WHERE linha_id = " + ldv.getId()).getResultList();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return lista;
	}
	
	public List<Modelo> obter(Montadora montadora){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Modelo> lista = null;
		
		try {
			lista = em.createQuery("from Modelo WHERE montadora_id = " + montadora.getId()).getResultList();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return lista;
	}
	
	public List<Modelo> obter (Integer ano){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Modelo> lista = null;
		
		try {
			lista = em.createQuery("from modelo WHERE ano = " + ano).getResultList();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return lista;
	}

	
	public List<Modelo> obter(Peca peca) {
		EntityManager em = new ConnectionFactory().getConnection();
		List<Modelo> lista = null;

		try {
			//lista = em.createQuery("from modelo m join fetch m.peca p WHERE p.id  =" + peca.getId()).getResultList();
			lista = em.createQuery("from Modelo m join fetch m.peca_modelo p WHERE peca_id=" + peca.getId()).getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return lista;
	}

}
