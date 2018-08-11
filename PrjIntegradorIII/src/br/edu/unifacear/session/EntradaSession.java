package br.edu.unifacear.session;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.dao.EntradaDAO;
import br.edu.unifacear.model.Entrada;
import br.edu.unifacear.model.Produto;

public class EntradaSession {
	private EntradaDAO dao;
	
	public EntradaSession() {
		dao = new EntradaDAO();
	}
	
	public void inserirEntrada(Entrada e) {
		dao.inserir(e);
	}
	
	public void inserirEntrada(Entrada e, List<Produto> lp) {
		dao.inserir(e, lp);
	}
	
	public void atualizarEntrada(Entrada e) {
		dao.atualizar(e);
	}
	
	public void atualizarEntrada(Entrada e, List<Produto> lp) {
		dao.atualizar(e, lp);
	}
	
	public List<Entrada> listarTodos() {
		
		return dao.listarTodos();
		
	}
	
	public Entrada obterPorId(Long idEntrada) {
		return dao.obterPorId(idEntrada);
	}
	public Entrada obterNumPed(Long numPed) {
		return dao.obterNumPed(numPed);
	}
	
	public List<Entrada> obterPorData(String data) throws ParseException {
		
		
		DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date d = new Date(f.parse(data).getTime());
		
		return dao.obterPorData(d);
	}
	
	public List<Entrada> obterPorFun(Long matFun) {
		return dao.obterPorFun(matFun);
	}
	
	public List<Entrada> obterPorPedido(long pedido) {
		return dao.obterPorPedido(pedido);
	}
	
	public List<Entrada> obterPorPeriodo(String inicio, String fim) throws ParseException {
		
		DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date d1 = new Date(f.parse(inicio).getTime());
		Date d2 = new Date(f.parse(fim).getTime());
		
		return dao.obterPorPeriodo(d1, d2);
	}
	
	public long proximoId() {
		return dao.gerarId();
	}
}
