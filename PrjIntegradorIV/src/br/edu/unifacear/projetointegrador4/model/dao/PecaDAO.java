package br.edu.unifacear.projetointegrador4.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.model.entity.Aplicacao;
import br.edu.unifacear.projetointegrador4.model.entity.Modelo;
import br.edu.unifacear.projetointegrador4.model.entity.Peca;
import br.edu.unifacear.projetointegrador4.model.entity.PedidoDeVenda;

public class PecaDAO extends DAOGenerico<Peca> {
	
	public List<Peca> obter(String descricao) {
		EntityManager em = new ConnectionFactory().getConnection();
		List<Peca> lista = null;
		try {
			lista = em.createQuery("from Peca WHERE descricao like '%" + descricao + "%'").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return lista;
	}
	public List<Peca> listar() {
		EntityManager em = new ConnectionFactory().getConnection();
		List<Peca> lista = null;
		try {
			lista = em.createQuery("from Peca").getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return lista;
	}	
	public List<Peca> obter(Aplicacao aplic) {
		EntityManager em = new ConnectionFactory().getConnection();
		List<Peca> lista = null;

		try {
			lista = em.createQuery("from Peca WHERE aplicacao_id =" + aplic.getId()).getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return lista;
	}	
	public List<Peca> obter(Modelo modelo) {
		EntityManager em = new ConnectionFactory().getConnection();
		List<Peca> lista = null;
		try {
			lista = em.createQuery("from Peca p join fetch p.peca_modelo m WHERE modelo_id = " +  modelo.getId()).getResultList();
			//em.setProperty("id", modelo.getId());
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return lista;
	}	
	 
	public List<Peca> obterListaPecaPedido(PedidoDeVenda pdv) {
		EntityManager em = new ConnectionFactory().getConnection();
		List<Peca> lista = null;
		System.out.println("Id do PDVVVVV em PecaDAO:"+pdv.getId());
		try {
			lista = em.createQuery("from Peca p join fetch p.pecasPdv m WHERE pdv_id = " + pdv.getId()).getResultList();
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

	public List<Modelo> obter(Peca peca) {
		EntityManager em = new ConnectionFactory().getConnection();
		List<Modelo> lista = null;

		try {
			lista = em.createQuery("from Peca_modelo WHERE peca_id =" + peca.getId()).getResultList();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			em.close();
		}
		return lista;
	}
	
	
	
	

}
