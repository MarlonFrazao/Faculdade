package br.edu.unifacear.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.model.Entrada;
import br.edu.unifacear.model.Produto;
import br.edu.unifacear.session.FuncionarioSession;
import br.edu.unifacear.session.ProdutoSession;

public class EntradaDAO extends DAO {
	private String SQL_INSERT_ENTRADA = "INSERT INTO ENTRADA (id_entrada, pedido_compra, data_entrada, mat_fun) VALUES (?, ?, ?, ?);";
	private String SQL_INSERT_PRODUTO_ENTRADA = "INSERT INTO PRODUTO_ENTRADA(id_produto, id_entrada, qtde_entrada, valor_unitario_compra, motivo_entrada) VALUES(?, ?, ?, ?, ?);";
	private String SQL_UPDATE = "UPDATE ENTRADA SET pedido_compra = ?, data_entrada = ?, mat_fun = ? where id_entrada = ?;";
	private String SQL_UPDATE_PRODUTO_ENTRADA = "UPDATE PRODUTO_ENTRADA SET qtde_entrada = ?, valor_unitario_compra = ?, motivo_entrada = ? where id_produto = ? and id_entrada = ?;";
	private String SQL_SELECT = "SELECT * FROM ENTRADA INNER JOIN PRODUTO_ENTRADA ON ENTRADA.id_entrada = PRODUTO_ENTRADA.id_entrada order by ENTRADA.id_entrada;";
	private String SQL_OBTER_ID = "SELECT * FROM ENTRADA INNER JOIN PRODUTO_ENTRADA ON ENTRADA.id_entrada = PRODUTO_ENTRADA.id_entrada WHERE ENTRADA.id_entrada = ? ORDER BY ENTRADA.id_entrada, PRODUTO_ENTRADA.id_produto;";
	private String SQL_OBTER_DATA = "SELECT * FROM ENTRADA INNER JOIN PRODUTO_ENTRADA ON ENTRADA.id_entrada = PRODUTO_ENTRADA.id_entrada WHERE ENTRADA.data_entrada = ?;";
	private String SQL_OBTER_FUN = "SELECT * FROM ENTRADA INNER JOIN PRODUTO_ENTRADA ON ENTRADA.id_entrada = PRODUTO_ENTRADA.id_entrada WHERE ENTRADA.mat_fun = ?;";
	private String SQL_OBTER_PEDIDO = "SELECT * FROM ENTRADA INNER JOIN PRODUTO_ENTRADA ON ENTRADA.id_entrada = PRODUTO_ENTRADA.id_entrada WHERE ENTRADA.pedido_compra = ?;";
	private String SQL_OBTER_PERIODO = "SELECT * FROM ENTRADA INNER JOIN PRODUTO_ENTRADA ON ENTRADA.id_entrada = PRODUTO_ENTRADA.id_entrada WHERE ENTRADA.data_entrada BETWEEN ? AND ?;";
	private String SQL_GERAR_ID = "SELECT MAX(id_entrada) FROM ENTRADA;";	
	
