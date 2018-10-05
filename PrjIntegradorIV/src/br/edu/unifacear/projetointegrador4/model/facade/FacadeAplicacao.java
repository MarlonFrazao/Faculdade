package br.edu.unifacear.projetointegrador4.model.facade;

import java.util.List;

import br.edu.unifacear.projetointegrador4.model.business.AplicacaoBusiness;
import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.entity.Aplicacao;

public class FacadeAplicacao {
	
	public void inserir(Aplicacao a) throws BusinessException {
		try {
			new AplicacaoBusiness().inserir(a);	
			System.out.println("Alô Alô Graças a Deus");
		} catch (Exception e) {
		System.out.println("fdsfsdfsde"+e.getMessage());
		}
		
		System.out.println("---------OK4---------");
	}

	public void atualizar(Aplicacao a) throws BusinessException {
		new AplicacaoBusiness().atualizar(a);
	}

	public List<Aplicacao> listar() throws BusinessException {
		return new AplicacaoBusiness().listar();
	}
	
	public List<Aplicacao> listar(Boolean status) throws BusinessException {
		return new AplicacaoBusiness().listar(status);
	}

	public Aplicacao obter(Long id) throws BusinessException {
		return new AplicacaoBusiness().obter(id);
	}

	public List<Aplicacao> obter(String descricao) throws BusinessException {
		return new AplicacaoBusiness().obter(descricao);
	}
	
	public List<Aplicacao> obter(String descricao, Boolean status) throws BusinessException {
		return new AplicacaoBusiness().obter(descricao, status);
	}

	public void excluir(Aplicacao a) {
		new AplicacaoBusiness().excluir(a);
	}
	
	public void reativar(Aplicacao a) {
		new AplicacaoBusiness().reativar(a);
	}
}
