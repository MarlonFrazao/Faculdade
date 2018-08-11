package br.edu.unifacear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.model.Cargo;
import br.edu.unifacear.model.Funcionario;

public class FuncionarioDAO extends DAO {
	private String SQL_INSERT = "INSERT INTO FUNCIONARIO (mat_fun, senha, nome_fun, id_cargo, cpf, ctps, pis, data_nasc, data_admissao, endereco, status_fun) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private String SQL_UPDATE = "UPDATE FUNCIONARIO SET senha = ?, nome_fun = ?, id_cargo = ?, cpf = ?, ctps = ?, pis = ?, data_nasc = ?, data_admissao = ?, endereco = ?, status_fun = ? where mat_fun = ?;";
	private String SQL_SELECT = "SELECT * FROM FUNCIONARIO;";
	private String SQL_DELETE = "UPDATE FUNCIONARIO SET status_fun = ? where mat_fun = ?;";
	private String SQL_OBTER_MAT = "SELECT * FROM FUNCIONARIO where mat_fun = ?;";
	private String SQL_OBTER_NOME = "SELECT * FROM FUNCIONARIO where nome_fun like ? order by 2;";
	private String SQL_OBTER_CARGO = "SELECT * FROM FUNCIONARIO INNER JOIN cargo ON cargo.id_cargo = funcionario.id_cargo where funcionario.id_cargo = ?;";
	private String SQL_GERAR_MAT = "select max(mat_fun) from funcionario;";
	
	public void inserir(Funcionario f) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_INSERT);
			
			ps.setLong(1, f.getMatricula());
			ps.setString(2, f.getSenha());
			ps.setString(3, f.getNome());
			ps.setLong(4,  f.getCargo().getId());
			ps.setLong(5,  f.getCpf());
			ps.setLong(6,  f.getCtps());
			ps.setLong(7, f.getPis());
			ps.setDate(8, f.getDataNasc());
			ps.setDate(9, f.getDataAdmissao());
			ps.setString(10, f.getEndereco());
			ps.setBoolean(11, f.isStatus());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void atualizar (Funcionario f) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_UPDATE);
			
			ps.setString(1, f.getSenha());
			ps.setString(2, f.getNome());
			ps.setLong(3,  f.getCargo().getId());
			ps.setLong(4,  f.getCpf());
			ps.setLong(5,  f.getCtps());
			ps.setLong(6, f.getPis());
			ps.setDate(7, f.getDataNasc());
			ps.setDate(8, f.getDataAdmissao());
			ps.setString(9, f.getEndereco());
			ps.setBoolean(10, f.isStatus());
			ps.setLong(11, f.getMatricula());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Funcionario> listarTodos() {
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		try {
			
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_SELECT);
			
			ResultSet rs = ps.executeQuery();
			Cargo c = new Cargo();
			CargoDAO cdao = new CargoDAO();
			while (rs.next()) {
				Funcionario f = new Funcionario(rs.getLong("mat_fun"),
						rs.getString("senha"),
						rs.getString("nome_fun"), 
						c = cdao.obter(rs.getInt("id_cargo")), 
						rs.getLong("cpf"), 
						rs.getLong("ctps"), 
						rs.getLong("pis"), 
						rs.getDate("data_nasc"), 
						rs.getDate("data_admissao"), 
						rs.getString("endereco"), 
						rs.getBoolean("status_fun"));
				
				lista.add(f);
				
			}
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void excluir(Funcionario f) {
		try {
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_DELETE);
			
			ps.setBoolean(1, false);
			ps.setLong(2,  f.getMatricula());
			
			ps.executeUpdate();
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Funcionario obterPorMat(Long mat) {
		Funcionario f = new Funcionario();
		
		try {
			
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_MAT);
			
			ps.setLong(1, mat);
			
			ResultSet rs = ps.executeQuery();
			Cargo c = new Cargo();
			CargoDAO cdao = new CargoDAO();
			while(rs.next()) {
				f = new Funcionario(rs.getLong("mat_fun"),
						rs.getString("senha"),
						rs.getString("nome_fun"), 
						c = cdao.obter(rs.getInt("id_cargo")), 
						rs.getLong("cpf"), 
						rs.getLong("ctps"), 
						rs.getLong("pis"), 
						rs.getDate("data_nasc"), 
						rs.getDate("data_admissao"), 
						rs.getString("endereco"), 
						rs.getBoolean("status_fun"));
				
			}
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Funcionario> obterPorNome(String nome) {
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		try {
			
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_NOME);
			
			ps.setString(1, '%'+nome+'%');
			
			ResultSet rs = ps.executeQuery();
			Cargo c = new Cargo();
			CargoDAO cdao = new CargoDAO();
			while(rs.next()) {
				Funcionario f = new Funcionario(rs.getLong("mat_fun"),
						rs.getString("senha"),
						rs.getString("nome_fun"), 
						c = cdao.obter(rs.getInt("id_cargo")), 
						rs.getLong("cpf"), 
						rs.getLong("ctps"), 
						rs.getLong("pis"), 
						rs.getDate("data_nasc"), 
						rs.getDate("data_admissao"), 
						rs.getString("endereco"), 
						rs.getBoolean("status_fun"));
				
				lista.add(f);
				
			}
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Funcionario> obterPorCargo(long idCargo) {
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		try {
			
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_OBTER_CARGO);
			
			ps.setLong(1, idCargo);
			
			ResultSet rs = ps.executeQuery();
			Cargo c = new Cargo();
			CargoDAO cdao = new CargoDAO();
			while(rs.next()) {
				Funcionario f = new Funcionario(rs.getLong("mat_fun"),
						rs.getString("senha"),
						rs.getString("nome_fun"), 
						c = cdao.obter(rs.getLong("id_cargo")), 
						rs.getLong("cpf"), 
						rs.getLong("ctps"), 
						rs.getLong("pis"), 
						rs.getDate("data_nasc"), 
						rs.getDate("data_admissao"), 
						rs.getString("endereco"), 
						rs.getBoolean("status_fun"));
				
				lista.add(f);
				
			}
			
			desconectar();
			
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public long gerarMat() {
		long mat = 0;
		
		try {
			
			conectar();
			
			PreparedStatement ps = db.getConnection().prepareStatement(SQL_GERAR_MAT);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				mat = rs.getLong(1) + 1;
			}
			
			desconectar();
			
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mat;
	}

}
