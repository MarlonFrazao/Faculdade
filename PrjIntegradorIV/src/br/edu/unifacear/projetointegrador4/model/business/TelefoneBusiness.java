package br.edu.unifacear.projetointegrador4.model.business;

import java.util.List;

import br.edu.unifacear.projetointegrador4.model.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.model.entity.Aplicacao;
import br.edu.unifacear.projetointegrador4.model.entity.Telefone;

public class TelefoneBusiness {

public void inserir(Telefone t) throws BusinessException {
		
		//busca as aplica��es cadastradas para verifica��o
		List<Telefone> lt = FabricaDAO.criarTelefoneDAO().listar();
		
		//t.setStatus(true);
		
		if(t.getTelefone() == null) {
			System.out.println("telefone = null");
			throw new BusinessException("Erro: Necess�rio informar Telefone");
		} else {
			//verifica se h� cadastro no banco de dados, se n�o h�, insere o objeto
			if(lt.size() < 1) {
				System.out.println("lista < 1");
				FabricaDAO.criarTelefoneDAO().inserir(t);
			} else {
				//verifica se j� existe objeto com a mesma descricao
				for(int i = 0; i < lt.size(); i++) {
					if(t.getTelefone().equals(lt.get(i).getTelefone())) {
						System.out.println("if equals telefone get i");
						throw new BusinessException("Telefone j� cadastrada!");
						
					} else {
						System.out.println("inseriu telefone 2");
						FabricaDAO.criarTelefoneDAO().inserir(t);
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
