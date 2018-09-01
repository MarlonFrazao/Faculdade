package br.edu.unifacear.projetointegrador4.business;


import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.entity.Aplicacao;

public class AplicacaoBusiness {
	
	public void inserir(Aplicacao a) throws BusinessException {
		
		//busca as aplica��es cadastradas para verifica��o
		List<Aplicacao> la = FabricaDAO.criarAplicacaoDAO().obter(a.getDescricao());
		
		a.setStatus(true);
		
		if(a.getDescricao() == null) {
			throw new BusinessException("Erro: Necess�rio informar descri��o");
		} else {
			//verifica se h� cadastro no banco de dados, se n�o h�, insere o objeto
			if(la.size() < 1) {
				FabricaDAO.criarAplicacaoDAO().inserir(a);
			} else {
				//verifica se j� existe objeto com a mesma descricao
				for(int i = 0; i < la.size(); i++) {
					if(a.getDescricao().equals(la.get(i).getDescricao())) {
						throw new BusinessException("Aplicacao j� cadastrada!");
						
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
	
	public Aplicacao obter(Long id) throws BusinessException {
		Aplicacao a = new Aplicacao();
		
		if(id == null) {
			a = null;
			throw new BusinessException("Erro: Necess�rio informar c�digo.");
		} else {
			a = FabricaDAO.criarAplicacaoDAO().obter(Aplicacao.class, id);
		}
		
		return a;
	}
	
	public List<Aplicacao> obter(String descricao) throws BusinessException {
		
		List<Aplicacao> la = new ArrayList<Aplicacao>();
		
		if (descricao == null) {
			la = null;
			throw new BusinessException("Erro: Necess�rio informar descri��o.");
		} else {
			la = FabricaDAO.criarAplicacaoDAO().obter(descricao);
		} 
		
		return la;
	}
	
	public void excluir(Aplicacao a) {
		
		FabricaDAO.criarAplicacaoDAO().excluir(a);
	}
}
