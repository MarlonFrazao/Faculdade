package br.edu.unifacear.projetointegrador4.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.entity.Cliente;
import br.edu.unifacear.projetointegrador4.entity.StatusPV;

public class StatusPVDAO extends DAOGenerico<StatusPV>{
	
	public List<StatusPV> obter(String descricao) {
		EntityManager em = new ConnectionFactory().getConnection();
		StatusPV statusPV = null;
		List<StatusPV> lista = null;
		try {
			lista = em.createQuery("from StatusPV WHERE descricao like '%"+descricao+"%'").getResultList();			
		}catch (Exception e) {
			System.err.println(e);//imprimindo o erro no console
		}finally{
			em.close();//fechando a conexão
		}
		return lista;//= (Montadora) query.getSingleResult();	
	}
	
	
	public List<StatusPV> listar(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<StatusPV> lista = new ArrayList<StatusPV>();
		StatusPV statusPV = null;
		
		try {
			lista = em.createQuery("from StatusPV").getResultList();// busca uma lista
			
		}catch (Exception e) {
			System.err.println(e);//imprimindo o erro no console
		}finally{
			em.close();//fechando a conexão
		}
		return lista;	
	}
	

}
