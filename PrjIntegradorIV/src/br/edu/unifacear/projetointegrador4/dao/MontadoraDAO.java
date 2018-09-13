package br.edu.unifacear.projetointegrador4.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.entity.Montadora;

public class MontadoraDAO extends DAOGenerico<Montadora> {
		
	public List<Montadora> obter(String descricao) {
		EntityManager em = new ConnectionFactory().getConnection();
		Montadora montadora = null;
		List<Montadora> lista = null;
		try {
			lista = em.createQuery("from Montadora WHERE descricao like '%"+descricao+"%'").getResultList();			
		}catch (Exception e) {
			System.err.println(e);//imprimindo o erro no console
		}finally{
			em.close();//fechando a conexão
		}
		return lista;//= (Montadora) query.getSingleResult();	
	}
	
	
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

}
