package br.edu.unifacear.projetointegrador4.business;


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
}
