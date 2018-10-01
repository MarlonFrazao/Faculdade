package br.edu.unifacear.projetointegrador4.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;

public class DAOGenerico<T extends DAO>{
	
	public void inserir(T t) {		
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			
		}catch(Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
		
	}
	
	public T obter(Class<T> classe, Long id) {
		EntityManager em = new ConnectionFactory().getConnection();
		T t = null;
		
		try {
			t = em.find(classe, id);
		}catch(Exception e){
			System.err.println(e);
		}finally {
			em.close();
		}
		return t;
	}
	
	public void atualizar(T t) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();

			em.merge(t);

			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);

			em.getTransaction().rollback();
		} finally {

			em.close();
		}
	}
	
	public void excluir(T t) {
		EntityManager em = new ConnectionFactory().getConnection();

		
		t.setStatus(false);
		
		try {
			em.getTransaction().begin();

			em.merge(t);

			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);

			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}
}
