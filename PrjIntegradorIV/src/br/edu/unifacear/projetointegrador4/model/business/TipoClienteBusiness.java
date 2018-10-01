package br.edu.unifacear.projetointegrador4.model.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.model.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.model.entity.TipoCliente;

public class TipoClienteBusiness {
	
public void inserir(TipoCliente tc) throws BusinessException {
		
		List<TipoCliente> lista = FabricaDAO.criarTipoClienteDAO().obter(tc.getDescricao());
		
		tc.setStatus(true);
		
		if(tc.getDescricao() == null) {
			throw new BusinessException("Erro: Necessário informar descrição");
		} else {
			
			if(lista == null || lista.size() < 1) {
				FabricaDAO.criarTipoClienteDAO().inserir(tc);
			} else {
				
				for(int i = 0; i < lista.size(); i++) {
					if(tc.getDescricao().equals(lista.get(i).getDescricao())) {
						throw new BusinessException("Status já cadastrada!");
						
					} else {
						FabricaDAO.criarTipoClienteDAO().inserir(tc);
					}
				}
			}
		}
	}
	
	public void atualizar(TipoCliente tc) {
		
		FabricaDAO.criarTipoClienteDAO().atualizar(tc);
	}
	
	public List<TipoCliente> listar() {
		
		return FabricaDAO.criarTipoClienteDAO().listar();
	}
	
	public TipoCliente obter(Long id) throws BusinessException {
		TipoCliente tc = new TipoCliente();
		
		if(id == null) {
			tc = null;
			throw new BusinessException("Erro: Necessário informar código.");
		} else {
			tc = FabricaDAO.criarTipoClienteDAO().obter(TipoCliente.class, id);
		}
		
		return tc;
	}
	
	public List<TipoCliente> obter(String descricao) throws BusinessException {
		
		List<TipoCliente> lista = new ArrayList<TipoCliente>();
		
		if (descricao == null) {
			lista = null;
			throw new BusinessException("Erro: Necessário informar descrição.");
		} else {
			lista = FabricaDAO.criarTipoClienteDAO().obter(descricao);
		} 
		
		return lista;
	}
	
	public void excluir(TipoCliente tc) {
		
		FabricaDAO.criarTipoClienteDAO().excluir(tc);
	}
}
