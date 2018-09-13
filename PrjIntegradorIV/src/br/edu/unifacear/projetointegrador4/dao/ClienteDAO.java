package br.edu.unifacear.projetointegrador4.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.entity.Cliente;
import br.edu.unifacear.projetointegrador4.entity.Funcionario;

public class ClienteDAO extends DAOGenerico<Cliente>{
	
	public List<Cliente> obter(String nome) {
		EntityManager em = new ConnectionFactory().getConnection();
		Cliente cliente = null;
		List<Cliente> lista = null;
		try {
			lista = em.createQuery("from Cliente WHERE nome like '%"+nome+"%'").getResultList();			
		}catch (Exception e) {
			System.err.println(e);//imprimindo o erro no console
		}finally{
			em.close();//fechando a conexão
		}
		return lista;//= (Montadora) query.getSingleResult();	
	}
	
	
	public List<Cliente> listar(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Cliente> lista = new ArrayList<Cliente>();
		Cliente cliente = null;
		
		try {
			lista = em.createQuery("from Cliente").getResultList();// busca uma lista
			
		}catch (Exception e) {
			System.err.println(e);//imprimindo o erro no console
		}finally{
			em.close();//fechando a conexão
		}
		return lista;	
	}
	

}
