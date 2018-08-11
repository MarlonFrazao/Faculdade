package br.edu.unifacear.session;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.dao.ProdutoDAO;
import br.edu.unifacear.model.Categoria;
import br.edu.unifacear.model.Colecao;
import br.edu.unifacear.model.Cor;
import br.edu.unifacear.model.Genero;
import br.edu.unifacear.model.Produto;
import br.edu.unifacear.model.Situacao;
import br.edu.unifacear.model.Tamanho;

public class ProdutoSession {
	private ProdutoDAO dao;
	
	public ProdutoSession() {
		dao = new ProdutoDAO();
	}
	
	public void inserirProduto(Produto p) {
		dao.inserir(p);
	}
	
	public void atualizarProduto(Produto p) {
		dao.atualizar(p);
	}
	
	public List<Produto> obter() {
		return dao.listarTodos();
	}
	
	public List<Produto> obter(boolean ativo) {
		List<Produto> lista = new ArrayList<Produto>();

		for (int i = 0; i < dao.listarTodos().size(); i++) {

			if (dao.listarTodos().get(i).isStatus() == ativo) {
				Produto p = new Produto();

				p = dao.listarTodos().get(i);

				lista.add(p);
			}
		}	
		return lista;
	}
	
	public Produto obter(long id) {
		return dao.obterPorId(id);
	}
	
	public List<Produto> obter(String nome) {
		return dao.obterPorNome(nome);
	}
	
	public List<Produto> obter(String nome, boolean ativo) {
		List<Produto> lista = new ArrayList<Produto>();
		
		for (int i = 0; i < dao.obterPorNome(nome).size(); i++) {
			
			if (dao.obterPorNome(nome).get(i).isStatus() == ativo) {
				Produto p = new Produto();
				
				p = dao.obterPorNome(nome).get(i);
				
				lista.add(p);
			}
		}
		return lista;
	}
	
	public List<Produto> obterPorCat(Categoria c) {
		return dao.obterPorCat(c);
	}
	
	public List<Produto> obterPorCat(Categoria c, boolean ativo) {
		List<Produto> lista = new ArrayList<Produto>();
		
		for(int i = 0; i < dao.obterPorCat(c).size(); i++) {
			if(dao.obterPorCat(c).get(i).isStatus() == ativo) {
				Produto p = new Produto();
				
				p = dao.obterPorCat(c).get(i);
				
				lista.add(p);
			}
		}
		
		return lista;
	}
	
	public List<Produto> obterPorCor(Cor c) {
		return dao.obterPorCor(c);
	}
	
	public List<Produto> obterPorCor(Cor c, boolean ativo) {
		List<Produto> lista = new ArrayList<Produto>();
		for(int i = 0; i < dao.obterPorCor(c).size(); i++) {
			if(dao.obterPorCor(c).get(i).isStatus() == ativo) {
				Produto p = new Produto();
				
				p = dao.obterPorCor(c).get(i);
				
				lista.add(p);
			}
		}
		return lista;
	}
	
	public List<Produto> obterPorGen(Genero g) {
		return dao.obterPorGen(g);
	}
	
	public List<Produto> obterPorGen(Genero g, boolean ativo) {
		List<Produto> lista = new ArrayList<Produto>();
		for(int i = 0; i < dao.obterPorGen(g).size(); i++) {
			if(dao.obterPorGen(g).get(i).isStatus() == ativo) {
				Produto p = new Produto();
				
				p = dao.obterPorGen(g).get(i);
				
				lista.add(p);
			}
		}
		return lista;
	}
	
