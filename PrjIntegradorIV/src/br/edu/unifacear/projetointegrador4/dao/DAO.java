package br.edu.unifacear.projetointegrador4.dao;

import java.util.List;

public interface DAO<T> {
	
	public void inserir(T t);
	
	public void atualizar(T t);
	
	public List<T> listar();
	
	public T obter(Long id);
	
	public void excluir(T t);
}
