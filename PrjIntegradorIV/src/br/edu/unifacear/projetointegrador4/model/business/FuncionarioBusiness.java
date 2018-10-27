package br.edu.unifacear.projetointegrador4.model.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.model.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.model.entity.Cargo;
import br.edu.unifacear.projetointegrador4.model.entity.Funcionario;

public class FuncionarioBusiness {

public void inserir(Funcionario f) throws BusinessException {
		
		
		List<Funcionario> lf = FabricaDAO.criarFuncionarioDAO().listar();
		
		f.setStatus(true);
		
		if(f.getNome() == null) {
			throw new BusinessException("Erro: Necessário informar nome.");
		} else if (f.getCpf() == null) {
			throw new BusinessException("Erro: Necessário informar CPF.");
		} else if(f.getTelefone().size() < 1) {
			throw new BusinessException("Erro: Necessário informar pelo menos um telefone.");
		} else if(f.getCargo() == null) {
			throw new BusinessException("Erro: Necessário informar um cargo.");
		} else if(f.getSenha() == null) {
			throw new BusinessException("Erro: Necessário informar uma senha.");
		} else {
			if(lf.size() < 1) {
				FabricaDAO.criarFuncionarioDAO().inserir(f);
			} else {
				
				for(int i = 0; i < lf.size(); i++) {
					if(f.getCpf().equals(lf.get(i).getCpf())) {
						throw new BusinessException("Funcionario(a) já cadastrado(a)!");
						
					} else {
						FabricaDAO.criarFuncionarioDAO().inserir(f);
					}
				}
			}
		}
	}
	
	public void atualizar(Funcionario f) {
		
		FabricaDAO.criarFuncionarioDAO().atualizar(f);
	}
	
	public List<Funcionario> listar() {
		
		return FabricaDAO.criarFuncionarioDAO().listar();
	}
	
	public List<Funcionario> listar(Boolean status) {
		
		List<Funcionario> lista = FabricaDAO.criarFuncionarioDAO().listar();
		List<Funcionario> retorno = new ArrayList<Funcionario>();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getStatus() == status) {
				retorno.add(lista.get(i));
			}
		}
		
		return retorno;
	}
	
	public Funcionario obter(Long id) throws BusinessException {
		Funcionario f = new Funcionario();
		
		if(id == null) {
			f = null;
			throw new BusinessException("Erro: Necessário informar código.");
		} else {
			f = FabricaDAO.criarFuncionarioDAO().obter(Funcionario.class, id);
		}
		
		return f;
	}
	
	public Funcionario obterPorCpf(String cpf) throws BusinessException {
		
		List<Funcionario> lista = FabricaDAO.criarFuncionarioDAO().listar();
		Funcionario f = new Funcionario();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCpf().equals(cpf)) {
				f = lista.get(i);
				break;
			}
		}
		
		if(f.getNome().equals(null)) {
			throw new BusinessException("Funcionário não encontrado.");
		}
		
		return f;
	}
	
	public List<Funcionario> obter(String nome) throws BusinessException {
		
		List<Funcionario> lf = new ArrayList<Funcionario>();
		
		if (nome == null) {
			lf = null;
			throw new BusinessException("Erro: Necessário informar nome.");
		} else {
			lf = FabricaDAO.criarFuncionarioDAO().obter(nome);
		} 
		
		if(lf.size() < 1) {
			throw new BusinessException("Funcionário não encontrado.");
		}
		
		return lf;
	}
	
	public List<Funcionario> obter(String nome, Boolean status) throws BusinessException {
		
		List<Funcionario> lf = new ArrayList<Funcionario>();
		List<Funcionario> retorno = new ArrayList<Funcionario>();
		if (nome == null) {
			lf = null;
			throw new BusinessException("Erro: Necessário informar nome.");
		} else {
			lf = FabricaDAO.criarFuncionarioDAO().obter(nome);
			
			for(int i = 0; i < lf.size(); i++) {
				if(lf.get(i).getStatus() == status) {
					retorno.add(lf.get(i));
				}
			}
		} 
		
		if(retorno.size() < 1) {
			throw new BusinessException("Funcionário não encontrado.");
		}
		
		return retorno;
		
	}
	
	public List<Funcionario> obter(Cargo c) throws BusinessException {
		
		List<Funcionario> lista = FabricaDAO.criarFuncionarioDAO().listar();
		List<Funcionario> retorno = new ArrayList<Funcionario>();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCargo().equals(c)) {
				retorno.add(lista.get(i));
			}
		}
		
		if(retorno.size() < 1) {
			throw new BusinessException("Não há funcionários no cargo:" + c.getDescricao());
		}
		
		return retorno;
	}
	
	public List<Funcionario> obter(Cargo c, Boolean status) throws BusinessException {
		
		List<Funcionario> lista = FabricaDAO.criarFuncionarioDAO().listar();
		List<Funcionario> retorno = new ArrayList<Funcionario>();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCargo().equals(c) && lista.get(i).getStatus() == status) {
				retorno.add(lista.get(i));
			}
		}
		
		if(retorno.size() < 1 && status == true) {
			throw new BusinessException("Não há funcionários ativos no cargo:" + c.getDescricao());
		} else if(retorno.size() < 1 && status == false) {
			throw new BusinessException("Não há funcionários inativos no cargo:" + c.getDescricao());
		}
		
		return retorno;
	}
	
	public void excluir(Funcionario f) {
		
		FabricaDAO.criarFuncionarioDAO().excluir(f);
	}
	
	public void reativar(Funcionario f) {
		f.setStatus(true);
		
		FabricaDAO.criarFuncionarioDAO().atualizar(f);
	}
}
