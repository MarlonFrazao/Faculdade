package br.edu.unifacear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.session.CategoriaSession;
import br.edu.unifacear.session.ColecaoSession;
import br.edu.unifacear.session.CorSession;
import br.edu.unifacear.session.GeneroSession;
import br.edu.unifacear.session.SituacaoSession;
import br.edu.unifacear.session.TamanhoSession;
import br.edu.unifacear.session.UnidadeSession;
import br.edu.unifacear.model.Categoria;
import br.edu.unifacear.model.Colecao;
import br.edu.unifacear.model.Cor;
import br.edu.unifacear.model.Genero;
import br.edu.unifacear.model.Produto;
import br.edu.unifacear.model.Situacao;
import br.edu.unifacear.model.Tamanho;

public class ProdutoDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO PRODUTO (id_produto, nome_produto, status_produto, qtde_produto, id_cat, id_cor, id_gen, volume, peso, id_un, id_tam, num_pontos, qtde_minima, qtde_maxima, id_col, id_sit, valor_unitario) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private String SQL_UPDATE = "UPDATE PRODUTO SET nome_produto = ?, status_produto = ?, qtde_produto = ?, id_cat = ?, id_cor = ?, id_gen = ?, volume = ?, peso = ?, id_un = ?, id_tam = ?, num_pontos = ?, qtde_minima = ?, qtde_maxima = ?, id_col = ?, id_sit = ?, valor_unitario = ? where id_produto = ?;";
	private String SQL_SELECT = "SELECT * FROM PRODUTO;";
	private String SQL_OBTER_ID = "SELECT * FROM PRODUTO WHERE id_produto = ?;";
	private String SQL_OBTER_NOME = "SELECT * FROM PRODUTO WHERE nome_produto like ? order by 2;";
	private String SQL_OBTER_CAT = "SELECT * FROM PRODUTO WHERE id_cat = ?;";
	private String SQL_OBTER_COR = "SELECT * FROM PRODUTO WHERE id_cor = ?;";
	private String SQL_OBTER_GEN = "SELECT * FROM PRODUTO WHERE id_gen = ?;";
	private String SQL_OBTER_TAM = "SELECT * FROM PRODUTO WHERE id_tam = ?;";
	private String SQL_OBTER_COL = "SELECT * FROM PRODUTO WHERE id_col = ?;";
	private String SQL_OBTER_SIT = "SELECT * FROM PRODUTO WHERE id_sit = ?;";
	private String SQL_OBTER_ENTRADA = "SELECT ID_PRODUTO, QTDE_ENTRADA FROM PRODUTO_ENTRADA WHERE ID_ENTRADA = ?;";
	private String SQL_OBTER_SAIDA = "SELECT ID_PRODUTO, QTDE_SAIDA FROM PRODUTO_SAIDA WHERE ID_SAIDA = ?;";
	private String SQL_DELETE = "UPDATE PRODUTO SET status_produto = ? where id_produto = ?;";
	private String SQL_GERAR_ID = "SELECT MAX(id_produto) FROM PRODUTO;";
	
	public void inserir(Produto p) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setLong(1, p.getId());
			ps.setString(2, p.getNome());
			ps.setBoolean(3, p.isStatus());
			ps.setLong(4, p.getQtde());
			ps.setLong(5, p.getCategoria().getId());
			ps.setLong(6, p.getCor().getId());
			ps.setLong(7, p.getGenero().getId());
			ps.setFloat(8, p.getVolume());
			ps.setFloat(9, p.getPeso());
			ps.setLong(10, p.getUnidade().getId());
			ps.setLong(11, p.getTamanho().getId());
			ps.setLong(12, p.getNumPontos());
			ps.setLong(13, p.getQtdeMin());
			ps.setLong(14, p.getQtdeMax());
			ps.setLong(15, p.getColecao().getId());
			ps.setLong(16, p.getSituacao().getId());
			ps.setFloat(17, p.getValorUnitario());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	} 
	
	public void atualizar(Produto p) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setString(1, p.getNome());
			ps.setBoolean(2, p.isStatus());
			ps.setLong(3, p.getQtde());
			ps.setLong(4, p.getCategoria().getId());
			ps.setLong(5, p.getCor().getId());
			ps.setLong(6, p.getGenero().getId());
			ps.setFloat(7, p.getVolume());
			ps.setFloat(8, p.getPeso());
			ps.setLong(9, p.getUnidade().getId());
			ps.setLong(10, p.getTamanho().getId());
			ps.setLong(11, p.getNumPontos());
			ps.setLong(12, p.getQtdeMin());
			ps.setLong(13, p.getQtdeMax());
			ps.setLong(14, p.getColecao().getId());
			ps.setLong(15, p.getSituacao().getId());
			ps.setFloat(16, p.getValorUnitario());
			ps.setLong(17, p.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Produto> listarTodos() {
		List<Produto> lista = new ArrayList<Produto>();
		try {
			
			CategoriaSession cat = new CategoriaSession();
			CorSession cor = new CorSession();
			GeneroSession gen = new GeneroSession();
			UnidadeSession un = new UnidadeSession();
			TamanhoSession tam = new TamanhoSession();
			ColecaoSession col = new ColecaoSession();
			SituacaoSession sit = new SituacaoSession();
			
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Produto p = new Produto(rs.getLong("id_produto"),
						rs.getString("nome_produto"),
						rs.getBoolean("status_produto"),
						rs.getLong("qtde_produto"),
						cat.obter(rs.getLong("id_cat")),
						cor.obter(rs.getLong("id_cor")),
						gen.obter(rs.getLong("id_gen")),
						rs.getFloat("volume"),
						rs.getFloat("peso"),
						un.obter(rs.getLong("id_un")),
						tam.obter(rs.getLong("id_tam")),
						rs.getLong("num_pontos"),
						rs.getLong("qtde_minima"),
						rs.getLong("qtde_maxima"),
						col.obter(rs.getLong("id_col")),
						sit.obter(rs.getLong("id_sit")),
						rs.getFloat("valor_unitario"));
				
				lista.add(p);
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Produto obterPorId(long id) {
		Produto p = new Produto();
		try {
			CategoriaSession cat = new CategoriaSession();
			CorSession cor = new CorSession();
			GeneroSession gen = new GeneroSession();
			UnidadeSession un = new UnidadeSession();
			TamanhoSession tam = new TamanhoSession();
			ColecaoSession col = new ColecaoSession();
			SituacaoSession sit = new SituacaoSession();
		
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				p = new Produto(rs.getLong("id_produto"), 
						rs.getString("nome_produto"), 
						rs.getBoolean("status_produto"),
						rs.getLong("qtde_produto"), 
						cat.obter(rs.getLong("id_cat")), 
						cor.obter(rs.getLong("id_cor")),
						gen.obter(rs.getLong("id_gen")), 
						rs.getFloat("volume"), 
						rs.getFloat("peso"),
						un.obter(rs.getLong("id_un")), 
						tam.obter(rs.getLong("id_tam")), 
						rs.getLong("num_pontos"),
						rs.getLong("qtde_minima"), 
						rs.getLong("qtde_maxima"), 
						col.obter(rs.getLong("id_col")),
						sit.obter(rs.getLong("id_sit")), 
						rs.getFloat("valor_unitario"));
			}

			desconectar();

			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public List<Produto> obterPorNome(String nome) {
		List<Produto> lista = new ArrayList<Produto>();
		try {
			CategoriaSession cat = new CategoriaSession();
			CorSession cor = new CorSession();
			GeneroSession gen = new GeneroSession();
			UnidadeSession un = new UnidadeSession();
			TamanhoSession tam = new TamanhoSession();
			ColecaoSession col = new ColecaoSession();
			SituacaoSession sit = new SituacaoSession();
		
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_NOME);
			
			ps.setString(1, '%'+nome+'%');
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Produto p = new Produto(rs.getLong("id_produto"), 
						rs.getString("nome_produto"), 
						rs.getBoolean("status_produto"),
						rs.getLong("qtde_produto"), 
						cat.obter(rs.getLong("id_cat")), 
						cor.obter(rs.getLong("id_cor")),
						gen.obter(rs.getLong("id_gen")), 
						rs.getFloat("volume"), 
						rs.getFloat("peso"),
						un.obter(rs.getLong("id_un")), 
						tam.obter(rs.getLong("id_tam")), 
						rs.getLong("num_pontos"),
						rs.getLong("qtde_minima"), 
						rs.getLong("qtde_maxima"), 
						col.obter(rs.getLong("id_col")),
						sit.obter(rs.getLong("id_sit")), 
						rs.getFloat("valor_unitario"));
				lista.add(p);
			}

			desconectar();

			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Produto> obterPorCat(Categoria categoria) {
		List<Produto> lista = new ArrayList<Produto>();
		try {
			CategoriaSession cat = new CategoriaSession();
			CorSession cor = new CorSession();
			GeneroSession gen = new GeneroSession();
			UnidadeSession un = new UnidadeSession();
			TamanhoSession tam = new TamanhoSession();
			ColecaoSession col = new ColecaoSession();
			SituacaoSession sit = new SituacaoSession();
		
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_CAT);
			
			ps.setLong(1, categoria.getId());
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Produto p = new Produto(rs.getLong("id_produto"), 
						rs.getString("nome_produto"), 
						rs.getBoolean("status_produto"),
						rs.getLong("qtde_produto"), 
						cat.obter(rs.getLong("id_cat")), 
						cor.obter(rs.getLong("id_cor")),
						gen.obter(rs.getLong("id_gen")), 
						rs.getFloat("volume"), 
						rs.getFloat("peso"),
						un.obter(rs.getLong("id_un")), 
						tam.obter(rs.getLong("id_tam")), 
						rs.getLong("num_pontos"),
						rs.getLong("qtde_minima"), 
						rs.getLong("qtde_maxima"), 
						col.obter(rs.getLong("id_col")),
						sit.obter(rs.getLong("id_sit")), 
						rs.getFloat("valor_unitario"));
				lista.add(p);
			}

			desconectar();

			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Produto> obterPorCor(Cor c) {
		List<Produto> lista = new ArrayList<Produto>();
		try {
			CategoriaSession cat = new CategoriaSession();
			CorSession cor = new CorSession();
			GeneroSession gen = new GeneroSession();
			UnidadeSession un = new UnidadeSession();
			TamanhoSession tam = new TamanhoSession();
			ColecaoSession col = new ColecaoSession();
			SituacaoSession sit = new SituacaoSession();
		
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_COR);
			
			ps.setLong(1, c.getId());
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Produto p = new Produto(rs.getLong("id_produto"), 
						rs.getString("nome_produto"), 
						rs.getBoolean("status_produto"),
						rs.getLong("qtde_produto"), 
						cat.obter(rs.getLong("id_cat")), 
						cor.obter(rs.getLong("id_cor")),
						gen.obter(rs.getLong("id_gen")), 
						rs.getFloat("volume"), 
						rs.getFloat("peso"),
						un.obter(rs.getLong("id_un")), 
						tam.obter(rs.getLong("id_tam")), 
						rs.getLong("num_pontos"),
						rs.getLong("qtde_minima"), 
						rs.getLong("qtde_maxima"), 
						col.obter(rs.getLong("id_col")),
						sit.obter(rs.getLong("id_sit")), 
						rs.getFloat("valor_unitario"));
				lista.add(p);
			}

			desconectar();

			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Produto> obterPorGen(Genero g) {
		List<Produto> lista = new ArrayList<Produto>();
		try {
			CategoriaSession cat = new CategoriaSession();
			CorSession cor = new CorSession();
			GeneroSession gen = new GeneroSession();
			UnidadeSession un = new UnidadeSession();
			TamanhoSession tam = new TamanhoSession();
			ColecaoSession col = new ColecaoSession();
			SituacaoSession sit = new SituacaoSession();
		
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_GEN);
			
			ps.setLong(1, g.getId());
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Produto p = new Produto(rs.getLong("id_produto"), 
						rs.getString("nome_produto"), 
						rs.getBoolean("status_produto"),
						rs.getLong("qtde_produto"), 
						cat.obter(rs.getLong("id_cat")), 
						cor.obter(rs.getLong("id_cor")),
						gen.obter(rs.getLong("id_gen")), 
						rs.getFloat("volume"), 
						rs.getFloat("peso"),
						un.obter(rs.getLong("id_un")), 
						tam.obter(rs.getLong("id_tam")), 
						rs.getLong("num_pontos"),
						rs.getLong("qtde_minima"), 
						rs.getLong("qtde_maxima"), 
						col.obter(rs.getLong("id_col")),
						sit.obter(rs.getLong("id_sit")), 
						rs.getFloat("valor_unitario"));
				lista.add(p);
			}

			desconectar();

			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Produto> obterPorTam(Tamanho t) {
		List<Produto> lista = new ArrayList<Produto>();
		try {
			CategoriaSession cat = new CategoriaSession();
			CorSession cor = new CorSession();
			GeneroSession gen = new GeneroSession();
			UnidadeSession un = new UnidadeSession();
			TamanhoSession tam = new TamanhoSession();
			ColecaoSession col = new ColecaoSession();
			SituacaoSession sit = new SituacaoSession();
		
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_TAM);
			
			ps.setLong(1, t.getId());
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Produto p = new Produto(rs.getLong("id_produto"), 
						rs.getString("nome_produto"), 
						rs.getBoolean("status_produto"),
						rs.getLong("qtde_produto"), 
						cat.obter(rs.getLong("id_cat")), 
						cor.obter(rs.getLong("id_cor")),
						gen.obter(rs.getLong("id_gen")), 
						rs.getFloat("volume"), 
						rs.getFloat("peso"),
						un.obter(rs.getLong("id_un")), 
						tam.obter(rs.getLong("id_tam")), 
						rs.getLong("num_pontos"),
						rs.getLong("qtde_minima"), 
						rs.getLong("qtde_maxima"), 
						col.obter(rs.getLong("id_col")),
						sit.obter(rs.getLong("id_sit")), 
						rs.getFloat("valor_unitario"));
				lista.add(p);
			}

			desconectar();

			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Produto> obterPorCol(Colecao c) {
		List<Produto> lista = new ArrayList<Produto>();
		try {
			CategoriaSession cat = new CategoriaSession();
			CorSession cor = new CorSession();
			GeneroSession gen = new GeneroSession();
			UnidadeSession un = new UnidadeSession();
			TamanhoSession tam = new TamanhoSession();
			ColecaoSession col = new ColecaoSession();
			SituacaoSession sit = new SituacaoSession();
		
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_COL);
			
			ps.setLong(1, c.getId());
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Produto p = new Produto(rs.getLong("id_produto"), 
						rs.getString("nome_produto"), 
						rs.getBoolean("status_produto"),
						rs.getLong("qtde_produto"), 
						cat.obter(rs.getLong("id_cat")), 
						cor.obter(rs.getLong("id_cor")),
						gen.obter(rs.getLong("id_gen")), 
						rs.getFloat("volume"), 
						rs.getFloat("peso"),
						un.obter(rs.getLong("id_un")), 
						tam.obter(rs.getLong("id_tam")), 
						rs.getLong("num_pontos"),
						rs.getLong("qtde_minima"), 
						rs.getLong("qtde_maxima"), 
						col.obter(rs.getLong("id_col")),
						sit.obter(rs.getLong("id_sit")), 
						rs.getFloat("valor_unitario"));
				lista.add(p);
			}

			desconectar();

			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Produto> obterPorSit(Situacao s) {
		List<Produto> lista = new ArrayList<Produto>();
		try {
			CategoriaSession cat = new CategoriaSession();
			CorSession cor = new CorSession();
			GeneroSession gen = new GeneroSession();
			UnidadeSession un = new UnidadeSession();
			TamanhoSession tam = new TamanhoSession();
			ColecaoSession col = new ColecaoSession();
			SituacaoSession sit = new SituacaoSession();
		
			conectar();

			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_SIT);
			
			ps.setLong(1, s.getId());
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Produto p = new Produto(rs.getLong("id_produto"), 
						rs.getString("nome_produto"), 
						rs.getBoolean("status_produto"),
						rs.getLong("qtde_produto"), 
						cat.obter(rs.getLong("id_cat")), 
						cor.obter(rs.getLong("id_cor")),
						gen.obter(rs.getLong("id_gen")), 
						rs.getFloat("volume"), 
						rs.getFloat("peso"),
						un.obter(rs.getLong("id_un")), 
						tam.obter(rs.getLong("id_tam")), 
						rs.getLong("num_pontos"),
						rs.getLong("qtde_minima"), 
						rs.getLong("qtde_maxima"), 
						col.obter(rs.getLong("id_col")),
						sit.obter(rs.getLong("id_sit")), 
						rs.getFloat("valor_unitario"));
				lista.add(p);
			}

			desconectar();

			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Produto> obterPorEntrada(Long idEntrada) {
		List<Produto> retorno = new ArrayList<Produto>();
		try {
			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ENTRADA);
			
			ps.setLong(1, idEntrada);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Produto p = this.obterPorId(rs.getLong(1));
				p.setQtdeEntrada(rs.getLong(2));
				retorno.add(p);
			}
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}
	
	public List<Produto> obterPorSaida(Long idSaida) {
		List<Produto> retorno = new ArrayList<Produto>();
		try {
			conectar();
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_SAIDA);
			
			ps.setLong(1, idSaida);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Produto p = this.obterPorId(rs.getLong(1));
				p.setQtdeSaida(rs.getLong(2));
				retorno.add(p);
			}
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}
	
	public void excluir(Produto p) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setLong(1, p.getId());
			ps.setBoolean(2, false);
			
			
			ps.executeQuery();
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public long gerarId() {
		long id = 0;
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_GERAR_ID);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				id = rs.getLong(1) + 1;
			}
			desconectar();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}
}
