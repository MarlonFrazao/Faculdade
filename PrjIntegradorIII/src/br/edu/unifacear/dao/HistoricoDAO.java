package br.edu.unifacear.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.model.Historico;

public class HistoricoDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO HISTORICO (id_entrada, data_historico, descricao_historico) values (?, ?, ?);";
	private String SQL_UPDATE = "UPDATE HISTORICO SET deacricao_historico where id_entrada = ? and data_historico = ?;";
	private String SQL_SELECT = "SELECT * FROM HISTORICO";
	private String SQL_OBTER_ID = "SELECT * FROM HISTORICO WHERE id_entrada = ?;";
	private String SQL_OBTER_DATA = "SELECT * FROM HISTORICO WHERE data_historico = ?;";
	private String SQL_OBTER_DESC = "SELECT * FROM HISTORICO WHERE descricao_historico like ?;";
	private String SQL_OBTER_ID_DATA = "SELECT * FROM HISTORICO WHERE id_entrada = ? and data_historico = ?;";
	private String SQL_DELETE = "DELETE FROM HISTORICO WHERE id_entrada = ? and data_historico = ?;";
	
	public void inserir(Historico h) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setLong(1, h.getIdEntrada());
			ps.setTimestamp(2, new Timestamp(h.getData().getTime()));
			ps.setString(3, h.getDescricao());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Historico h) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setString(1, h.getDescricao());
			ps.setLong(2, h.getIdEntrada());
			ps.setTimestamp(3, new Timestamp(h.getData().getTime()));
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Historico> listarTodos() {
		List<Historico> retorno = new ArrayList<Historico>();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Historico h = new Historico(rs.getLong("id_entrada"),
												new Date(rs.getTimestamp("data_historico").getTime()),
												rs.getString("descricao_historico"));
				retorno.add(h);
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public List<Historico> obterPorId(long id) {
		List<Historico> retorno = new ArrayList<Historico>();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID);
			
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Historico h = new Historico(rs.getLong("id_entrada"),
												new Date(rs.getTimestamp("data_historico").getTime()),
												rs.getString("descricao_historico"));
				retorno.add(h);
			}
			
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public List<Historico> obterPorData(Date data) {
		List<Historico> retorno = new ArrayList<Historico>();
		
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_DATA);
			
			ps.setDate(1, data);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Historico h = new Historico(rs.getLong("id_entrada"),
												rs.getDate("data_historico"),
												rs.getString("descricao_historico"));
				retorno.add(h);
			}
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public List<Historico> obterPorDesc(String desc) {
		List<Historico> retorno = new ArrayList<Historico>();
		
		try {
			
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_DESC);
			
			ps.setString(1, '%' + desc + '%');
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Historico h = new Historico(rs.getLong("id_entrada"),
												rs.getDate("data_historico"),
												rs.getString("descricao_historico"));
				retorno.add(h);
			}
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public Historico obterPorIdEData(Long id, Date data) {
		Historico h = new Historico();
		
		try {
			
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_ID_DATA);
			
			ps.setLong(1, id);
			ps.setDate(2, data);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				h = new Historico(rs.getLong("id_entrada"),
										rs.getDate("data_historico"),
										rs.getString("descricao_historico"));
			}
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return h;
	}
	
	public void excluir(Historico h) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setLong(1, h.getIdEntrada());
			
			ps.executeQuery();
			desconectar();
			
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
