package br.edu.unifacear.projetointegrador4.business;


import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.entity.Aplicacao;

public class AplicacaoBusiness {
	
	public void inserir(Aplicacao a) throws BusinessException {
		
		a.setStatus(true);
		if(a.getDescricao() == null) {
			throw new BusinessException("Erro: Necessário informar descrição");
		} else {
			FabricaDAO.criarAplicacaoDAO().inserir(a);
		}
	}
	
	public List<Aplicacao> obter(String descricao) throws BusinessException {
		
		List<Aplicacao> la = new ArrayList<Aplicacao>();
		if (descricao == null) {
			la = null;
			throw new BusinessException("Erro: Necessário informar descricao");
		} else {
			la = FabricaDAO.criarAplicacaoDAO().obter(descricao);
		}
		
		return la;
	}
}
