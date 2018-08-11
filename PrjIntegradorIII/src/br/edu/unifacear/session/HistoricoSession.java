package br.edu.unifacear.session;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import br.edu.unifacear.dao.HistoricoDAO;
import br.edu.unifacear.model.Historico;
public class HistoricoSession {
	private HistoricoDAO dao;
	
	public HistoricoSession() {
		dao = new HistoricoDAO();
	}
	
	public void inserirHistorico(Historico h) {
		if (h != null) {
			dao.inserir(h);
		}
	}
	
	public void atualizarHistorico(Historico h) {
		if(h != null) {
			dao.atualizar(h);
		}
	}
	
	public List<Historico> listarTodos() {
		return dao.listarTodos();
	}
	
	public List<Historico> obterPorId(Long id) {
		return dao.obterPorId(id);
	}
	
	public List<Historico> obterPorData(String data) throws ParseException {
		
		DateFormat f = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Date d = new Date(f.parse(data).getTime());
		
		return dao.obterPorData(d);
	}
	
	public List<Historico> obterPorDesc(String desc) {
		return dao.obterPorDesc(desc);
	}
	
	public Historico obterPorIdEData(Long id, String data) throws ParseException {
		
		DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date d = new Date(f.parse(data).getTime());
		
		return dao.obterPorIdEData(id, d);
	}
	
	public void excluirHistorico(Historico h) {
		dao.excluir(h);
	}
}
