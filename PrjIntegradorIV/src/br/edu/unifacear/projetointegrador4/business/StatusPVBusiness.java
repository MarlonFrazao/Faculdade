package br.edu.unifacear.projetointegrador4.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.entity.StatusPV;

public class StatusPVBusiness {
	
	public void inserir(StatusPV s) throws BusinessException {
		
		List<StatusPV> lista = FabricaDAO.criarStatusPVDAO().obter(s.getDescricao());
		
		s.setStatus(true);
		
		if(s.getDescricao() == null) {
			throw new BusinessException("Erro: Necessário informar descrição");
		} else {
			
			if(lista == null || lista.size() < 1) {
				FabricaDAO.criarStatusPVDAO().inserir(s);
			} else {
				
				for(int i = 0; i < lista.size(); i++) {
					if(s.getDescricao().equals(lista.get(i).getDescricao())) {
						throw new BusinessException("Status já cadastrada!");
						
					} else {
						FabricaDAO.criarStatusPVDAO().inserir(s);
					}
				}
			}
		}
	}
	
	public void atualizar(StatusPV s) {
		
		FabricaDAO.criarStatusPVDAO().atualizar(s);
	}
	
	public List<StatusPV> listar() {
		
		return FabricaDAO.criarStatusPVDAO().listar();
	}
	
	public StatusPV obter(Long id) throws BusinessException {
		StatusPV s = new StatusPV();
		
		if(id == null) {
			s = null;
			throw new BusinessException("Erro: Necessário informar código.");
		} else {
			s = FabricaDAO.criarStatusPVDAO().obter(StatusPV.class, id);
		}
		
		return s;
	}
	
	public List<StatusPV> obter(String descricao) throws BusinessException {
		
		List<StatusPV> lista = new ArrayList<StatusPV>();
		
		if (descricao == null) {
			lista = null;
			throw new BusinessException("Erro: Necessário informar descrição.");
		} else {
			lista = FabricaDAO.criarStatusPVDAO().obter(descricao);
		} 
		
		return lista;
	}
	
	public void excluir(StatusPV s) {
		
		FabricaDAO.criarStatusPVDAO().excluir(s);
	}
}
