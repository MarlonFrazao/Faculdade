package br.edu.unifacear.projetointegrador4.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.dao.ModeloDAO;
import br.edu.unifacear.projetointegrador4.entity.Modelo;
import br.edu.unifacear.projetointegrador4.entity.Peca;

public class PecaBusiness {
	public void inserir(Peca p) throws BusinessException {
		
		List<Peca> lp = FabricaDAO.criarPecaDAO().obter(p.getDescricao());
		
		p.setStatus(true);
		
		if(p.getDescricao() == null) {
			throw new BusinessException("Erro: Necessário informar descrição");
		} else {
			
			if(lp.size() < 1) {
				FabricaDAO.criarPecaDAO().inserir(p);
			} else {
				
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
	
	public List<Peca> listar(Boolean status) {
		List<Peca> retorno = new ArrayList<Peca>();
		List<Peca> lista = FabricaDAO.criarPecaDAO().listar();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getStatus() == status) {
				retorno.add(lista.get(i));
			}
		}
		
		return retorno;
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
	
	public List<Peca> obter(String descricao, Boolean status) throws BusinessException {
		List<Peca> retorno = new ArrayList<Peca>();
		List<Peca> lista = FabricaDAO.criarPecaDAO().obter(descricao);
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getStatus() == status) {
				retorno.add(lista.get(i));
			}
		}
		
		return retorno;
	}
	
	public List<Peca> obter(Modelo m) throws BusinessException{
		List<Peca> lp = new ArrayList<Peca>();
		
		if(m == null) {
			lp =null;
			throw new BusinessException("Erro: Necessário informar o modelo.");
		}else {
			lp = FabricaDAO.criarPecaDAO().obter(m);
		}
		return lp;
	}
	
	public void excluir(Peca p) {
		
		FabricaDAO.criarPecaDAO().excluir(p);
	}

	
}
