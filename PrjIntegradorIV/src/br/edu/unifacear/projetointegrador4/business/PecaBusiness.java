package br.edu.unifacear.projetointegrador4.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.dao.ModeloDAO;
import br.edu.unifacear.projetointegrador4.entity.Modelo;
import br.edu.unifacear.projetointegrador4.entity.Peca;

public class PecaBusiness {
public void inserir(Peca p) throws BusinessException {
		
		//busca as aplicações cadastradas para verificação
		List<Peca> lp = FabricaDAO.criarPecaDAO().obter(p.getDescricao());
		
		p.setStatus(true);
		
		if(p.getDescricao() == null) {
			throw new BusinessException("Erro: Necessário informar descrição");
		} else {
			//verifica se há cadastro no banco de dados, se não há, insere o objeto
			if(lp.size() < 1) {
				FabricaDAO.criarPecaDAO().inserir(p);
			} else {
				//verifica se já existe objeto com a mesma descricao
				for(int i = 0; i < lp.size(); i++) {
					if(p.getDescricao().equals(lp.get(i).getDescricao())) {
						throw new BusinessException("Peça já cadastrada!");
						
					} else {
						FabricaDAO.criarPecaDAO().inserir(p);
					}
				}
			}
		}
	}
	
	public void atualizar(Peca p) {
		
		FabricaDAO.criarPecaDAO().atualizar(p);
	}
	
	public List<Peca> listar() {
		
		return FabricaDAO.criarPecaDAO().listar();
	}
	
	public Peca obter(Long id) throws BusinessException {
		Peca p = new Peca();
		
		if(id == null) {
			p = null;
			throw new BusinessException("Erro: Necessário informar código.");
		} else {
			p = FabricaDAO.criarPecaDAO().obter(Peca.class, id);
		}
		
		return p;
	}
	
	public List<Peca> obter(String descricao) throws BusinessException {
		
		List<Peca> lp = new ArrayList<Peca>();
		
		if (descricao == null) {
			lp = null;
			throw new BusinessException("Erro: Necessário informar descrição.");
		} else {
			lp = FabricaDAO.criarPecaDAO().obter(descricao);
		} 
		
		return lp;
	}
	
	public void excluir(Peca p) {
		
		FabricaDAO.criarPecaDAO().excluir(p);
	}

	public List<Peca> obterModelo(Long id_modelo) throws BusinessException{
		List<Peca> lp = new ArrayList<Peca>();
		Modelo mod = new Modelo();
		ModeloDAO modDAO = new ModeloDAO();
		mod = modDAO.obter(Modelo.class, id_modelo);
		if(id_modelo == null) {
			lp =null;
			throw new BusinessException("Erro: Necessário informar codigo do modelo.");
		}else {
			lp = FabricaDAO.criarPecaDAO().obter(mod);
		}
		return lp;
	}
}
