package br.edu.unifacear.projetointegrador4.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.entity.LinhaDeVeiculo;
import br.edu.unifacear.projetointegrador4.entity.Modelo;
import br.edu.unifacear.projetointegrador4.entity.Montadora;

public class ModeloDAO implements DAO<Modelo> {
	
	@Override
	public void inserir(Modelo modelo) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			if(modelo.getId()==null) {
				em.persist(modelo);
			}else {
				em.merge(modelo);
			}
			em.getTransaction().commit();
			
		}catch(Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
	}
	
	@Override
	public Modelo obter (Long id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Modelo modelo = null;
		
		try {
			modelo = em.find(Modelo.class, id);
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return modelo;
	}
	
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
	
	@Override
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

	@Override
	public void atualizar(Modelo m) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();

			em.merge(m);

			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);

			em.getTransaction().rollback();
		} finally {

			em.close();
		}
		
	}

	@Override
	public void excluir(Modelo m) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		m.setStatus(false);
		
		try {
			em.getTransaction().begin();

			em.merge(m);

			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);

			em.getTransaction().rollback();
		} finally {

			em.close();
		}
		
	}
	

}
