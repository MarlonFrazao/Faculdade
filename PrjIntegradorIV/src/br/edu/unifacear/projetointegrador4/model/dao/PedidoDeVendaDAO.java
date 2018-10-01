package br.edu.unifacear.projetointegrador4.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.model.entity.Cliente;
import br.edu.unifacear.projetointegrador4.model.entity.PedidoDeVenda;

public class PedidoDeVendaDAO extends DAOGenerico<PedidoDeVenda>{
		
	public List<PedidoDeVenda> listar(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<PedidoDeVenda> lista = null;
		try {
			lista = em.createQuery("from PedidoDeVenda").getResultList();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return lista;
	}
	
	public List<PedidoDeVenda> obter(Long id_cliente){
		EntityManager em = new ConnectionFactory().getConnection();
		List<PedidoDeVenda> lista = null;
		//ClienteDAO daoc = new ClienteDAO();
		//Cliente c = new Cliente();
		//c = daoc.obter(Cliente.class, id_cliente);
		try {
			lista = em.createQuery("from PedidoDeVenda Where id_cliente ="+id_cliente).getResultList();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return lista;
	}

}
