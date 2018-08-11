package br.edu.unifacear.session;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.dao.SaidaDAO;
import br.edu.unifacear.model.Produto;
import br.edu.unifacear.model.Saida;
public class SaidaSession {
	private SaidaDAO dao;
	
	public SaidaSession() {
		dao = new SaidaDAO();
	}
	
	public void inserirSaida(Saida s) {
		if(s != null) {
			dao.inserir(s);
		} 
	}
	
	public void inserirSaida(Saida s, List<Produto> lp) {
		if(s != null && lp != null && lp.size() > 0) {
			dao.inserir(s, lp);
		}
	}
	
	public void atualizarSaida(Saida s) {
		if(s != null) {
			dao.atualizar(s);
		}
	}
	
	public void atualizarSaida(Saida s, List<Produto> lp) {
		if(s != null && lp != null && lp.size() > 0) {
			dao.atualizar(s, lp);
		}
	}
	
	public List<Saida> listarTodos() {
		List<Saida> retorno = new ArrayList<Saida>();
		List<Saida> lista = dao.listarTodos();
		
		for(int i = 0; i < lista.size(); i++) {
			if(i == lista.size() - 1) {
				
			} else if(lista.get(i).getId() == lista.get(i + 1).getId()) {
				
				for(int j = 0; j < lista.get(i).getListaProdutos().size(); j ++) {
					if(lista.get(i).getListaProdutos().get(j).getId() != lista.get(i + 1).getListaProdutos().get(j).getId()) {
						lista.get(i + 1).getListaProdutos().add(lista.get(i).getListaProdutos().get(j));
					}
				}
				
				retorno.add(lista.get(i));
			} else if(i !=0 && lista.get(i).getId() != lista.get(i-1).getId()) {
				retorno.add(lista.get(i));
			}
		}
		return retorno;
	}
	
	public Saida obterPorId(Long idSaida) {
		return dao.obterPorId(idSaida);
	}
	public Saida obterPedVenda(Long pedVenda) {
		return dao.obterPedVenda(pedVenda);
	}
	
	public List<Saida> obterPorData(String data) throws ParseException {
		List<Saida> retorno = new ArrayList<Saida>();
		
		DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date d = new Date(f.parse(data).getTime());
		
		List<Saida> lista = dao.obterPorData(d);
		
		for(int i = 0; i < lista.size(); i++) {
			if(i == lista.size() - 1) {
				
			} else if(lista.get(i).getId() == lista.get(i + 1).getId()) {
				
				for(int j = 0; j < lista.get(i).getListaProdutos().size(); j ++) {
					if(lista.get(i).getListaProdutos().get(j).getId() != lista.get(i + 1).getListaProdutos().get(j).getId()) {
						lista.get(i + 1).getListaProdutos().add(lista.get(i).getListaProdutos().get(j));
					}
				}
				retorno.add(lista.get(i + 1));
			} else if(i != 0 && lista.get(i).getId() != lista.get(i - 1).getId()) {
				retorno.add(lista.get(i));
			}
		}
		return retorno;
	}
	
	public List<Saida> obterPorFun(Long matFun) {
		List<Saida> retorno = new ArrayList<Saida>();
		List<Saida> lista = dao.obterPorFun(matFun);
		
		for(int i = 0; i < lista.size(); i++) {
			if(i == lista.size() - 1) {
				
			} else if(lista.get(i).getId() == lista.get(i + 1).getId()) {
				
					for (int j = 0; j < lista.get(i).getListaProdutos().size(); j++) {
						if(lista.get(i).getListaProdutos().get(j).getId() != lista.get(i + 1).getListaProdutos().get(j).getId()) {
							lista.get(i + 1).getListaProdutos().add(lista.get(i).getListaProdutos().get(j));
						}
					}
				
					retorno.add(lista.get(i + 1));
				} else if(i != 0 && lista.get(i).getId() != lista.get(i-1).getId()){
					retorno.add(lista.get(i));
			}
		}
		return retorno;
	}
	
	public List<Saida> obterPorPedido(long pedido) {
		List<Saida> retorno = new ArrayList<Saida>();
		List<Saida> lista = dao.obterPorPedido(pedido);
		
		for(int i = 0; i < lista.size(); i++) {
			if(i == lista.size() - 1) {
				
			} else if(lista.get(i).getId() == lista.get(i + 1).getId()) {
				
					for (int j = 0; j < lista.get(i).getListaProdutos().size(); j++) {
						if(lista.get(i).getListaProdutos().get(j).getId() != lista.get(i + 1).getListaProdutos().get(j).getId()) {
							lista.get(i + 1).getListaProdutos().add(lista.get(i).getListaProdutos().get(j));
						}
					}
				
					retorno.add(lista.get(i + 1));
				} else if(i != 0 && lista.get(i).getId() != lista.get(i-1).getId()){
					retorno.add(lista.get(i));
			}
		}
		return retorno;
	}
	
	public List<Saida> obterPorPeriodo(String inicio, String fim) throws ParseException {
		List<Saida> retorno = new ArrayList<Saida>();
		
		DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		Date d1 = new Date(f.parse(inicio).getTime());
		Date d2 = new Date(f.parse(fim).getTime());
		
		List<Saida> lista = dao.obterPorPeriodo(d1, d2);
		
		for(int i = 0; i < lista.size(); i++) {
			if(i == lista.size() - 1) {
				
			} else if(lista.get(i).getId() == lista.get(i + 1).getId()) {
				
				for(int j = 0; j < lista.get(i).getListaProdutos().size(); j ++) {
					if(lista.get(i).getListaProdutos().get(j).getId() != lista.get(i + 1).getListaProdutos().get(j).getId()) {
						lista.get(i + 1).getListaProdutos().add(lista.get(i).getListaProdutos().get(j));
					}
				}
				retorno.add(lista.get(i + 1));
			} else if(i != 0 && lista.get(i).getId() != lista.get(i - 1).getId()) {
				retorno.add(lista.get(i));
			}
		}
		return retorno;
	}
	public long proximoId() {
		return dao.gerarId();
	}
}
