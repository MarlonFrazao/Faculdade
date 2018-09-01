package br.edu.unifacear.projetointegrador4.business;

import java.util.List;

import br.edu.unifacear.projetointegrador4.entity.Aplicacao;

public class FacadeBusiness {
	
	public void inserirAplicacao(Aplicacao a) throws BusinessException {
		new AplicacaoBusiness().inserir(a);
	}
	
	public void atualizarAplicacao(Aplicacao a) throws BusinessException {
		new AplicacaoBusiness().atualizar(a);
	}
	
	public List<Aplicacao> listarAplicacao() throws BusinessException {
		return new AplicacaoBusiness().listar();
	}
	
	public Aplicacao obterAplicacao(Long id) throws BusinessException {
		return new AplicacaoBusiness().obter(id);
	}
	
	public List<Aplicacao> obterAplicacao(String descricao) throws BusinessException {
		return new AplicacaoBusiness().obter(descricao);
	}
	
	public void excluirAplicacao(Aplicacao a) {
		new AplicacaoBusiness().excluir(a);
	}
}
