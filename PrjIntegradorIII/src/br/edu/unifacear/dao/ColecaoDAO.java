package br.edu.unifacear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.model.Colecao;

public class ColecaoDAO extends DAO{
	private String SQL_INSERT = "INSERT INTO COLECAO(id_col, nome_col, status_col) values (?, ?, ?);";
	private String SQL_UPDATE = "UPDATE COLECAO SET nome_col = ?, status_col = ? where id_col = ?;";
	private String SQL_SELECT = "SELECT * FROM COLECAO;";
	private String SQL_OBTER_ID = "SELECT * FROM COLECAO WHERE id_col = ?;";
	private String SQL_OBTER_NOME = "SELECT * FROM COLECAO WHERE nome_col like ? order by 2;";
	private String SQL_DELETE = "DELETE FROM COLECAO WHERE id_col = ?;";
	private String SQL_GERAR_ID = "SELECT MAX(id_col) FROM COLECAO;";
	
	public void inserir(Colecao c) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setLong(1, c.getId());
			ps.setString(2, c.getNome());
			ps.setBoolean(3, c.isStatus());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Colecao c) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setString(1, c.getNome());
			ps.setBoolean(2, c.isStatus());
			ps.setLong(3, c.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Colecao> listarTodos() {
		List<Colecao> lista = new ArrayList<Colecao> ();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Colecao c = new Colecao(rs.getLong("id_col"),
						rs.getString("nome_col"),
						rs.getBoolean("status_col"));
				lista.add(c);
			}
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Colecao> obterPorNome(String nome) {
		List<Colecao> lista = new ArrayList<Colecao>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_NOME);
			
			ps.setString(1, '%'+nome+'%');
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Colecao c = new Colecao(rs.getLong("id_col"),
						rs.getString("nome_col"),
						rs.getBoolean("status_col"));
				lista.add(c);
			}
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Colecao obterPorId (Long id) {
		Colecao c = new Colecao();
		try {
			
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				c = new Colecao(rs.getLong("id_col"),
						rs.getString("nome_col"),
						rs.getBoolean("status_col"));
						
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public void excluir(Colecao c) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setLong(1, c.getId());
			
			ps.executeUpdate();
			
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
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}

}
