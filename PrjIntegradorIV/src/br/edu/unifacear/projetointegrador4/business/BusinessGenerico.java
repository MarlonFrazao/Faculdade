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
		// busca as linhas cadastradas para verificação
		try {
			List<Object> lista = dao.obter(descricao);
		}catch(Exception e) {
			
		}
		

		if (ldv.getDescricao() == null) {
			throw new BusinessException("Erro: Necessário informar descrição");
		} else {
			// verifica se há cadastro no banco de dados, se não há, insere o objeto
			if (lista.size() < 1) {
				FabricaDAO.criarLinhaDeVeiculoDAO().inserir(ldv);
			} else {
				// verifica se já existe objeto com a mesma descricao
				for (int i = 0; i < lista.size(); i++) {
					if (ldv.getDescricao().equals(lista.get(i).getDescricao())) {
						throw new BusinessException("Linha já cadastrada!");
					} else {
						FabricaDAO.criarLinhaDeVeiculoDAO().inserir(ldv);
					}
				}
			}
		}
*/
	} 
}
