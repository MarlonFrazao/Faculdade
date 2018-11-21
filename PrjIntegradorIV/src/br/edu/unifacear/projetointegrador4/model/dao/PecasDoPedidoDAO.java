package br.edu.unifacear.projetointegrador4.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.model.entity.Peca_Modelo;
import br.edu.unifacear.projetointegrador4.model.entity.PecasDoPedido;
import br.edu.unifacear.projetointegrador4.model.entity.PedidoDeVenda;

public class PecasDoPedidoDAO extends DAOGenerico<PecasDoPedido>{
	
		public List<PecasDoPedido> listar(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<PecasDoPedido> lista = new ArrayList<PecasDoPedido>();
		
		
		try {
			lista = em.createQuery("from pecasdopedido").getResultList();// busca uma lista
			
		}catch (Exception e) {
			System.err.println(e);//imprimindo o erro no console
		}finally{
			em.close();//fechando a conexão
		}
		return lista;	
	}
}
