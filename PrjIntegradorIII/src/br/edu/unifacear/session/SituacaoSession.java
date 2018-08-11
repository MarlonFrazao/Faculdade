package br.edu.unifacear.session;

import java.util.List;

import br.edu.unifacear.dao.SituacaoDAO;
import br.edu.unifacear.model.Situacao;
public class SituacaoSession {
	private SituacaoDAO dao;
	
	public SituacaoSession() {
		dao = new SituacaoDAO();
	}
	
	public void inserirSituacao(Situacao s) {
		dao.inserir(s);
	}
	
	public void atualizarSituacao(Situacao s) {
		dao.atualizar(s);
	}
	
	public List<Situacao> obter() {
		return dao.listarTodos();
	}
	
	public Situacao obter(long id) {
		return dao.obterPorId(id);
	}
	
	public List<Situacao> obter(String desc) {
		return dao.obterPorDesc(desc);
	}
	
	public Situacao obterDesc(String desc) {
		Situacao s = new Situacao();
		
		s = dao.obterPorDesc(desc).get(0);
		
		return s;
	}
	
	public void excluirSituacao(Situacao s) {
		dao.excluir(s);
	}
	
	public long proximoId() {
		return dao.gerarId();
	}
}
