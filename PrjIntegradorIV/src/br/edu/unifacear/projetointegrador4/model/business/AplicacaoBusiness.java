package br.edu.unifacear.projetointegrador4.model.business;


import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.model.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.model.entity.Aplicacao;

public class AplicacaoBusiness {
	
	public void inserir(Aplicacao a) throws BusinessException {
		
		//busca as aplicações cadastradas para verificação
		List<Aplicacao> la = FabricaDAO.criarAplicacaoDAO().obter(a.getDescricao());
		
		a.setStatus(true);
		
		if(a.getDescricao() == null) {
			throw new BusinessException("Erro: Necessário informar descrição");
		} else {
			//verifica se há cadastro no banco de dados, se não há, insere o objeto
			if(la.size() < 1) {
				FabricaDAO.criarAplicacaoDAO().inserir(a);
			} else {
				//verifica se já existe objeto com a mesma descricao
				for(int i = 0; i < la.size(); i++) {
					if(a.getDescricao().equals(la.get(i).getDescricao())) {
						throw new BusinessException("Aplicacao já cadastrada!");
						
					} else {
						FabricaDAO.criarAplicacaoDAO().inserir(a);
					}
				}
			}
		}
	}
	
	public void atualizar(Aplicacao a) {
		
		FabricaDAO.criarAplicacaoDAO().atualizar(a);
	}
	
	public List<Aplicacao> listar() {
		
		return FabricaDAO.criarAplicacaoDAO().listar();
	}
	
	public List<Aplicacao> listar(Boolean status) {
		List<Aplicacao> retorno = new ArrayList<Aplicacao>();
		List<Aplicacao> lista = FabricaDAO.criarAplicacaoDAO().listar();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getStatus() == status) {
				
				retorno.add(lista.get(i));
				
			}
		}
		
		return retorno;
	}
	
	public Aplicacao obter(Long id) throws BusinessException {
		Aplicacao a = new Aplicacao();
		
		if(id == null) {
			a = null;
			throw new BusinessException("Erro: Necessário informar código.");
		} else {
			a = FabricaDAO.criarAplicacaoDAO().obter(Aplicacao.class, id);
		}
		
		return a;
	}
	
	public List<Aplicacao> obter(String descricao) throws BusinessException {
		
		List<Aplicacao> la = new ArrayList<Aplicacao>();
		
		if (descricao == null) {
			la = null;
			throw new BusinessException("Erro: Necessário informar descrição.");
		} else {
			la = FabricaDAO.criarAplicacaoDAO().obter(descricao);
		} 
		
		return la;
	}
	
	public List<Aplicacao> obter(String descricao, Boolean status) throws BusinessException {
		List<Aplicacao> retorno = new ArrayList<Aplicacao>();
		List<Aplicacao> lista = new ArrayList<Aplicacao>();
		
		if(descricao != null) {
			lista = FabricaDAO.criarAplicacaoDAO().obter(descricao);
		} else {
			lista = null;
			throw new BusinessException("Erro: Necessário informar descrição.");
		}
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getStatus() == status) {
				retorno.add(lista.get(i));
			}
		}
		
		return retorno;
	}
	
	public void excluir(Aplicacao a) {
		
		FabricaDAO.criarAplicacaoDAO().excluir(a);
	}
	
	public void reativar(Aplicacao a) {
		a.setStatus(true);
		
		FabricaDAO.criarAplicacaoDAO().atualizar(a);
	}
}