	public void inserir(Entrada e) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT_ENTRADA);
			
			ps.setLong(1, e.getId());
			ps.setLong(2, e.getPedidoCompra());
			ps.setDate(3, e.getDataEntrada());
			ps.setLong(4, e.getFuncionario().getMatricula());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void inserir(Entrada e, List<Produto> lp) {
		try {
			conectar();
			for(int i = 0; i < lp.size(); i++) {
				PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT_PRODUTO_ENTRADA);
				
				ps.setLong(1, lp.get(i).getId());
				ps.setLong(2, e.getId());
				ps.setLong(3, lp.get(i).getQtdeEntrada());
				ps.setFloat(4, lp.get(i).getValorEntrada());
				ps.setString(5, e.getMotivo());
				
				ps.executeUpdate();
				
				ps.close();
				
				lp.get(i).setQtde(lp.get(i).getQtde() + lp.get(i).getQtdeEntrada());
				
				ProdutoDAO pDAO = new ProdutoDAO();
				
				pDAO.atualizar(lp.get(i));
			}
			desconectar();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void atualizar(Entrada e) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setLong(1, e.getPedidoCompra());
			ps.setDate(2, e.getDataEntrada());
			ps.setLong(3, e.getFuncionario().getMatricula());
			ps.setLong(4, e.getId());
			
			ps.executeUpdate();
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void atualizar(Entrada e, List<Produto> lp) {
		try {
			conectar();
			for(int i = 0; i < lp.size(); i++) {
				PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE_PRODUTO_ENTRADA);
				
				ps.setLong(1, lp.get(i).getQtdeEntrada());
				ps.setFloat(2, lp.get(i).getValorEntrada());
				ps.setString(3, e.getMotivo());
				ps.setLong(4, lp.get(i).getId());
				ps.setLong(5, e.getId());
				
				ps.executeUpdate();
				
				ps.close();
				
				lp.get(i).setQtde(lp.get(i).getQtde() + lp.get(i).getQtdeEntrada());
				
				ProdutoDAO pDAO = new ProdutoDAO();
				
				pDAO.atualizar(lp.get(i));
			}
			desconectar();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public List<Entrada> listarTodos() {
		List<Entrada> retorno = new ArrayList<Entrada>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			Entrada e = new Entrada();
			FuncionarioSession fs = new FuncionarioSession();
			List<Produto> lp = new ArrayList<Produto>();
			ProdutoDAO pDAO = new ProdutoDAO();
			
			while(rs.next()) {
				//lp = pDAO.obterPorEntrada(rs.getLong("entrada.id_entrada"));
				e = new Entrada(rs.getLong("entrada.id_entrada"),
											rs.getLong("entrada.pedido_compra"),
											rs.getDate("entrada.data_entrada"),
											fs.obterPorMat(rs.getLong("entrada.mat_fun")),
											pDAO.obterPorEntrada(rs.getLong("entrada.id_entrada")),
											rs.getString("produto_entrada.motivo_entrada"));
				retorno.add(e);
			}
			desconectar();
			
			ps.close();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}
	
	public Entrada obterPorId(Long idEntrada) {
		Entrada e = new Entrada();
		FuncionarioSession fs = new FuncionarioSession();
		ProdutoDAO pDAO = new ProdutoDAO();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setLong(1, idEntrada);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				e = new Entrada(rs.getLong("entrada.id_entrada"),
									rs.getLong("entrada.pedido_compra"),
									rs.getDate("entrada.data_entrada"),
									fs.obterPorMat(rs.getLong("entrada.mat_fun")),
									pDAO.obterPorEntrada(rs.getLong("entrada.id_entrada")),
									rs.getString("produto_entrada.motivo_entrada"));
			}
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}
	public Entrada obterNumPed(Long numPed) {
		Entrada e = new Entrada();
		FuncionarioSession fs = new FuncionarioSession();
		ProdutoDAO pDAO = new ProdutoDAO();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_PEDIDO);
			
			ps.setLong(1, numPed);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				e = new Entrada(rs.getLong("entrada.id_entrada"),
									rs.getLong("entrada.pedido_compra"),
									rs.getDate("data_entrada"),
									fs.obterPorMat(rs.getLong("entrada.mat_fun")),
									pDAO.obterPorEntrada(rs.getLong("entrada.id_entrada")),
									rs.getString("motivo_entrada"));
			}
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}
	
	public List<Entrada> obterPorData(Date data) {
		List<Entrada> retorno = new ArrayList<Entrada>();
		FuncionarioSession fs = new FuncionarioSession();
		ProdutoDAO pDAO = new ProdutoDAO();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_DATA);
			
			ps.setDate(1, data);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Entrada e = new Entrada(rs.getLong("entrada.id_entrada"),
						rs.getLong("entrada.pedido_compra"),
						rs.getDate("entrada.data_entrada"),
						fs.obterPorMat(rs.getLong("entrada.mat_fun")),
						pDAO.obterPorEntrada(rs.getLong("entrada.id_entrada")),
						rs.getString("produto_entrada.motivo_entrada"));
				retorno.add(e);
			}
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}
	
	public List<Entrada> obterPorFun(Long matFun) {
		List<Entrada> retorno = new ArrayList<Entrada>();
		FuncionarioSession fs = new FuncionarioSession();
		ProdutoDAO pDAO = new ProdutoDAO();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_FUN);
			
			ps.setLong(1, matFun);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Entrada e = new Entrada(rs.getLong("entrada.id_entrada"),
						rs.getLong("entrada.pedido_compra"),
						rs.getDate("entrada.data_entrada"),
						fs.obterPorMat(rs.getLong("entrada.mat_fun")),
						pDAO.obterPorEntrada(rs.getLong("entrada.id_entrada")),
						rs.getString("produto_entrada.motivo_entrada"));
				retorno.add(e);
			}
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}
	
	public List<Entrada> obterPorPedido(long pedido) {
		List<Entrada> retorno = new ArrayList<Entrada>();
		FuncionarioSession fs = new FuncionarioSession();
		ProdutoDAO pDAO = new ProdutoDAO();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_PEDIDO);
			
			ps.setLong(1, pedido);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Entrada e = new Entrada(rs.getLong("entrada.id_entrada"),
						rs.getLong("entrada.pedido_compra"),
						rs.getDate("entrada.data_entrada"),
						fs.obterPorMat(rs.getLong("entrada.mat_fun")),
						pDAO.obterPorEntrada(rs.getLong("entrada.id_entrada")),
						rs.getString("produto_entrada.motivo_entrada"));
				retorno.add(e);
			}
			desconectar();
			
			ps.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return retorno;
	}
	
	public List<Entrada> obterPorPeriodo(Date inicio, Date fim) {
		List<Entrada> retorno = new ArrayList<Entrada>();
		FuncionarioSession fs = new FuncionarioSession();
		ProdutoDAO pDAO = new ProdutoDAO();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_PERIODO);
			
			ps.setDate(1, inicio);
			ps.setDate(2, fim);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Entrada e = new Entrada(rs.getLong("entrada.id_entrada"),
						rs.getLong("entrada.pedido_compra"),
						rs.getDate("entrada.data_entrada"),
						fs.obterPorMat(rs.getLong("entrada.mat_fun")),
						pDAO.obterPorEntrada(rs.getLong("entrada.id_entrada")),
						rs.getString("produto_entrada.motivo_entrada"));
				retorno.add(e);
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
