package br.edu.unifacear.projetointegrador4.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.model.dao.PecasDoPedidoDAO;
import br.edu.unifacear.projetointegrador4.model.entity.Cliente;
import br.edu.unifacear.projetointegrador4.model.entity.Peca;
import br.edu.unifacear.projetointegrador4.model.entity.PecasDoPedido;
import br.edu.unifacear.projetointegrador4.model.entity.PedidoDeVenda;
import br.edu.unifacear.projetointegrador4.model.entity.StatusPV;

@ManagedBean(name = "pedidoVendaBean")
@RequestScoped
public class PedidoDeVendaBean {
	private static PedidoDeVenda pdv = new PedidoDeVenda();
	private static List<PedidoDeVenda> listapdv;
	private static List<Peca> listaPeca = new ArrayList<Peca>();
	private static Peca peca = new Peca();
	private FacadeBusiness facade;
	private Cliente cliente;
	private StatusPV stpv;
	private PecasDoPedido pecasPdv;
	private PecasDoPedidoDAO pdvDAO;
	private static Double total;
	private List<Peca> pedidoEspecifico;
	private List<PedidoDeVenda> listaPedidos;

	public PedidoDeVendaBean() {
		System.out.println("entrou PDV Bean");
		listapdv = new ArrayList<PedidoDeVenda>();
		facade = new FacadeBusiness();
		stpv = new StatusPV();
		pecasPdv = new PecasDoPedido();
		listaPedidos = new ArrayList<PedidoDeVenda>();
		// pdv= new PedidoDeVenda();
		pdvDAO = new PecasDoPedidoDAO();
		pedidoEspecifico = new ArrayList<Peca>();
		// listaPeca = new ArrayList<Peca>();
		// peca = new Peca();
		cliente = new Cliente();
		// listarPecas();
		// pBean = new PecaBean();
		// peca = pBean.getPeca();
		new CadastroClienteBean().getLogin();
		listarPedidos();
		listarTodosPedidos();

		System.out.println("Loucura Loucura Loucura: " + peca.getDescricao());
		System.out.println("Tamanho lista: " + listaPeca.size());
		for (int i = 0; i < listaPeca.size(); i++) {
			System.out.println("Lista de Pecas: " + listaPeca.get(i).getId());
		}

	}

