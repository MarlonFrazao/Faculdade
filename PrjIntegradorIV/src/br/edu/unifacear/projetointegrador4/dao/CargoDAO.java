package br.edu.unifacear.projetointegrador4.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.entity.Cargo;
import br.edu.unifacear.projetointegrador4.entity.Cliente;

public class CargoDAO extends DAOGenerico<Cargo>{
	
	public List<Cargo> obter(String descricao) {
		EntityManager em = new ConnectionFactory().getConnection();
		Cargo cargo = null;
		List<Cargo> lista = null;
		try {
			lista = em.createQuery("from Cargo WHERE descricao like '%"+descricao+"%'").getResultList();			
		}catch (Exception e) {
			System.err.println(e);//imprimindo o erro no console
		}finally{
			em.close();//fechando a conexão
		}
		return lista;//= (Montadora) query.getSingleResult();	
	}
	
	
	public List<Cargo> listar(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Cargo> lista = new ArrayList<Cargo>();
		Cargo cargo = null;
		
		try {
			lista = em.createQuery("from Cargo").getResultList();// busca uma lista
			
		}catch (Exception e) {
			System.err.println(e);//imprimindo o erro no console
		}finally{
			em.close();//fechando a conexão
		}
		return lista;	
	}
}
