package br.edu.unifacear.projetointegrador4.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.edu.unifacear.projetointegrador4.connection.ConnectionFactory;
import br.edu.unifacear.projetointegrador4.model.entity.Funcionario;
import br.edu.unifacear.projetointegrador4.model.entity.Montadora;

public class FuncionarioDAO extends DAOGenerico<Funcionario> {


	public List<Funcionario> obter(String cargo) {
		EntityManager em = new ConnectionFactory().getConnection();
		Funcionario funcionario = null;
		List<Funcionario> lista = null;
		try {
			lista = em.createQuery("from Funcionario WHERE descricao like '%"+cargo+"%'").getResultList();			
		}catch (Exception e) {
			System.err.println(e);//imprimindo o erro no console
		}finally{
			em.close();//fechando a conexão
		}
		return lista;//= (Montadora) query.getSingleResult();	
	}
	
	
	public List<Funcionario> listar(){
		EntityManager em = new ConnectionFactory().getConnection();
		List<Funcionario> lista = new ArrayList<Funcionario>();
		Funcionario funcionario = null;
		
		try {
			lista = em.createQuery("from Funcionario").getResultList();// busca uma lista
			
		}catch (Exception e) {
			System.err.println(e);//imprimindo o erro no console
		}finally{
			em.close();//fechando a conexão
		}
		return lista;	
	}

}
