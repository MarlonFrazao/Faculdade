package br.edu.unifacear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.model.Unidade;

public class UnidadeDAO extends DAO{
	
	private String SQL_INSERT = "INSERT INTO UNIDADE (id_Un, nome_Un, status_Un) values (?, ?, ?);";
	private String SQL_UPDATE = "UPDATE UNIDADE SET nome_Un = ?, status_Un = ? where id_Un = ?;";
	private String SQL_SELECT = "SELECT * FROM UNIDADE;";
	private String SQL_OBTER_ID = "SELECT * FROM UNIDADE WHERE id_Un = ?;";
	private String SQL_OBTER_NOME = "SELECT * FROM UNIDADE WHERE nome_Un like ? ORDER BY 2;";
	private String SQL_DELETE = "DELETE FROM UNIDADE WHERE id_Un = ?;";
	private String SQL_GERAR_ID = "SELECT MAX(id_Un) FROM UNIDADE;";
	
	public void inserir(Unidade Un) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setLong(1, Un.getId());
			ps.setString(2, Un.getNome());
			ps.setBoolean(3, Un.isStatus());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Unidade Un) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setString(1, Un.getNome());
			ps.setBoolean(2, Un.isStatus());
			ps.setLong(3, Un.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Unidade> listarTodos() {
		List<Unidade> lista = new ArrayList<Unidade>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Unidade Un = new Unidade(rs.getLong("id_Un"), 
						rs.getString("nome_Un"), 
						rs.getBoolean("status_Un"));
				
				lista.add(Un);
			}
			
			desconectar();
			
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Unidade obterPorId(long id) {
		Unidade Un = new Unidade();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Un = new Unidade(rs.getLong("id_Un"), 
						rs.getString("nome_Un"), 
						rs.getBoolean("status_Un"));
			}
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return Un;
	}
	
	public List<Unidade> obterPorNome(String nome) {
		List<Unidade> lista = new ArrayList<Unidade>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_NOME);
			
			ps.setString(1, '%'+nome+'%');
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Unidade Un = new Unidade(rs.getLong("id_Un"), 
						rs.getString("nome_Un"), 
						rs.getBoolean("status_Un"));
				
				lista.add(Un);
			}
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void excluir(Unidade Un) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setLong(1, Un.getId());
			
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
