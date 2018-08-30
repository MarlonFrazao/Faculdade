package br.edu.unifacear.projetointegrador4.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.entity.LinhaDeVeiculo;
import br.edu.unifacear.projetointegrador4.entity.PedidoDeVenda;

public class PedidoDeVendaDAO extends DAOGenerico<PedidoDeVenda>{
		
	public List<LinhaDeVeiculo> listar(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<LinhaDeVeiculo> lista = null;
		try {
			lista = em.createQuery("from LinhaDeVeiculo").getResultList();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return lista;
	}

}
