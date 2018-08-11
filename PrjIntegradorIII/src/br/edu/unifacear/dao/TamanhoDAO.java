package br.edu.unifacear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.model.Tamanho;



public class TamanhoDAO extends DAO{
	
	private String SQL_INSERT = "INSERT INTO TAMANHO (id_tam, nome_tam, status_tam) values (?, ?, ?);";
	private String SQL_UPDATE = "UPDATE TAMANHO SET nome_tam = ?, status_tam = ? where id_tam = ?;";
	private String SQL_SELECT = "SELECT * FROM TAMANHO;";
	private String SQL_OBTER_ID = "SELECT * FROM TAMANHO WHERE id_tam = ?;";
	private String SQL_OBTER_NOME = "SELECT * FROM TAMANHO WHERE nome_tam like ? ORDER BY 2;";
	private String SQL_DELETE = "DELETE FROM TAMANHO WHERE id_tam = ?;";
	private String SQL_GERAR_ID = "SELECT MAX(id_tam) FROM TAMANHO;";
	
	public void inserir(Tamanho tam) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setLong(1, tam.getId());
			ps.setString(2, tam.getNome());
			ps.setBoolean(3, tam.isStatus());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Tamanho tam) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setString(1, tam.getNome());
			ps.setBoolean(2, tam.isStatus());
			ps.setLong(3, tam.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Tamanho> listarTodos() {
		List<Tamanho> lista = new ArrayList<Tamanho>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Tamanho tam = new Tamanho(rs.getLong("id_tam"), 
						rs.getString("nome_tam"), 
						rs.getBoolean("status_tam"));
				
				lista.add(tam);
			}
			
			desconectar();
			
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Tamanho obterPorId(long id) {
		Tamanho tam = new Tamanho();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				tam = new Tamanho(rs.getLong("id_tam"), 
						rs.getString("nome_tam"), 
						rs.getBoolean("status_tam"));
			}
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return tam;
	}
	
	public List<Tamanho> obterPorNome(String nome) {
		List<Tamanho> lista = new ArrayList<Tamanho>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_NOME);
			
			ps.setString(1, '%'+nome+'%');
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Tamanho tam = new Tamanho(rs.getLong("id_tam"), 
						rs.getString("nome_tam"), 
						rs.getBoolean("status_tam"));
				
				lista.add(tam);
			}
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void excluir(Tamanho tam) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setLong(1, tam.getId());
			
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
