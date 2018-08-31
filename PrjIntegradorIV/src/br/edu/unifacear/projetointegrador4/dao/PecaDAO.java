package br.edu.unifacear.projetointegrador4.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.entity.Aplicacao;
import br.edu.unifacear.projetointegrador4.entity.Modelo;
import br.edu.unifacear.projetointegrador4.entity.Peca;

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
			lista = em.createQuery("from peca_modelo WHERE modelo_id =" + modelo.getId()).getResultList();
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
