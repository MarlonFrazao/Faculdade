package br.edu.unifacear.projetointegrador4.model.facade;

import java.util.List;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.business.CargoBusiness;
import br.edu.unifacear.projetointegrador4.model.entity.Cargo;

public class FacadeCargo {
	
	public void inserirCargo(Cargo c) throws BusinessException {
		new CargoBusiness().inserir(c);
	}

	public void atualizarCargo(Cargo c) throws BusinessException {
		new CargoBusiness().atualizar(c);
	}

	public List<Cargo> listarCargo() {
		return new CargoBusiness().listar();
	}

	public Cargo obterCargo(Long id) throws BusinessException {
		return new CargoBusiness().obter(id);
	}

	public List<Cargo> obterCargo(String descricao) throws BusinessException {
		return new CargoBusiness().obter(descricao);
	}

	public void excluirCargo(Cargo c) throws BusinessException {
		new CargoBusiness().excluir(c);
	}
}
