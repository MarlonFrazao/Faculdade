package br.edu.unifacear.projetointegrador4.model.facade;

import java.util.List;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.business.ClienteBusiness;
import br.edu.unifacear.projetointegrador4.model.entity.Cliente;

public class FacadeCliente {
	public void inserirCliente(Cliente c) throws BusinessException {
		new ClienteBusiness().inserir(c);
	}

	public void atualizarCliente(Cliente c) throws BusinessException {
		new ClienteBusiness().atualizar(c);
	}

	public List<Cliente> listarCliente() {
		return new ClienteBusiness().listar();
	}

	public Cliente obterCliente(Long id) throws BusinessException {
		return new ClienteBusiness().obter(id);
	}

	public List<Cliente> obterCliente(String nome) throws BusinessException {
		return new ClienteBusiness().obter(nome);
	}

	public void excluirCliente(Cliente c) throws BusinessException {
		new ClienteBusiness().excluir(c);
	}
}
