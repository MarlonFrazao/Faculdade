package br.edu.unifacear.session;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.dao.*;
import br.edu.unifacear.model.Cargo;

public class CargoSession {
	private CargoDAO dao;
	
	public CargoSession() {
		dao = new CargoDAO();
	}
	
	public void inserirCargo(Cargo c) {
		dao.inserir(c);
	}
	
	public void atualizarCargo(Cargo c) {
		dao.atualizar(c);
	}
	
	public List<Cargo> listarTodos() {
		List<Cargo> lista = new ArrayList<Cargo>();
		
		lista = dao.obter();
		
		return lista;
	}
	
	public Cargo obterNome (String nome) {
		Cargo c = new Cargo();
		
		List<Cargo> lista = dao.obter(nome);
		
		c = lista.get(0);
		
		return c;
	} 
	
	public Cargo obter(long id) {
		return dao.obter(id);
	}
	
	public List<Cargo> obter(String nome) {
		return dao.obter(nome);
	}
	public long proximoId() {
		
		return dao.gerarId();
		
	}

}
