package br.edu.unifacear.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.model.Entrada;
import br.edu.unifacear.model.Produto;
import br.edu.unifacear.model.Saida;
import br.edu.unifacear.session.FuncionarioSession;

public class SaidaDAO extends DAO {
	private String SQL_INSERT_SAIDA = "INSERT INTO SAIDA (id_saida, pedido_venda, data_saida, mat_fun) values (?, ?, ?, ?);";
	private String SQL_INSERT_PRODUTO_SAIDA = "INSERT INTO PRODUTO_SAIDA (id_produto, id_saida, qtde_saida, valor_unitario_venda, motivo_saida) values (?, ?, ?, ?, ?);";
	private String SQL_UPDATE_SAIDA = "UPDATE SAIDA SET pedido_venda = ?, data_saida = ?, mat_fun = ? where id_saida = ?;";
	private String SQL_UPDATE_PRODUTO_SAIDA = "UPDATE PRODUTO_SAIDA SET qtde_saida = ?, valor_unitario_venda = ?, motivo_saida = ? where id_produto = ? and id_saida = ?;";
	private String SQL_SELECT = "SELECT * FROM SAIDA INNER JOIN PRODUTO_SAIDA ON SAIDA.id_saida = PRODUTO_SAIDA.id_saida ORDER BY SAIDA.id_saida;";
	private String SQL_OBTER_ID = "SELECT * FROM SAIDA INNER JOIN PRODUTO_SAIDA ON SAIDA.id_saida = PRODUTO_SAIDA.id_saida WHERE SAIDA.id_saida = ? ORDER BY SAIDA.id_saida, PRODUTO_SAIDA.id_produto;";
	private String SQL_OBTER_DATA = "SELECT * FROM SAIDA INNER JOIN PRODUTO_SAIDA ON SAIDA.id_saida = PRODUTO_SAIDA.id_saida WHERE SAIDA.data_saida = ? ORDER BY SAIDA.id_saida;";
	private String SQL_OBTER_FUN = "SELECT * FROM SAIDA INNER JOIN PRODUTO_SAIDA ON SAIDA.id_saida = PRODUTO_SAIDA.id_saida WHERE SAIDA.mat_fun = ? ORDER BY SAIDA.id_saida;";
	private String SQL_OBTER_PEDIDO = "SELECT * FROM SAIDA INNER JOIN PRODUTO_SAIDA ON SAIDA.id_saida = PRODUTO_SAIDA.id_saida WHERE SAIDA.pedido_venda = ? ORDER BY SAIDA.id_saida;";
	private String SQL_OBTER_PERIODO = "SELECT * FROM SAIDA INNER JOIN PRODUTO_SAIDA ON SAIDA.id_saida = PRODUTO_SAIDA.id_saida WHERE data_saida BETWEEN ? AND ?;";
	private String SQL_GERAR_ID = "SELECT MAX(id_saida) FROM SAIDA;";
	
