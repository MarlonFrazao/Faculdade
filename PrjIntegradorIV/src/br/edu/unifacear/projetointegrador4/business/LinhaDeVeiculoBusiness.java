package br.edu.unifacear.projetointegrador4.business;

import java.util.List;

import br.edu.unifacear.projetointegrador4.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.entity.LinhaDeVeiculo;

public class LinhaDeVeiculoBusiness {
	
	public void inserir(LinhaDeVeiculo ldv) throws BusinessException{
		
		//busca as linhas cadastradas para verifica��o
		List<LinhaDeVeiculo> lista = FabricaDAO.criarLinhaDeVeiculoDAO().obter(ldv.getDescricao());
		
		//set o status ativo ao objeto a ser cadastrado
		ldv.setStatus(true);
		
		if(ldv.getDescricao() == null) {
			throw new BusinessException("Erro: Necess�rio informar descri��o");
		} else {
			//verifica se h� cadastro no banco de dados, se n�o h�, insere o objeto
			if(lista.size() < 1) {
				FabricaDAO.criarLinhaDeVeiculoDAO().inserir(ldv);
			} else {
				//verifica se j� existe objeto com a mesma descricao
				for(int i = 0; i < lista.size(); i++) {
					if(ldv.getDescricao().equals(lista.get(i).getDescricao())) {
						throw new BusinessException("Linha j� cadastrada!");
					} else {
						FabricaDAO.criarLinhaDeVeiculoDAO().inserir(ldv);
					}
				}
			}
		}
	}
}
