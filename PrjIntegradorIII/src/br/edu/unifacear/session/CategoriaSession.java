package br.edu.unifacear.session;

import java.util.List;

import br.edu.unifacear.dao.CategoriaDAO;
import br.edu.unifacear.model.Categoria;

public class CategoriaSession {
	private CategoriaDAO dao;
	
	public CategoriaSession() {
		dao = new CategoriaDAO();
	}
	
	public void inserirCategoria(Categoria c) {
		dao.inserir(c);
	}
	
	public void atualizarCategoria(Categoria c) {
		dao.atualizar(c);
	}
	
	public List<Categoria> obter() {
		return dao.listarTodos();
	}
	
	public Categoria obter(Long id) {
		return dao.obterPorId(id);
	}
	
	public List<Categoria> obter(String nome) {
		return dao.obterPorNome(nome);
	}
	
	public Categoria obterNome(String nome) {
		Categoria c = new Categoria();
		
		c = dao.obterPorNome(nome).get(0);
		
		return c;
	}
	
	public void excluirCategoria(Categoria c) {
		dao.excluir(c);
	}
	
	public long proximoId() {
		return dao.gerarId();
	}

}
