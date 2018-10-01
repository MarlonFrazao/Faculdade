package br.edu.unifacear.projetointegrador4.model.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.model.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.model.entity.Cliente;
import br.edu.unifacear.projetointegrador4.model.entity.PedidoDeVenda;

public class PedidoDeVendaBusiness {
	public void inserir(PedidoDeVenda pdv) throws BusinessException {

		// busca as aplicações cadastradas para verificação

		pdv.setStatus(true);
		FabricaDAO.criarPedidoDeVendaDAO().inserir(pdv);

	}

	public void atualizar(PedidoDeVenda pdv) {

		FabricaDAO.criarPedidoDeVendaDAO().atualizar(pdv);
	}

	public List<PedidoDeVenda> listar() {

		return FabricaDAO.criarPedidoDeVendaDAO().listar();
	}

	public PedidoDeVenda obter(Long id) throws BusinessException {
		PedidoDeVenda pdv = new PedidoDeVenda();

		if (id == null) {
			pdv = null;
			throw new BusinessException("Erro: Necessário informar código.");
		} else {
			pdv = FabricaDAO.criarPedidoDeVendaDAO().obter(PedidoDeVenda.class, id);
		}

		return pdv;
	}

	public List<PedidoDeVenda> obterCliente(Long id_cliente) throws BusinessException {

		List<PedidoDeVenda> lpdv = new ArrayList<PedidoDeVenda>();

		if (id_cliente == null) {
			lpdv = null;
			throw new BusinessException("Erro: Necessário informar código do cliente.");
		} else {
			lpdv = FabricaDAO.criarPedidoDeVendaDAO().obter(id_cliente);
		}

		return lpdv;
	}

	public void excluir(PedidoDeVenda pdv) {

		FabricaDAO.criarPedidoDeVendaDAO().excluir(pdv);
	}
}