	public List<Produto> buscaCruzada(Object...obj) {
		List<Produto> retorno = new ArrayList<Produto>();
		String nome = "";
		Categoria cat = new Categoria();
		Cor cor = new Cor();
		Genero gen = new Genero();
		Tamanho tam = new Tamanho();
		Colecao col = new Colecao();
		Situacao sit = new Situacao();
		Boolean ativo = false;
		int aux = 0;
		List<Produto> lista = dao.listarTodos();
		for(int i = 0; i < obj.length; i++) {
			
			if(obj[i] instanceof String) {
				nome = (String) obj[i];
				if(nome == null) {
					
				} else {
					aux = aux +1;
				}
			}
			if(obj[i] instanceof Categoria) {
				cat = (Categoria) obj[i];
				if(cat == null) {
					
				} else {
					aux = aux + 2;
				}
			}
			if(obj[i] instanceof Cor) {
				cor = (Cor) obj[i];
				if(cor == null) {
					
				} else {
					aux = aux + 4;
				}
			}
			if(obj[i] instanceof Genero) {
				gen = (Genero) obj[i];
				if(gen == null) {
					
				} else {
					aux = aux + 8;
				}
				
			}
			if(obj[i] instanceof Tamanho) {
				tam = (Tamanho) obj[i];
				if(tam == null) {
					
				} else {
					aux = aux + 16;
				}
			}
			if(obj[i] instanceof Colecao) {
				col = (Colecao) obj[i];
				if(col == null) {
					
				} else {
					aux = aux + 32;
				}
			}
			if(obj[i] instanceof Situacao) {
				sit = (Situacao) obj[i];
				if(sit == null) {
					
				} else {
					aux = aux + 64;
				}
			}
			if(obj[i] instanceof Boolean) {
				ativo = (Boolean) obj[i];
				if(ativo == null) {
					
				} else {
					aux = aux + 128;
				}
			}
		}
		
		if(aux == 1) {
			retorno = dao.obterPorNome(nome);
		} else if(aux == 2) {
			retorno = dao.obterPorCat(cat);
		} else if(aux == 3) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 4) {
			retorno = dao.obterPorCor(cor);
		} else if(aux == 5) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getCor().getId() == cor.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 6) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 7) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 8) {
			retorno = dao.obterPorGen(gen);
		} else if(aux == 9) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getGenero().getId() == gen.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 10) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 11) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 12) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getCor().getId() == cor.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 13) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 14) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 15) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 16) {
			retorno = dao.obterPorTam(tam);
		} else if(aux == 17) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getTamanho().getId() == tam.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 18) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getCategoria().getId() == cat.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 19) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 20) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getTamanho().getId() == tam.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 21) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 22) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 23) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 24) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getGenero().getId() == gen.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 25) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 26) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 27) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 28) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 29) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 30) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 31) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 32) {
			retorno = dao.obterPorCol(col);
		} else if(aux == 33) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 34) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 35) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 36) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 37) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 38) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 39) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 40) {
			for(int i = 0; i < lista.size(); i++) {
				if((lista.get(i).getGenero().getId() == gen.getId()) && 
						(lista.get(i).getColecao().getId() == col.getId())) {
					System.out.println("if aux = 40");
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 41) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 42) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 43) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 44) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 45) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 46) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 47) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 48) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 49) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 50) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getCategoria().getId() == cat.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 51) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 52) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 53) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 54) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 55) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 56) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 57) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 58) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 59) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 60) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() ==col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 61) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 62) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 63) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 64) {
			retorno = dao.obterPorSit(sit);
		}else if(aux == 65) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 66) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 67) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 68) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 69) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 70) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 71) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 72) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 73) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 74) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 75) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 76) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 77) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 78) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 79) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 80) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 81) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 82) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getCategoria().getId() == cat.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 83) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 84) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCor().getId()  == cor.getId() && 
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 85) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 86) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 87) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 88) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 89) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 90) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 91) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 92) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 93) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 94) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 95) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 96) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 97) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 98) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 99) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 100) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 101) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 102) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 103) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 104) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 105) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 106) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 107) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 108) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 109) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 110) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 111) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 112) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 113) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 114) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getCategoria().getId() == cat.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 115) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 116) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 117) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 118) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 119) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 120) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 121) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 122) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 123) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 124) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 125) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 126) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 127) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId()) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 128) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 129) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 130) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 131) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 132) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 133) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 134) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 135) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 136) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 137) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 138) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 139) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 140) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 141) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 142) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 143) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 144) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 145) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getTamanho().getId() == tam.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 146) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 147) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 148) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getTamanho().getId() == tam.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 149) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 150) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 151) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 152) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 153) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 154) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 155) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 156) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 157) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 158) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 159) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 160) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 161) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 162) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 163) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 164) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 165) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 166) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 167) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 168) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 169) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 170) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 171) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 172) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 173) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 174) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 175) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 176) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 177) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 178) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getCategoria().getId() == cat.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 179) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 180) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 181) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 182) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 183) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 184) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 185) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 186) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 187) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 188) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 189) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 190) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 191) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 192) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		}else if(aux == 193) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 194) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 195) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 196) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 197) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 198) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 199) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 200) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 201) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 202) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 203) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 204) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 205) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 206) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 207) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 208) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 209) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 210) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getCategoria().getId() == cat.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 211) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 212) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 213) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 214) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 215) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 216) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 217) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 218) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 219) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 220) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 221) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 222) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 223) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 224) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 225) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 226) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 227) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 228) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 229) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 230) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 231) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 232) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 233) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 234) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 235) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 236) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 237) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 238) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 239) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 240) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 241) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 242) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getCategoria().getId() == cat.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 243) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 244) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCor().getId() == cor.getId() && 
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 245) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 246) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 247) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 248) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getGenero().getId() == gen.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 249) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 250) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 251) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 252) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 253) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 254) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		} else if(aux == 255) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(nome) && 
						lista.get(i).getCategoria().getId() == cat.getId() &&
						lista.get(i).getCor().getId() == cor.getId() &&
						lista.get(i).getGenero().getId() == gen.getId() &&
						lista.get(i).getTamanho().getId() == tam.getId() && 
						lista.get(i).getColecao().getId() == col.getId() && 
						lista.get(i).getSituacao().getId() == sit.getId() &&
						lista.get(i).isStatus() == ativo) {
					Produto p = new Produto();
					
					p = lista.get(i);
					
					retorno.add(p);
				}
			}
		}
		return retorno;
	}
	public List<Produto> obterPorTam(Tamanho tam) {
		return dao.obterPorTam(tam);
	}
	
	public List<Produto> obterPorTam(Tamanho tam, boolean ativo) {
		List<Produto> retorno = new ArrayList<Produto>();
		List<Produto> lista = dao.obterPorTam(tam);
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).isStatus() == ativo) {
				Produto p = lista.get(i);
			
				retorno.add(p);
			}
		}
		return retorno;
	}
	
	public List<Produto> obterPorCol(Colecao c) {
		return dao.obterPorCol(c);
	}
	
	public List<Produto> obterPorCol(Colecao c, boolean ativo) {
		List<Produto> retorno = new ArrayList<Produto>();
		List<Produto> lista = dao.obterPorCol(c);
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).isStatus() == ativo) {
				Produto p = lista.get(i);
				
				retorno.add(p);
			}
		}
		return retorno;
	}
	
	public List<Produto> obterPorSit(Situacao s) {
		return dao.obterPorSit(s);
	}
	
	public List<Produto> obterPorSit(Situacao s, boolean ativo) {
		List<Produto> retorno = new ArrayList<Produto>();
		List<Produto> lista = dao.obterPorSit(s);
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).isStatus() == ativo) {
				Produto p = lista.get(i);
				
				retorno.add(p);
			}
		}
		return retorno;
	}
	
	public void excluirPorduto(Produto p) {
		dao.excluir(p);
	}
	
	public long proximoId() {
		return dao.gerarId();
	}
	
	public boolean validar(Produto p) {
		
		boolean valido = false;
		
		List<Produto> lista = this.obter();
		if(lista.size()==0) {
			valido = true;
		}else {
			valido = false;
		}
		for(int i = 0; i < lista.size(); i++) {
			if(p.getNome().equals(lista.get(i).getNome()) && 
					p.getCategoria().getId() == lista.get(i).getCategoria().getId() &&
					p.getCor().getId() == lista.get(i).getCor().getId() &&
					p.getGenero().getId() == lista.get(i).getGenero().getId() &&
					p.getTamanho().getId() == lista.get(i).getTamanho().getId() &&
					p.getColecao().getId() == lista.get(i).getColecao().getId()) {
				valido = false;
				break;
			} else {
				valido = true;
			}
		}
		return valido;
	}
}
