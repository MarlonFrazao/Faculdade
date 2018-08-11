package br.edu.unifacear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.model.Categoria;

public class CategoriaDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO CATEGORIA (id_cat, nome_cat, status_cat) values (?, ?, ?);";
	private String SQL_UPDATE = "UPDATE CATEGORIA SET nome_cat = ?, status_cat = ? where id_cat = ?;";
	private String SQL_SELECT = "SELECT * FROM CATEGORIA;";
	private String SQL_OBTER_ID = "SELECT * FROM CATEGORIA WHERE id_cat = ?;";
	private String SQL_OBTER_NOME ="SELECT * FROM CATEGORIA WHERE nome_cat like ? order by 2;";
	private String SQL_DELETE = "DELETE FROM CATEGORIA WHERE id_cat = ?;";
	private String SQL_GERAR_ID = "SELECT MAX(id_cat) FROM CATEGORIA;";
	
	public void inserir(Categoria c) {
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
	
	public void atualizar(Categoria c) {
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
	
	public List<Categoria> listarTodos() {
		List<Categoria> lista = new ArrayList<Categoria>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Categoria c = new Categoria(rs.getLong("id_cat"), 
						rs.getString("nome_cat"),
						rs.getBoolean("status_cat"));
				lista.add(c);
			}
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Categoria obterPorId(long id) {
		Categoria c = new Categoria();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				c = new Categoria(rs.getLong("id_cat"),
						rs.getString("nome_cat"),
						rs.getBoolean("status_cat"));
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public List<Categoria> obterPorNome(String nome) {
		List<Categoria> lista = new ArrayList<Categoria>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_NOME);
			
			ps.setString(1, '%'+nome+'%');
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Categoria c = new Categoria(rs.getLong("id_cat"),
						rs.getString("nome_cat"),
						rs.getBoolean("status_cat"));
				lista.add(c);
			}
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void excluir(Categoria c) {
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
