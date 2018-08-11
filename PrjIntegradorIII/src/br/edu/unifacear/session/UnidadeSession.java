package br.edu.unifacear.session;

import java.util.List;

import br.edu.unifacear.dao.UnidadeDAO;
import br.edu.unifacear.model.Unidade;

public class UnidadeSession {
	
private UnidadeDAO dao;
	
	public UnidadeSession() {
		dao = new UnidadeDAO();
	}
	
	public void inserirUnidade(Unidade Un) {
		dao.inserir(Un);
	}
	
	public void atualizarUnidade(Unidade Un) {
		dao.atualizar(Un);
	}
	
	public List<Unidade> obter() {
		return dao.listarTodos();
	}
	
	public Unidade obter(long id) {
		return dao.obterPorId(id);
	}
	
	public List<Unidade> obter(String nome) {
		return dao.obterPorNome(nome);
	}
	
	public Unidade obterPorNome(String nome) {
		Unidade Un = new Unidade();
		
		List<Unidade> lista = dao.obterPorNome(nome);
		
		Un = lista.get(0);
		
		return Un;
	}
	
	public void excluirUnidade(Unidade Un) {
		dao.excluir(Un);
	}
	
	public long proximoId() {
		return dao.gerarId();
	}

}
