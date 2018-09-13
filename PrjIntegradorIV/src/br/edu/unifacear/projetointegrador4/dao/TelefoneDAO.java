package br.edu.unifacear.projetointegrador4.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.entity.Telefone;

public class TelefoneDAO {
	
	public void inserir(Telefone t) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			
			em.persist(t);
			
			em.getTransaction().commit();
		} catch(Exception e) {
			System.err.println(e);
			
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
	
	public void atualizar(Telefone t) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			
			em.merge(t);
			
			em.getTransaction().commit();
		}catch(Exception e) {
			System.err.println(e);
			
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
	
	public List<Telefone> listar() {
		EntityManager em = new ConnectionFactory().getConnection();
		
		List<Telefone> lista = new ArrayList<Telefone>();
		
		try {
			lista = em.createQuery("from Telefone").getResultList();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return lista;
	}
	
	public Telefone obter(Class<Telefone> telefone, Long id) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		Telefone t = new Telefone();
		
		try {
			t = em.find(telefone, id);
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		
		return t;
	}
	
	public List<Telefone> obter(String cpf) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		List<Telefone> lista = new ArrayList<Telefone>();
		
		try {
			lista = em.createQuery("from Telefone WHERE cpf = " + cpf + ";").getResultList();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		
		return lista;
	}
	
	public void excluir(Telefone t) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			
			em.createQuery("delete from Telefone WHERE id = " + t.getId() + ";");
			
			em.getTransaction().commit();
		} catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
	}
}
