package br.edu.unifacear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.model.Situacao;

public class SituacaoDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO SITUACAO (id_sit, descricao) values (?, ?);";
	private String SQL_UPDATE = "UPDATE SITUACAO SET descricao = ? where id_sit = ?;";
	private String SQL_SELECT = "SELECT * FROM SITUACAO;";
	private String SQL_OBTER_ID = "SELECT * FROM SITUACAO WHERE id_sit = ?;";
	private String SQL_OBTER_DESC = "SELECT * FROM SITUACAO WHERE  descricao like ? order by 2;";
	private String SQL_DELETE = "DELETE FROM SITUACAO WHERE id_sit = ?;";
	private String SQL_GERAR_ID = "SELECT MAX(id_sit) FROM SITUACAO;";
	
	public void inserir(Situacao s) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setLong(1, s.getId());
			ps.setString(2, s.getDescricao());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Situacao s) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setString(1, s.getDescricao());
			ps.setLong(2, s.getId());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Situacao> listarTodos() {
		List<Situacao> lista = new ArrayList<Situacao>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Situacao s = new Situacao(rs.getLong("id_sit"),
						rs.getString("descricao"));
				lista.add(s);
			}
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public Situacao obterPorId(long id) {
		Situacao s = new Situacao();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				s = new Situacao(rs.getLong("id_sit"),
						rs.getString("descricao"));
			}
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public List<Situacao> obterPorDesc(String desc) {
		List<Situacao> lista = new ArrayList<Situacao>();
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_DESC);
			
			ps.setString(1, '%'+desc+'%');
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Situacao s = new Situacao (rs.getLong("id_sit"),
						rs.getString("descricao"));
				lista.add(s);
			}
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void excluir(Situacao s) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setLong(1, s.getId());
			
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
			
			PreparedStatement ps =db.getConnection().prepareStatement(SQL_GERAR_ID);
			
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
