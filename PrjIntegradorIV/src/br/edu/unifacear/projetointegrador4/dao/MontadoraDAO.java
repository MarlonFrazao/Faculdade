package br.edu.unifacear.projetointegrador4.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.entity.Montadora;

public class MontadoraDAO implements DAO<Montadora>{

	@Override
	public void inserir(Montadora m) {
		EntityManager em = Conexao.creatEntityManager();
		
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		
	}

	@Override
	public void alterar(Montadora m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Montadora m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Montadora> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Montadora buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
