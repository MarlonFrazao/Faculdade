package br.edu.unifacear.projetointegrador4.business;

import java.util.List;

import br.edu.unifacear.projetointegrador4.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.entity.Aplicacao;

public class BusinessGenerico {
	
	
	public void inserir(Object obj, String descricao) {
		/*
		Object dao = new Object();
		
		if (obj instanceof Aplicacao) {
			dao = FabricaDAO.criarAplicacaoDAO();
		}
		// busca as linhas cadastradas para verifica��o
		try {
			List<Object> lista = dao.obter(descricao);
		}catch(Exception e) {
			
		}
		

		if (ldv.getDescricao() == null) {
			throw new BusinessException("Erro: Necess�rio informar descri��o");
		} else {
			// verifica se h� cadastro no banco de dados, se n�o h�, insere o objeto
			if (lista.size() < 1) {
				FabricaDAO.criarLinhaDeVeiculoDAO().inserir(ldv);
			} else {
				// verifica se j� existe objeto com a mesma descricao
				for (int i = 0; i < lista.size(); i++) {
					if (ldv.getDescricao().equals(lista.get(i).getDescricao())) {
						throw new BusinessException("Linha j� cadastrada!");
					} else {
						FabricaDAO.criarLinhaDeVeiculoDAO().inserir(ldv);
					}
				}
			}
		}
*/
	} 
}
