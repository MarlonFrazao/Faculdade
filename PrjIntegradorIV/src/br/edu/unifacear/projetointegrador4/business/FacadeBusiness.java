package br.edu.unifacear.projetointegrador4.business;

import br.edu.unifacear.projetointegrador4.entity.Aplicacao;

public class FacadeBusiness {
	
	public void inserirAplicacao(Aplicacao a) throws BusinessException {
		new AplicacaoBusiness().inserir(a);
	}
}
