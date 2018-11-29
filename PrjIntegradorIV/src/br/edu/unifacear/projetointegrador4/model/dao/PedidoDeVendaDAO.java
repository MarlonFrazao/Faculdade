package br.edu.unifacear.projetointegrador4.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.model.entity.Cliente;
import br.edu.unifacear.projetointegrador4.model.entity.Peca;
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
			lista = em.createQuery("from PedidoDeVenda Where cliente_id ="+id_cliente).getResultList();
		}catch(Exception e) {
			System.err.println(e);
		}finally {
			em.close();
		}
		return lista;
	}
	
	public List<Peca> obterPecas(PedidoDeVenda pdv){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Peca> lista = null;
		System.out.println("Id do PDVVVVV em PecaDAO:"+pdv.getId());
		try {
			lista = em.createQuery("from PedidoDeVenda p join fetch p.pecasdopedido m WHERE pdv_id = " + pdv.getId()).getResultList();
			for(int i = 0; i<lista.size();i++) {
				System.out.println("Lista das pecinhas no DAO: "+lista.get(i).getDescricao());
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return lista;
	}

}
