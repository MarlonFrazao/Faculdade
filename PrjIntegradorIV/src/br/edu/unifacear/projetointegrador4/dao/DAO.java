package br.edu.unifacear.projetointegrador4.dao;

import java.util.List;

public interface DAO<T> {
	
	public void inserir(T t);
	
	public void alterar(T t);
	
	public void excluir(T t);
	
	public List<T> listar();
	
	public T buscarPorId(Long id);
}
