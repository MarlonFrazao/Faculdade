package br.edu.unifacear.session;

import java.util.List;

import br.edu.unifacear.dao.GeneroDAO;
import br.edu.unifacear.dao.TamanhoDAO;
import br.edu.unifacear.model.Genero;
import br.edu.unifacear.model.Tamanho;

public class GeneroSession {
	
private GeneroDAO dao;
	
	public GeneroSession() {
		dao = new GeneroDAO();
	}
	
	public void inserirGenero(Genero Gen) {
		dao.inserir(Gen);
	}
	
	public void atualizarGenero(Genero Gen) {
		dao.atualizar(Gen);
	}
	
	public List<Genero> obter() {
		return dao.listarTodos();
	}
	
	public Genero obter(long id) {
		return dao.obterPorId(id);
	}
	
	public List<Genero> obter(String nome) {
		return dao.obterPorNome(nome);
	}
	
	public Genero obterPorNome(String nome) {
		Genero Gen = new Genero();
		
		List<Genero> lista = dao.obterPorNome(nome);
		
		Gen = lista.get(0);
		
		return Gen;
	}
	
	public void excluirGenero(Genero Gen) {
		dao.excluir(Gen);
	}
	
	public long proximoId() {
		return dao.gerarId();
	}
	

}
