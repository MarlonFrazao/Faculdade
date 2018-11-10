package br.edu.unifacear.projetointegrador4.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.model.entity.Peca_Modelo;

public class Peca_ModeloDAO extends DAOGenerico <Peca_Modelo>{
	
	public List<Peca_Modelo> listar(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Peca_Modelo> lista = new ArrayList<Peca_Modelo>();
		
		
		try {
			lista = em.createQuery("from Peca_Modelo").getResultList();// busca uma lista
			
		}catch (Exception e) {
			System.err.println(e);//imprimindo o erro no console
		}finally{
			em.close();//fechando a conexão
		}
		return lista;	
	}
}