	public PedidoDeVendaBean(FacadeBusiness facade, Cliente cliente, StatusPV stpv, PecasDoPedido pecasPdv,
			PecasDoPedidoDAO pdvDAO, List<Peca> pedidoEspecifico) {
		super();
		this.facade = facade;
		this.cliente = cliente;
		this.stpv = stpv;
		this.pecasPdv = pecasPdv;
		this.pdvDAO = pdvDAO;
		this.pedidoEspecifico = pedidoEspecifico;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public PecasDoPedido getPecasPdv() {
		return pecasPdv;
	}

	public void setPecasPdv(PecasDoPedido pecasPdv) {
		this.pecasPdv = pecasPdv;
	}

	public String tiraItem() {

		this.listaPeca.remove(peca);

		return "nada";
	}

	public String limparCarrinho() {
		this.listaPeca = new ArrayList<Peca>();
		return "limpou";
	}
	public void listarTodosPedidos() {
		try {
			listaPedidos = facade.listarPedidoDeVenda();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String atualizar() {
		try {
			setPdv(facade.obterPedidoDeVenda(getPdv().getId()));
			pdv.setStatusPV(facade.obterStatusPV((long) 2));
			System.out.println("Confirmou o pedido: "+pdv.getId());
			facade.atualizarPedidoDeVenda(pdv);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return"evioPedido";
	}
	public String adicionarCarrinho() {
		Long aux = new CadastroClienteBean().getLogin().getId();
		List<StatusPV> auxSPV = new ArrayList<StatusPV>();
		List<PecasDoPedido> pecasPedido = new ArrayList<PecasDoPedido>();
		try {
			setCliente(facade.obterCliente(aux));
			System.out.println("cliente addCarrinho: " + this.cliente.getNome());
			auxSPV = (facade.obterStatusPV("Pedido Realizado"));
			setStpv(auxSPV.get(0));
			System.out.println("Status do pedido: " + stpv.getDescricao());
			if ((listaPeca.size() != 0 || listaPeca != null) && (cliente.getId() != null)) {

				pdv.setStatusPV(stpv);
				pdv.setCliente(cliente);
				for (int i = 0; i < listaPeca.size(); i++) {
					pecasPdv.setId_pdv(pdv);
					pecasPdv.setId_peca(listaPeca.get(i));
					pecasPedido.add(i, pecasPdv);
					pecasPdv = new PecasDoPedido();
				}

				pdv.setTotalPedido(total);
				pdv.setPecaspdv(pecasPedido);

				facade.inserirPedidoDeVenda(pdv);

				return "sucesso";
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "falha";
		}
		return "pdv";
	}

	public String addPeca(Peca peca) {

		FacesContext context = FacesContext.getCurrentInstance();
		System.out.println("Entrou add Peca");
		Long aux = new CadastroClienteBean().getLogin().getId();
		if (aux != null) {
			this.peca = peca;
			System.out.println("entrou if add peca");
			listaPeca.add(peca);
			System.out.println("ADD peca: " + peca.getId());
			for (int i = 0; i < listaPeca.size(); i++) {
				System.out.println("iiiiiii---" + i);
				Double totalsoma;
				totalsoma = listaPeca.get(i).getQtdeTotal() * listaPeca.get(i).getValorPeca();
				if (i == 0) {
					total = totalsoma;
				} else {
					total = totalsoma + total;
				}
				System.out.println("Lista de Pecas em addPeca: " + listaPeca.get(i).getId());
				System.out.println("Total do pedido: " + total);
			}

		} else {
			System.out.println("entrou else add peca");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Necessário Realizar Login", null);
			pdv = new PedidoDeVenda();
		}
		return "addPeca";
	}

	public void listarPedidos() {
		Long aux = new CadastroClienteBean().getLogin().getId();

		try {
			if (aux != null) {
				System.out.println("Trouxe pedido de venda");
				listapdv = facade.obterPedidoDeCliente(aux);

				if (listapdv.size() != 0 || listapdv != null) {

					for (int i = 0; i < listapdv.size(); i++) {
						System.out.println("lisyou pedidos: " + listapdv.get(i).getId());
					}
				} else {
					System.out.println("lista pedido vazia");
					listapdv = new ArrayList<PedidoDeVenda>();

				}
			} else {
				//pdv = new PedidoDeVenda();

			}

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void listarPecas() {
		Long aux = new CadastroClienteBean().getLogin().getId();
		try {
			if (aux != null) {
				System.out.println("Trouxe pedido de venda------------");
				pdv = facade.obterPedidoDeVenda(aux);

				for (int i = 0; i < pedidoEspecifico.size(); i++) {
					System.out.println("lista pedidoEspecifico: " + pedidoEspecifico.get(i).getDescricao());
				}
			} else {
				System.out.println("Else de listar pecas ++++++++++++++");
				pdv = new PedidoDeVenda();
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listarPecasPedido(PedidoDeVenda pdv) {
		System.out.println("Entrou no dialog lista das peças");
		try {
			pedidoEspecifico = facade.obterListaPecaPedido(pdv);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void avaliar() {
		
		getPeca();
		System.out.println("Entrou avaliar: "+getPeca().getDescricao());
		
	}
	
	public List<PedidoDeVenda> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<PedidoDeVenda> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public List<Peca> getPedidoEspecifico() {
		return pedidoEspecifico;
	}

	public void setPedidoEspecifico(List<Peca> pedidoEspecifico) {
		this.pedidoEspecifico = pedidoEspecifico;
	}

	public StatusPV getStpv() {
		return stpv;
	}

	public void setStpv(StatusPV stpv) {
		this.stpv = stpv;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Peca getPeca() {
		System.out.println("Get peca: " + peca.getId());
		return peca;
	}

	public void setPeca(Peca peca) {
		System.out.println("Set peca: " + peca.getId());
		this.peca = peca;
	}

	public PedidoDeVenda getPdv() {
		System.out.println("Get PDV: " + pdv.getId());
		return pdv;
	}

	public void setPdv(PedidoDeVenda pdv) {
		System.out.println("PDV id: " + pdv.getId());
		if (pdv.getId() != null) {
			listarPecasPedido(pdv);
		}
		this.pdv = pdv;
	}

	public List<PedidoDeVenda> getListapdv() {
		return listapdv;
	}

	public void setListapdv(List<PedidoDeVenda> listapdv) {
		this.listapdv = listapdv;
	}

	public List<Peca> getListaPeca() {
		return listaPeca;
	}

	public void setListaPeca(List<Peca> listaPeca) {
		this.listaPeca = listaPeca;
	}

}
