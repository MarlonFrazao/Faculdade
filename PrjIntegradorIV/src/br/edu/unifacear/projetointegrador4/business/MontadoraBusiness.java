package br.edu.unifacear.projetointegrador4.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.entity.Montadora;


public class MontadoraBusiness {
	
	public void inserir(Montadora m) throws BusinessException {
		
		List<Montadora> lista = FabricaDAO.criarMontadoraDAO().obter(m.getDescricao());
		
		m.setStatus(true);
		
		if(m.getDescricao() == null) {
			throw new BusinessException("Erro: Necessário informar descrição");
		} else {
			
			if(lista.size() < 1) {
				FabricaDAO.criarMontadoraDAO().inserir(m);
			} else {
				
				for(int i = 0; i < lista.size(); i++) {
					if(m.getDescricao().equals(lista.get(i).getDescricao())) {
						throw new BusinessException("Montadora já cadastrada!");
						
					} else {
						FabricaDAO.criarMontadoraDAO().inserir(m);
					}
				}
			}
		}
	}
	
	public void atualizar(Montadora m) {
		
		FabricaDAO.criarMontadoraDAO().atualizar(m);
	}
	
	public List<Montadora> listar() {
		
		return FabricaDAO.criarMontadoraDAO().listar();
	}
	
	public Montadora obter(Long id) throws BusinessException {
		Montadora m = new Montadora();
		
		if(id == null) {
			m = null;
			throw new BusinessException("Erro: Necessário informar código.");
		} else {
			m = FabricaDAO.criarMontadoraDAO().obter(Montadora.class, id);
		}
		
		return m;
	}
	
	public List<Montadora> obter(String descricao) throws BusinessException {
		
		List<Montadora> lista = new ArrayList<Montadora>();
		
		if (descricao == null) {
			lista = null;
			throw new BusinessException("Erro: Necessário informar descrição.");
		} else {
			lista = FabricaDAO.criarMontadoraDAO().obter(descricao);
		} 
		
		return lista;
	}
	
	public void excluir(Montadora m) {
		
		FabricaDAO.criarMontadoraDAO().excluir(m);
	}
}
