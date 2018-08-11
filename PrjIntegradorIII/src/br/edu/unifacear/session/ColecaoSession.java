package br.edu.unifacear.session;

import java.util.List;

import br.edu.unifacear.dao.ColecaoDAO;
import br.edu.unifacear.model.Colecao;
public class ColecaoSession {
	private ColecaoDAO dao;
	
	public ColecaoSession () {
		dao = new ColecaoDAO();
	}
	
	public void inserirColecao(Colecao c) {
		dao.inserir(c);
	}
	
	public void atualizarColecao(Colecao c) {
		dao.atualizar(c);
	}
	
	public List<Colecao> obter() {
		return dao.listarTodos();
	}
	
	public Colecao obter(Long id) {
		return dao.obterPorId(id);
	}
	
	public List<Colecao> obter(String nome) {
		return dao.obterPorNome(nome);
	}
	
	public Colecao obterPorNome(String nome) {
		Colecao c = dao.obterPorNome(nome).get(0);
		
		return c;
	}
	
	public void excluirColecao(Colecao c) {
		dao.excluir(c);
	}
	
	public long proximoId() {
		return dao.gerarId();
	}
}
