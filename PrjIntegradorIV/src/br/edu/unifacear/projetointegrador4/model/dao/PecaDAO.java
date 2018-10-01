package br.edu.unifacear.projetointegrador4.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.model.entity.Aplicacao;
import br.edu.unifacear.projetointegrador4.model.entity.Modelo;
import br.edu.unifacear.projetointegrador4.model.entity.Peca;

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
