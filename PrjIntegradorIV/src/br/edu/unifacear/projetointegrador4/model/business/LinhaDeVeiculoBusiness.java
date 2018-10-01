package br.edu.unifacear.projetointegrador4.model.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.model.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.model.entity.Aplicacao;
import br.edu.unifacear.projetointegrador4.model.entity.LinhaDeVeiculo;

public class LinhaDeVeiculoBusiness {
	
	public void inserir(LinhaDeVeiculo ldv) throws BusinessException{
		
		//busca as linhas cadastradas para verificação
		List<LinhaDeVeiculo> lista = FabricaDAO.criarLinhaDeVeiculoDAO().obter(ldv.getDescricao());
		
		//set o status ativo ao objeto a ser cadastrado
		ldv.setStatus(true);
		
		if(ldv.getDescricao() == null) {
			throw new BusinessException("Erro: Necessário informar descrição");
		} else {
			//verifica se há cadastro no banco de dados, se não há, insere o objeto
			if(lista.size() < 1) {
				FabricaDAO.criarLinhaDeVeiculoDAO().inserir(ldv);
			} else {
				//verifica se já existe objeto com a mesma descricao
				for(int i = 0; i < lista.size(); i++) {
					if(ldv.getDescricao().equals(lista.get(i).getDescricao())) {
						throw new BusinessException("Linha já cadastrada!");
					} else {
						FabricaDAO.criarLinhaDeVeiculoDAO().inserir(ldv);
					}
				}
			}
		}
	}
	
	public void atualizar(LinhaDeVeiculo ldv) {
		
		FabricaDAO.criarLinhaDeVeiculoDAO().atualizar(ldv);
	}
	
	public List<LinhaDeVeiculo> listar() {
		
		return FabricaDAO.criarLinhaDeVeiculoDAO().listar();
	}
	
	public LinhaDeVeiculo obter(Long id) throws BusinessException {
		LinhaDeVeiculo ldv = new LinhaDeVeiculo();
		
		if(id == null) {
			ldv = null;
			throw new BusinessException("Erro: Necessário informar código.");
		} else {
			ldv = FabricaDAO.criarLinhaDeVeiculoDAO().obter(LinhaDeVeiculo.class, id);
		}
		
		return ldv;
	}
	
	public List<LinhaDeVeiculo> obter(String descricao) throws BusinessException {
		
		List<LinhaDeVeiculo> lista = new ArrayList<LinhaDeVeiculo>();
		
		if (descricao == null) {
			lista = null;
			throw new BusinessException("Erro: Necessário informar descrição.");
		} else {
			lista = FabricaDAO.criarLinhaDeVeiculoDAO().obter(descricao);
		} 
		
		return lista;
	}
	
	public void excluir(LinhaDeVeiculo ldv) {
		
		FabricaDAO.criarLinhaDeVeiculoDAO().excluir(ldv);
	}
}
