package br.edu.unifacear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.model.Cor;

public class CorDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO COR (id_cor, nome_cor, status_cor) values (?, ?, ?);";
	private String SQL_UPDATE = "UPDATE COR SET nome_cor = ?, status_cor = ? where id_cor = ?;";
	private String SQL_SELECT = "SELECT * FROM COR;";
	private String SQL_OBTER_ID = "SELECT * FROM COR WHERE id_cor = ?;";
	private String SQL_OBTER_NOME = "SELECT * FROM COR WHERE nome_cor like ? ORDER BY 2;";
	private String SQL_DELETE = "DELETE FROM COR WHERE id_cor = ?;";
	private String SQL_GERAR_ID = "SELECT MAX(id_cor) FROM COR;";
	
	public void inserir(Cor c) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setLong(1, c.getId());
			ps.setString(2, c.getNome());
			ps.setBoolean(3, c.isStatus());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Cor c) {
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
	
	public List<Cor> listarTodos() {
		List<Cor> lista = new ArrayList<Cor>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Cor c = new Cor(rs.getLong("id_cor"), 
						rs.getString("nome_cor"), 
						rs.getBoolean("status_cor"));
				
				lista.add(c);
			}
			
			desconectar();
			
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Cor obterPorId(long id) {
		Cor c = new Cor();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				c = new Cor(rs.getLong("id_cor"), 
						rs.getString("nome_cor"), 
						rs.getBoolean("status_cor"));
			}
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public List<Cor> obterPorNome(String nome) {
		List<Cor> lista = new ArrayList<Cor>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_NOME);
			
			ps.setString(1, '%'+nome+'%');
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Cor c = new Cor(rs.getLong("id_cor"), 
						rs.getString("nome_cor"), 
						rs.getBoolean("status_cor"));
				
				lista.add(c);
			}
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void excluir(Cor c) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setLong(1, c.getId());
			
			
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
				id = rs.getLong(1)+1;
			}
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}

}
