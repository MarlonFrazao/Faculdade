package br.edu.unifacear.projetointegrador4.business;

import java.util.List;

import br.edu.unifacear.projetointegrador4.entity.Aplicacao;

public class FacadeBusiness {
	
	public void inserirAplicacao(Aplicacao a) throws BusinessException {
		new AplicacaoBusiness().inserir(a);
	}
	
	public List<Aplicacao> obterAplicacao(String descricao) throws BusinessException {
		return new AplicacaoBusiness().obter(descricao);
	}
}
