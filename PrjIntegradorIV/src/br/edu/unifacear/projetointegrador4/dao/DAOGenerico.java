package br.edu.unifacear.projetointegrador4.dao;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;

public class DAOGenerico<T extends DAO>{
	
	private EntityManager em = new ConnectionFactory().getConnection();
	
	public void inserir(T t) {		
		
		
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
