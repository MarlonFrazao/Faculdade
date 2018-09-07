package br.edu.unifacear.projetointegrador4.business;

import java.util.List;

import br.edu.unifacear.projetointegrador4.entity.Aplicacao;
import br.edu.unifacear.projetointegrador4.entity.LinhaDeVeiculo;

public class FacadeBusiness {
	
	//Aplicação
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
	
	//Linha de Veículo
	public void inserirLinhaDeVeiculo(LinhaDeVeiculo ldv) throws BusinessException {
		new LinhaDeVeiculoBusiness().inserir(ldv);
	}
	
	public void atualizarLinhaDeVeiculo(LinhaDeVeiculo ldv) throws BusinessException {
		new LinhaDeVeiculoBusiness().atualizar(ldv);
	}
	
	public List<LinhaDeVeiculo> listarLinhaDeVeiculo() {
		return new LinhaDeVeiculoBusiness().listar();
	}
	
	public LinhaDeVeiculo obterLinhaDeVeiculo(Long id) throws BusinessException {
		return new LinhaDeVeiculoBusiness().obter(id);
	}
	
	public List<LinhaDeVeiculo> obterLinhaDeVeiculo(String descricao) throws BusinessException {
		return new LinhaDeVeiculoBusiness().obter(descricao);
	}
	
	public void excluirLinhaDeVeiculo(LinhaDeVeiculo ldv) throws BusinessException {
		new LinhaDeVeiculoBusiness().excluir(ldv);
	}
}
