package br.edu.unifacear.projetointegrador4.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.entity.Montadora;

public class MontadoraDAO implements DAO<Montadora> {
	
	@Override
	public void inserir (Montadora montadora) {
		//criando de fado o entityManager
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();// iniciando a tranzação com o banco
			
			//essa verificação é para fazer o Update e excluir
			if(montadora.getId()==null) {
				em.persist(montadora);// persistindo os dados passando a montadora por parametro
			}else {
				em.merge(montadora);// se o ID for existente ele dará um UPDATE
			}
			em.getTransaction().commit();// salvando os dados
		}catch (Exception e) {
			System.err.println(e);//imprimindo o erro no console
			em.getTransaction().rollback();//caso der errado a tranzação ele desfaz a operação
		}finally{
			em.close();//fechando a conexão
		}
		
	}
	
	@Override
	public Montadora obter(Long id) {
		
		//criando de fado o entityManager
		EntityManager em = new ConnectionFactory().getConnection();
		Montadora montadora = null;
		
		try {
			montadora = em.find(Montadora.class, id);// busca o id com a referência da classe
			
		}catch (Exception e) {
			System.err.println(e);//imprimindo o erro no console
		}finally{
			em.close();//fechando a conexão
		}
		return montadora;	
		
	}
	
	public List<Montadora> obter(String descricao) {
		EntityManager em = new ConnectionFactory().getConnection();
		Montadora montadora = null;
		List<Montadora> lista = null;
		try {
			//montadora = em.find(Montadora.class, descricao);// busca o id com a referência da classe
			//query = em.createQuery("from Montadora WHERE descricao like '%"+descricao+"%'");
			//query.getSingleResult();
			lista = em.createQuery("from Montadora WHERE descricao like '%"+descricao+"%'").getResultList();
			//System.out.println("Desc: "+montadora.getDescricao());
			//montadora = query;
			//System.out.println("Query: "+query.getSingleResult().toString());
					//em.createNativeQuery("from Montadora WHERE descricao like %"+descricao+"%").getSingleResult();
			
		}catch (Exception e) {
			System.err.println(e);//imprimindo o erro no console
		}finally{
			em.close();//fechando a conexão
		}
		return lista;//= (Montadora) query.getSingleResult();	
	}
	
	@Override
	public List<Montadora> listar(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Montadora> lista = new ArrayList<Montadora>();
		Montadora montadora = null;
		
		try {
			lista = em.createQuery("from Montadora").getResultList();// busca uma lista
			
		}catch (Exception e) {
			System.err.println(e);//imprimindo o erro no console
		}finally{
			em.close();//fechando a conexão
		}
		return lista;	
	}

	@Override
	public void atualizar(Montadora m) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		try {
			em.getTransaction().begin();
			
			em.merge(m);
			
			em.getTransaction().commit();
		} catch(Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}

	@Override
	public void excluir(Montadora m) {
		EntityManager em = new ConnectionFactory().getConnection();
		
		m.setStatus(false);
		
		try {
			em.getTransaction().begin();
			
			em.merge(m);
			
			em.getTransaction().commit();
		} catch(Exception e) {
			System.err.println(e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}
	
	

}
