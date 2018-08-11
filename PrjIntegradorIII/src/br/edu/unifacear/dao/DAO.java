package br.edu.unifacear.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.unifacear.db.ConnectDB;

public class DAO {
	protected ConnectDB db;
	protected Connection connection;
	
	public DAO () {
		db = new ConnectDB();
	}
	
	public void conectar() throws ClassNotFoundException, SQLException {
		if(connection == null) {
			connection = db.getConnection();
		}
		
	}
	
	public void desconectar() throws SQLException {
		if(connection != null) {
			connection.close();
		}
	}

}
