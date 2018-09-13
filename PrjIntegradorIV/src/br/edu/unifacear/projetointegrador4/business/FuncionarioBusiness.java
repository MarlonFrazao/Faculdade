package br.edu.unifacear.projetointegrador4.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.entity.Aplicacao;
import br.edu.unifacear.projetointegrador4.entity.Funcionario;

public class FuncionarioBusiness {

public void inserir(Funcionario f) throws BusinessException {
		
		//busca as aplica��es cadastradas para verifica��o
		List<Funcionario> lf = FabricaDAO.criarFuncionarioDAO().obter(f.getNome());
		
		f.setStatus(true);
		
		if(f.getNome() == null) {
			throw new BusinessException("Erro: Necess�rio informar nome");
		} else {
			//verifica se h� cadastro no banco de dados, se n�o h�, insere o objeto
			if(lf.size() < 1) {
				FabricaDAO.criarFuncionarioDAO().inserir(f);
			} else {
				//verifica se j� existe objeto com a mesma descricao
				for(int i = 0; i < lf.size(); i++) {
					if(f.getNome().equals(lf.get(i).getNome())) {
						throw new BusinessException("Funcionario j� cadastrada!");
						
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
			throw new BusinessException("Erro: Necess�rio informar c�digo.");
		} else {
			f = FabricaDAO.criarFuncionarioDAO().obter(Funcionario.class, id);
		}
		
		return f;
	}
	
	public List<Funcionario> obter(String nome) throws BusinessException {
		
		List<Funcionario> lf = new ArrayList<Funcionario>();
		
		if (nome == null) {
			lf = null;
			throw new BusinessException("Erro: Necess�rio informar nome.");
		} else {
			lf = FabricaDAO.criarFuncionarioDAO().obter(nome);
		} 
		
		return lf;
	}
	
	public void excluir(Funcionario f) {
		
		FabricaDAO.criarFuncionarioDAO().excluir(f);
	}
}
