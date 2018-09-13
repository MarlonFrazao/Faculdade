package br.edu.unifacear.projetointegrador4.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.dao.PecaDAO;
import br.edu.unifacear.projetointegrador4.entity.Modelo;
import br.edu.unifacear.projetointegrador4.entity.Peca;

public class ModeloBusiness {

public void inserir(Modelo m) throws BusinessException {
		
		//busca as aplica��es cadastradas para verifica��o
		List<Modelo> lm = FabricaDAO.criarModeloDAO().obter(m.getDescricao());
		
		m.setStatus(true);
		
		if(m.getDescricao() == null) {
			throw new BusinessException("Erro: Necess�rio informar descri��o");
		} else {
			//verifica se h� cadastro no banco de dados, se n�o h�, insere o objeto
			if(lm.size() < 1) {
				FabricaDAO.criarModeloDAO().inserir(m);
			} else {
				//verifica se j� existe objeto com a mesma descricao
				for(int i = 0; i < lm.size(); i++) {
					if(m.getDescricao().equals(lm.get(i).getDescricao())) {
						throw new BusinessException("Modelo j� cadastrada!");
						
					} else {
						FabricaDAO.criarModeloDAO().inserir(m);
					}
				}
			}
		}
	}
	
	public void atualizar(Modelo m) {
		
		FabricaDAO.criarModeloDAO().atualizar(m);
	}
	
	public List<Modelo> listar() {
		
		return FabricaDAO.criarModeloDAO().listar();
	}
	
	public Modelo obter(Long id) throws BusinessException {
		Modelo m = new Modelo();
		
		if(id == null) {
			m = null;
			throw new BusinessException("Erro: Necess�rio informar c�digo.");
		} else {
			m = FabricaDAO.criarModeloDAO().obter(Modelo.class, id);
		}
		
		return m;
	}
	
	public List<Modelo> obter(String descricao) throws BusinessException {
		
		List<Modelo> lm = new ArrayList<Modelo>();
		
		if (descricao == null) {
			lm = null;
			throw new BusinessException("Erro: Necess�rio informar descri��o.");
		} else {
			lm = FabricaDAO.criarModeloDAO().obter(descricao);
		} 
		
		return lm;
	}
	
	public void excluir(Modelo m) {
		
		FabricaDAO.criarModeloDAO().excluir(m);
	}

	public List<Modelo> obterPeca(Long id_peca) throws BusinessException {
		List<Modelo> lp = new ArrayList<Modelo>();
		Peca p = new Peca();
		PecaDAO pDAO = new PecaDAO();
		p = pDAO.obter(Peca.class, id_peca);
		if(id_peca == null) {
			lp =null;
			throw new BusinessException("Erro: Necess�rio informar codigo da peca.");
		}else {
			lp = FabricaDAO.criarPecaDAO().obter(p);
		}
		return lp;
	}
}
