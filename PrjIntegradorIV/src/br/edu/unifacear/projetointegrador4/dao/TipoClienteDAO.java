package br.edu.unifacear.projetointegrador4.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.entity.StatusPV;
import br.edu.unifacear.projetointegrador4.entity.TipoCliente;

public class TipoClienteDAO extends DAOGenerico<TipoCliente>{
	
	public List<TipoCliente> obter(String descricao) {
		EntityManager em = new ConnectionFactory().getConnection();
		TipoCliente tipoCliente = null;
		List<TipoCliente> lista = null;
		try {
			lista = em.createQuery("from TipoCliente WHERE nome like '%"+descricao+"%'").getResultList();			
		}catch (Exception e) {
			System.err.println(e);//imprimindo o erro no console
		}finally{
			em.close();//fechando a conexão
		}
		return lista;//= (Montadora) query.getSingleResult();	
	}
	
	
	public List<TipoCliente> listar(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<TipoCliente> lista = new ArrayList<TipoCliente>();
		TipoCliente tipoCliente = null;
		
		try {
			lista = em.createQuery("from TipoCliente").getResultList();// busca uma lista
			
		}catch (Exception e) {
			System.err.println(e);//imprimindo o erro no console
		}finally{
			em.close();//fechando a conexão
		}
		return lista;	
	}

}
