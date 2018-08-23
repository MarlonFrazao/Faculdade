package br.edu.unifacear.projetointegrador4.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.entity.Fabricante;

public class FabricanteDAO implements DAO<Fabricante> {
	
	@Override
	public void inserir(Fabricante fabricante) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			
			if(fabricante.getId()==null) {
				em.persist(fabricante);
			}else {
				em.merge(fabricante);
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
	public Fabricante obter(Long id) {
		EntityManager em = new ConnectionFactory().getConnection();
		Fabricante fabricante = null;
		
		try {
			fabricante = em.find(Fabricante.class, id);
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return fabricante;
		
	}
	
	@Override
	public List<Fabricante> listar(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Fabricante> lista = null;
		
		try {
			lista = em.createQuery("from Fabricante").getResultList();
			
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return lista;
	}
	
	public List<Fabricante> obter(String descricao){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Fabricante> lista = null;
		
		try {
			
			lista = em.createQuery("from Fabricante WHERE descricao like '%"+descricao+"%'").getResultList();
			
		}catch(Exception e) {
			System.err.println(e);
			
		}finally {
			em.close();
		}
		return lista;
	}

	@Override
	public void atualizar(Fabricante f) {
		EntityManager em = new ConnectionFactory().getConnection();

		try {
			em.getTransaction().begin();

			em.merge(f);

			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);

			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public void excluir(Fabricante f) {
		EntityManager em = new ConnectionFactory().getConnection();

		f.setStatus(false);
		try {
			em.getTransaction().begin();

			em.merge(f);

			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);

			em.getTransaction().rollback();
		} finally {

			em.close();
		}
		
	}

}
