package br.edu.unifacear.session;

import java.util.List;

import br.edu.unifacear.dao.CorDAO;
import br.edu.unifacear.model.Cor;

public class CorSession {
	private CorDAO dao;
	
	public CorSession() {
		dao = new CorDAO();
	}
	
	public void inserirCor(Cor c) {
		dao.inserir(c);
	}
	
	public void atualizarCor(Cor c) {
		dao.atualizar(c);
	}
	
	public List<Cor> obter() {
		return dao.listarTodos();
	}
	
	public Cor obter(long id) {
		return dao.obterPorId(id);
	}
	
	public List<Cor> obter(String nome) {
		return dao.obterPorNome(nome);
	}
	
	public Cor obterPorNome(String nome) {
		Cor c = new Cor();
		
		List<Cor> lista = dao.obterPorNome(nome);
		
		c = lista.get(0);
		
		return c;
	}
	
	public void excluirCor(Cor c) {
		dao.excluir(c);
	}
	
	public long proximoId() {
		return dao.gerarId();
	}
}
