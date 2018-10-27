package br.edu.unifacear.projetointegrador4.model.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.model.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.model.entity.Cargo;

public class CargoBusiness {
	
	public void inserir(Cargo c) throws BusinessException {
		
		List<Cargo> lista = FabricaDAO.criarCargoDAO().obter(c.getDescricao());
		
		c.setStatus(true);
		
		if(c.getDescricao() == null) {
			throw new BusinessException("Erro: Necessário informar descrição");
		} else {
			
			if(lista.size() < 1) {
				FabricaDAO.criarCargoDAO().inserir(c);
			} else {
				
				for(int i = 0; i < lista.size(); i++) {
					if(c.getDescricao().equals(lista.get(i).getDescricao())) {
						throw new BusinessException("Cargo já cadastrado!");
						
					} else {
						FabricaDAO.criarCargoDAO().inserir(c);
					}
				}
			}
		}
	}
	
	public void atualizar(Cargo c) {
		
		FabricaDAO.criarCargoDAO().atualizar(c);
	}
	
	public List<Cargo> listar() {
		
		return FabricaDAO.criarCargoDAO().listar();
	}
	
	public List<Cargo> listar(Boolean status){
		List<Cargo> lista = FabricaDAO.criarCargoDAO().listar();
		List<Cargo> retorno = new ArrayList<Cargo>();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getStatus() == status) {
				retorno.add(lista.get(i));
			}
		}
		
		return retorno;
	}
	
	public Cargo obter(Long id) throws BusinessException {
		Cargo c = new Cargo();
		
		if(id == null) {
			c = null;
			throw new BusinessException("Erro: Necessário informar código.");
		} else {
			c = FabricaDAO.criarCargoDAO().obter(Cargo.class, id);
		}
		
		return c;
	}
	
	public List<Cargo> obter(String descricao) throws BusinessException {
		
		List<Cargo> lista = new ArrayList<Cargo>();
		
		if (descricao == null) {
			lista = null;
			throw new BusinessException("Erro: Necessário informar descrição.");
		} else {
			lista = FabricaDAO.criarCargoDAO().obter(descricao);
		} 
		
		return lista;
	}
	
	public List<Cargo> obter(String descricao, Boolean status) throws BusinessException{
		
		List<Cargo> retorno = new ArrayList<Cargo>();
		List<Cargo> lista = FabricaDAO.criarCargoDAO().obter(descricao);
		
		if (descricao == null) {
			lista = null;
			throw new BusinessException("Erro: Necessário informar descrição.");
		} else {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getStatus() == status) {
					retorno.add(lista.get(i));
				}
			}
		}
		
		return retorno;
	}
	
	public void excluir(Cargo c) {
		
		FabricaDAO.criarCargoDAO().excluir(c);
	}
	
	public void reativar(Cargo c) {
		
		c.setStatus(true);
		
		FabricaDAO.criarCargoDAO().atualizar(c);
	}
}
