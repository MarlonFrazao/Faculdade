package br.edu.unifacear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.model.Cargo;

public class CargoDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO CARGO (id_cargo, nome_cargo, salario, status_cargo) values (?, ?, ?, ?);";
	private String SQL_UPDATE = "UPDATE CARGO SET nome_cargo = ?, salario = ?, status_cargo = ? where id_cargo = ?;";
	private String SQL_DELETE = "UPDATE CARGO SET status_cargo = ? where id_cargo = ?;";
	private String SQL_OBTER = "SELECT * FROM CARGO WHERE id_cargo = ?;";
	private String SQL_SELECT = "SELECT * FROM CARGO;";
	private String SQL_OBTER_NOME = "SELECT * FROM CARGO where nome_cargo like ? ORDER BY 2;";
	private String SQL_GERAR_ID = "SELECT MAX(id_cargo) FROM CARGO;"; 
	
	public void inserir (Cargo c) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setLong(1, c.getId());
			ps.setString(2, c.getNome());
			ps.setFloat(3, c.getSalario());
			ps.setBoolean(4, c.isStatus());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Cargo c) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setString(1, c.getNome());
			ps.setFloat(2, c.getSalario());
			ps.setBoolean(3, c.isStatus());
			ps.setLong(4, c.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Cargo c) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setBoolean(1, false);
			ps.setLong(2, c.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Cargo> obter() {
		List<Cargo> lista = new ArrayList<Cargo>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Cargo c = new Cargo(rs.getInt("id_cargo"),
						rs.getString("nome_cargo"),
						rs.getFloat("salario"),
						rs.getBoolean("status_cargo"));
				
				lista.add(c);
			}
			
			desconectar();
			
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Cargo obter(long id) {
		Cargo c = new Cargo();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER);
			
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				c = new Cargo(rs.getLong("id_cargo"),
						rs.getString("nome_cargo"),
						rs.getFloat("salario"),
						rs.getBoolean("status_cargo"));
			}
			
			desconectar();
			
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public List<Cargo> obter(String nome) {
		List<Cargo> lista = new ArrayList<Cargo>();
		
		try {
			
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_NOME);
			
			ps.setString(1, '%'+nome+'%');
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Cargo c = new Cargo(rs.getInt("id_cargo"),
						rs.getString("nome_cargo"),
						rs.getFloat("salario"),
						rs.getBoolean("status_cargo"));
				lista.add(c);
			}
			desconectar();
			
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
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
