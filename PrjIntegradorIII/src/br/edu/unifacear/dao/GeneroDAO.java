package br.edu.unifacear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.model.Genero;

public class GeneroDAO extends DAO {
	
	private String SQL_INSERT = "INSERT INTO GENERO (id_gen, nome_gen, status_gen) values (?, ?, ?);";
	private String SQL_UPDATE = "UPDATE GENERO SET nome_gen = ?, status_gen = ? where id_gen = ?;";
	private String SQL_SELECT = "SELECT * FROM GENERO;";
	private String SQL_OBTER_ID = "SELECT * FROM GENERO WHERE id_gen = ?;";
	private String SQL_OBTER_NOME = "SELECT * FROM GENERO WHERE nome_gen like ? ORDER BY 2;";
	private String SQL_DELETE = "DELETE FROM GENERO WHERE id_gen = ?;";
	private String SQL_GERAR_ID = "SELECT MAX(id_gen) FROM GENERO;";
	
	public void inserir(Genero gen) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setLong(1, gen.getId());
			ps.setString(2, gen.getNome());
			ps.setBoolean(3, gen.isStatus());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Genero gen) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setString(1, gen.getNome());
			ps.setBoolean(2, gen.isStatus());
			ps.setLong(3, gen.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Genero> listarTodos() {
		List<Genero> lista = new ArrayList<Genero>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Genero gen = new Genero(rs.getLong("id_gen"), 
						rs.getString("nome_gen"), 
						rs.getBoolean("status_gen"));
				
				lista.add(gen);
			}
			
			desconectar();
			
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Genero obterPorId(long id) {
		Genero gen = new Genero();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				gen = new Genero(rs.getLong("id_gen"), 
						rs.getString("nome_gen"), 
						rs.getBoolean("status_gen"));
			}
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return gen;
	}
	
	public List<Genero> obterPorNome(String nome) {
		List<Genero> lista = new ArrayList<Genero>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_NOME);
			
			ps.setString(1, '%'+nome+'%');
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Genero gen = new Genero(rs.getLong("id_gen"), 
						rs.getString("nome_gen"), 
						rs.getBoolean("status_gen"));
				
				lista.add(gen);
			}
			desconectar();
		
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void excluir(Genero gen) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setLong(1, gen.getId());
			
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