	public void inserir(Saida s) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT_SAIDA);
			
			ps.setLong(1, s.getId());
			ps.setLong(2, s.getPedidoVenda());
			ps.setDate(3, s.getDataSaida());
			ps.setLong(4, s.getFuncionario().getMatricula());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void inserir(Saida s, List<Produto> lp) {
		try {
			conectar();
			for(int i = 0; i < lp.size(); i++) {
				PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT_PRODUTO_SAIDA);
				
				ps.setLong(1, lp.get(i).getId());
				ps.setLong(2, s.getId());
				ps.setLong(3, lp.get(i).getQtdeSaida());
				ps.setFloat(4, lp.get(i).getValorSaida());
				ps.setString(5, s.getMotivo());
				
				ps.executeUpdate();
				
				ps.close();
				
				lp.get(i).setQtde(lp.get(i).getQtde() - lp.get(i).getQtdeSaida());
				
				ProdutoDAO pDAO = new ProdutoDAO();
				
				pDAO.atualizar(lp.get(i));
			}
			desconectar();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void atualizar(Saida s) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_SAIDA);
			
			ps.setLong(1, s.getPedidoVenda());
			ps.setDate(2, s.getDataSaida());
			ps.setLong(3, s.getFuncionario().getMatricula());
			ps.setLong(4, s.getId());
			
			ps.executeUpdate();
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void atualizar(Saida s, List<Produto> lp) {
		try {
			conectar();
			for(int i = 0; i < lp.size(); i++) {
				PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_PRODUTO_SAIDA);
				
				ps.setLong(1, lp.get(i).getQtdeSaida());
				ps.setFloat(2, lp.get(i).getValorSaida());
				ps.setString(3, s.getMotivo());
				ps.setLong(4, lp.get(i).getId());
				ps.setLong(5, s.getId());
				
				ps.executeUpdate();
				
				ps.close();
				
				lp.get(i).setQtde(lp.get(i).getQtde() - lp.get(i).getQtdeSaida());
				
				ProdutoDAO pDAO = new ProdutoDAO();
				
				pDAO.atualizar(lp.get(i));
			}
			desconectar();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	} 
	
	public List<Saida> listarTodos() {
		List<Saida> retorno = new ArrayList<Saida>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			Saida s = new Saida();
			FuncionarioSession fs = new FuncionarioSession();
			List<Produto> lp = new ArrayList<Produto>();
			ProdutoDAO pDAO = new ProdutoDAO();
			
			while(rs.next()) {
				lp = pDAO.obterPorSaida(rs.getLong("saida.id_saida"));
				s = new Saida(rs.getLong("saida.id_saida"),
											rs.getLong("saida.pedido_venda"),
											rs.getDate("saida.data_saida"),
											fs.obterPorMat(rs.getLong("saida.mat_fun")),
											lp,
											rs.getString("produto_saida.motivo_saida"));
				retorno.add(s);
			}
			desconectar();
			
			ps.close();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}
	
	public Saida obterPorId(Long idSaida) {
		Saida s = new Saida();
		FuncionarioSession fs = new FuncionarioSession();
		ProdutoDAO pDAO = new ProdutoDAO();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setLong(1, idSaida);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				s = new Saida(rs.getLong("saida.id_saida"),
									rs.getLong("saida.pedido_venda"),
									rs.getDate("saida.data_saida"),
									fs.obterPorMat(rs.getLong("saida.mat_fun")),
									pDAO.obterPorSaida(rs.getLong("saida.id_saida")),
									rs.getString("saida.motivo_saida"));
			}
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return s;
	}
	
	public Saida obterPedVenda(Long pedVenda) {
		Saida s = new Saida();
		FuncionarioSession fs = new FuncionarioSession();
		ProdutoDAO pDAO = new ProdutoDAO();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_PEDIDO);
			
			ps.setLong(1, pedVenda);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				s = new Saida(rs.getLong("saida.id_saida"),
									rs.getLong("saida.pedido_venda"),
									rs.getDate("saida.data_saida"),
									fs.obterPorMat(rs.getLong("saida.mat_fun")),
									pDAO.obterPorSaida(rs.getLong("saida.id_saida")),
									rs.getString("motivo_saida"));
			}
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return s;
	}
	
	public List<Saida> obterPorData(Date data) {
		List<Saida> retorno = new ArrayList<Saida>();
		FuncionarioSession fs = new FuncionarioSession();
		ProdutoDAO pDAO = new ProdutoDAO();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_DATA);
			
			ps.setDate(1, data);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Saida s = new Saida(rs.getLong("saida.id_saida"),
						rs.getLong("saida.pedido_venda"),
						rs.getDate("saida.data_saida"),
						fs.obterPorMat(rs.getLong("saida.mat_fun")),
						pDAO.obterPorSaida(rs.getLong("saida.id_saida")),
						rs.getString("saida.motivo_saida"));
				retorno.add(s);
			}
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}
	
	public List<Saida> obterPorFun(Long matFun) {
		List<Saida> retorno = new ArrayList<Saida>();
		FuncionarioSession fs = new FuncionarioSession();
		ProdutoDAO pDAO = new ProdutoDAO();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_FUN);
			
			ps.setLong(1, matFun);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Saida s = new Saida(rs.getLong("saida.id_saida"),
						rs.getLong("saida.pedido_venda"),
						rs.getDate("saida.data_saida"),
						fs.obterPorMat(rs.getLong("saida.mat_fun")),
						pDAO.obterPorEntrada(rs.getLong("saida.id_saida")),
						rs.getString("saida.motivo_saida"));
				retorno.add(s);
			}
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}
	
	public List<Saida> obterPorPedido(long pedido) {
		List<Saida> retorno = new ArrayList<Saida>();
		FuncionarioSession fs = new FuncionarioSession();
		ProdutoDAO pDAO = new ProdutoDAO();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_PEDIDO);
			
			ps.setLong(1, pedido);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Saida s = new Saida(rs.getLong("saida.id_saida"),
						rs.getLong("saida.pedido_venda"),
						rs.getDate("saida.data_saida"),
						fs.obterPorMat(rs.getLong("saida.mat_fun")),
						pDAO.obterPorEntrada(rs.getLong("saida.id_entrada")),
						rs.getString("saida.motivo_saida"));
				retorno.add(s);
			}
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}
	
	public List<Saida> obterPorPeriodo(Date inicio, Date fim) {
		List<Saida> retorno = new ArrayList<Saida>();
		FuncionarioSession fs = new FuncionarioSession();
		ProdutoDAO pDAO = new ProdutoDAO();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_PERIODO);
			
			ps.setDate(1, inicio);
			ps.setDate(2, fim);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Saida s = new Saida(rs.getLong("saida.id_saida"),
						rs.getLong("saida.pedido_venda"),
						rs.getDate("saida.data_saida"),
						fs.obterPorMat(rs.getLong("saida.mat_fun")),
						pDAO.obterPorEntrada(rs.getLong("saida.id_entrada")),
						rs.getString("saida.motivo_saida"));
				retorno.add(s);
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
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
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return id;
	}
}
