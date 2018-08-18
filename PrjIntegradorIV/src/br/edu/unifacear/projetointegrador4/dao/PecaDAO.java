package br.edu.unifacear.projetointegrador4.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.entity.Peca;

public class PecaDAO implements DAO<Peca>{

	@Override
	public void inserir(Peca p) {

		EntityManager em = Conexao.creatEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
	}

	@Override
	public void alterar(Peca p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Peca p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Peca> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Peca buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
