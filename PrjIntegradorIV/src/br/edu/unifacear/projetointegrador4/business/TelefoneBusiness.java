package br.edu.unifacear.projetointegrador4.business;

import java.util.List;

import br.edu.unifacear.projetointegrador4.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.entity.Aplicacao;
import br.edu.unifacear.projetointegrador4.entity.Telefone;

public class TelefoneBusiness {

public void inserir(Telefone t) throws BusinessException {
		
		//busca as aplicações cadastradas para verificação
		List<Telefone> lt = FabricaDAO.criarTelefoneDAO().listar();
		
		//t.setStatus(true);
		
		if(t.getTelefone() == null) {
			throw new BusinessException("Erro: Necessário informar Telefone");
		} else {
			//verifica se há cadastro no banco de dados, se não há, insere o objeto
			if(lt.size() < 1) {
				FabricaDAO.criarTelefoneDAO().inserir(t);
			} else {
				//verifica se já existe objeto com a mesma descricao
				for(int i = 0; i < lt.size(); i++) {
					if(t.getTelefone().equals(lt.get(i).getTelefone())) {
						throw new BusinessException("Telefone já cadastrada!");
						
					} else {
						//FabricaDAO.criarAplicacaoDAO().inserir(t);
					}
				}
			}
		}
	}
	
	public void atualizar(Telefone t) {
		
		FabricaDAO.criarTelefoneDAO().atualizar(t);
	}

	public List<Telefone> listar() {
		
		return FabricaDAO.criarTelefoneDAO().listar();
	}

	public void excluir(Telefone t) {
		
		FabricaDAO.criarTelefoneDAO().excluir(t);
	}
}
