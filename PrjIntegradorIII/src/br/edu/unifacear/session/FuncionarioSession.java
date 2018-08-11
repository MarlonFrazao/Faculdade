package br.edu.unifacear.session;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.dao.FuncionarioDAO;
import br.edu.unifacear.model.Cargo;
import br.edu.unifacear.model.Funcionario;

public class FuncionarioSession {
	private FuncionarioDAO dao;
	
	public FuncionarioSession() {
		dao = new FuncionarioDAO();
	}
	
	public void inserirFuncionario(Funcionario f) {
		dao.inserir(f);
	}
	
	
	public void atualizarFuncionario(Funcionario f) {
		dao.atualizar(f);
	}
	
	public List<Funcionario> listarTodos() {
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		lista = dao.listarTodos();
		
		return lista;
	}
	
	public List<Funcionario> listarTodos(boolean ativo) {
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		if(ativo == true) {
			for(int i = 0; i < dao.listarTodos().size(); i++) {
				if(dao.listarTodos().get(i).isStatus() == true) {
					Funcionario f = new Funcionario();
					
					f = dao.listarTodos().get(i);
					
					lista.add(f);
				}
			}
		} else {
			for(int i = 0; i < dao.listarTodos().size(); i++) {
				if(dao.listarTodos().get(i).isStatus() == false) {
					Funcionario f = new Funcionario();
					
					f = dao.listarTodos().get(i);
					
					lista.add(f);
				}
			}
		}
		
		
		return lista;
	}
	
	public void excluirFuncionario(Funcionario f) {
		dao.excluir(f);
	}
	
	public Funcionario obterPorMat(long mat) {
		Funcionario f = new Funcionario();
		
		f = dao.obterPorMat(mat);
		
		return f;
	}
	
	public Funcionario obterPorMat(long mat, boolean ativo) {
		Funcionario f = new Funcionario();
		f = dao.obterPorMat(mat);
		if (ativo == true) {
			if (f.isStatus() == true) {
				
			} else {
				f = null;
			}
		} else {
			if (f.isStatus() == false) {
				
			} else {
				f = null;
			}
		}
		return f;
	}
	
	public List<Funcionario> obterPorNome(String nome) {
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		lista = dao.obterPorNome(nome);
		
		return lista;
	}
	
	public List<Funcionario> obterPorNome(String nome, boolean ativo) {
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		if (ativo == true) {
			for(int i = 0; i < dao.obterPorNome(nome).size(); i++) {
				if(dao.obterPorNome(nome).get(i).isStatus() == true) {
					Funcionario f = new Funcionario();
					
					f = dao.obterPorNome(nome).get(i);
					
					lista.add(f);
				}
			}
		} else {
			for(int i = 0; i < dao.obterPorNome(nome).size(); i++) {
				if(dao.obterPorNome(nome).get(i).isStatus() == false) {
					Funcionario f = new Funcionario();
					
					f = dao.obterPorNome(nome).get(i);
					
					lista.add(f);
				}
			}
		}
		
		return lista;
	}
	
	public List<Funcionario> obterPorCargo(long idCargo) {
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		lista = dao.obterPorCargo(idCargo);
		
		return lista;
	}
	
	public List<Funcionario> obterPorCargo(long idCargo, boolean ativo) {
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		if(ativo == true) {
			for(int i = 0; i < dao.obterPorCargo(idCargo).size(); i++) {
				if(dao.obterPorCargo(idCargo).get(i).isStatus() == true) {
					Funcionario f = new Funcionario();
					
					f = dao.obterPorCargo(idCargo).get(i);
					
					lista.add(f);
				}
			}
		} else {
			for(int i = 0; i < dao.obterPorCargo(idCargo).size(); i++) {
				if(dao.obterPorCargo(idCargo).get(i).isStatus() == false) {
					Funcionario f = new Funcionario();
					
					f = dao.obterPorCargo(idCargo).get(i);
					
					lista.add(f);
				}
			}
		}
		
		return lista;
	}
	
	public List<Funcionario> obterPorCargo(String nomeCargo, boolean ativo) {
		List<Funcionario> listaf = new ArrayList<Funcionario>();
		
		Cargo c = new Cargo();
		CargoSession cs = new CargoSession();
		
		
		for(int i = 0; i < cs.obter(nomeCargo).size(); i++) {
			c = cs.obter(nomeCargo).get(i);
			for(int j = 0; j < dao.obterPorCargo(c.getId()).size(); j++) {
				Funcionario f = dao.obterPorCargo(c.getId()).get(j);
				listaf.add(f);
			}
		}
		
		return listaf;
	}
	
	public List<Funcionario> obterPorCargo(String nomeCargo) {
		List<Funcionario> listaf = new ArrayList<Funcionario>();
		
		Cargo c = new Cargo();
		CargoSession cs = new CargoSession();
		
		
		for(int i = 0; i < cs.obter(nomeCargo).size(); i++) {
			c = cs.obter(nomeCargo).get(i);
			for(int j = 0; j < dao.obterPorCargo(c.getId()).size(); j++) {
				Funcionario f = dao.obterPorCargo(c.getId()).get(j);
				listaf.add(f);
			}
		}
		
		return listaf;
	}
	
	public boolean Login(long mat, String senha) {
		boolean acesso = false;
		
		Funcionario f = new Funcionario();
		
		f = dao.obterPorMat(mat);
		try {
			if (f.getSenha().equals(senha)) {

				if (f.isStatus() == true) {

					acesso = true;
				}
			} else {
				acesso = false;
			}
		} catch (Exception e) {
			acesso = false;
		}
		
		return acesso;
		
		
	}
	
	public long proximaMat() {
		
		return dao.gerarMat();
		
	}

}
