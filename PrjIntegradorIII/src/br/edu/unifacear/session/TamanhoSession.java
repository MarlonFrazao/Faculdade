package br.edu.unifacear.session;

import java.util.List;

import br.edu.unifacear.dao.TamanhoDAO;
import br.edu.unifacear.dao.TamanhoDAO;
import br.edu.unifacear.model.Tamanho;

public class TamanhoSession {
	
	private TamanhoDAO dao;
	
	public TamanhoSession() {
		dao = new TamanhoDAO();
	}
	
	public void inserirTamanho(Tamanho tam) {
		dao.inserir(tam);
	}
	
	public void atualizarTamanho(Tamanho tam) {
		dao.atualizar(tam);
	}
	
	public List<Tamanho> obter() {
		return dao.listarTodos();
	}
	
	public Tamanho obter(long id) {
		return dao.obterPorId(id);
	}
	
	public List<Tamanho> obter(String nome) {
		return dao.obterPorNome(nome);
	}
	
	public Tamanho obterPorNome(String nome) {
		Tamanho tam = new Tamanho();
		
		List<Tamanho> lista = dao.obterPorNome(nome);
		
		tam = lista.get(0);
		
		return tam;
	}
	
	public void excluirTamanho(Tamanho tam) {
		dao.excluir(tam);
	}
	
	public long proximoId() {
		return dao.gerarId();
	}
}
