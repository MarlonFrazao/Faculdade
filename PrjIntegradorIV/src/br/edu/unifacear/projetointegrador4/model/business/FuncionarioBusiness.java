package br.edu.unifacear.projetointegrador4.model.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.model.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.model.entity.Aplicacao;
import br.edu.unifacear.projetointegrador4.model.entity.Funcionario;

public class FuncionarioBusiness {

public void inserir(Funcionario f) throws BusinessException {
		
		
		List<Funcionario> lf = FabricaDAO.criarFuncionarioDAO().listar();
		
		f.setStatus(true);
		
		if(f.getNome() == null) {
			throw new BusinessException("Erro: Necessário informar nome");
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
	
	public List<Funcionario> obter(String nome) throws BusinessException {
		
		List<Funcionario> lf = new ArrayList<Funcionario>();
		
		if (nome == null) {
			lf = null;
			throw new BusinessException("Erro: Necessário informar nome.");
		} else {
			lf = FabricaDAO.criarFuncionarioDAO().obter(nome);
		} 
		
		return lf;
	}
	
	public void excluir(Funcionario f) {
		
		FabricaDAO.criarFuncionarioDAO().excluir(f);
	}
}
