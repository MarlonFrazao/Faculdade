package testes;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.dao.EntradaDAO;
import br.edu.unifacear.model.Entrada;
import br.edu.unifacear.model.Produto;
import br.edu.unifacear.session.*;

public class Testes {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		/*ProdutoSession ps = new ProdutoSession();
		
		CategoriaSession cats = new CategoriaSession();
		ColecaoSession cols = new ColecaoSession();
		SituacaoSession sits = new SituacaoSession();
		GeneroSession gens = new GeneroSession();
		UnidadeSession unis = new UnidadeSession();
		TamanhoSession tams = new TamanhoSession();
		CorSession cors = new CorSession();*/
		/*
		List<Produto> lista = ps.buscaCruzada(gens.obter((long)1), cols.obter((long)1), true);
		for(int i = 0; i < lista.size(); i++) {
			System.out.println("ID: " + lista.get(i).getId() + 
									"\nNome: " + lista.get(i).getNome() + 
									"\nCategoria: " + lista.get(i).getCategoria().getNome() +
									"\nSituacao: " + lista.get(i).getSituacao().getDescricao() +
									"\nGenero: " + lista.get(i).getGenero().getNome() +
									"\nUnidade: " + lista.get(i).getUnidade().getNome() +
									"\nTamanho: " + lista.get(i).getTamanho().getNome() +
									"\nCor: " + lista.get(i).getCor().getNome() + 
									"\nColeção : " + lista.get(i).getColecao().getNome());
		}
		
		EntradaDAO edao = new EntradaDAO();
		
		List<Entrada> lista = edao.listarTodos();
		
		for(int i = 0; i < lista.size(); i++) {
			for(int j = 0; j < lista.get(i).getListaProdutos().size(); j++) {
				System.out.println("id da entrada: "+ lista.get(i).getId() + " - id do produto: " + lista.get(i).getListaProdutos().get(j).getId());
			}
		}*/
		
		EntradaSession eSession = new EntradaSession();
		
		List<Entrada> lista = new ArrayList<Entrada>();
		
		lista = eSession.obterPorPedido((long) 1);
		
		for(int i = 0; i < lista.size(); i++) {
			System.out.println("id da entrada: "+ lista.get(i).getId());
			for(int j = 0; j < lista.get(i).getListaProdutos().size(); j++) {
				System.out.println("   id do produto: " + lista.get(i).getListaProdutos().get(j).getId());
			}
		}
	}

}
