package br.edu.unifacear.projetointegrador4.bean;

import java.util.ArrayList;
import java.util.List;

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
	private static PedidoDeVenda pdv;
	private List<PedidoDeVenda> listapdv;
	private static List<Peca> listaPeca = new ArrayList<Peca>();
	private static Peca peca = new Peca();
	private FacadeBusiness facade;
	private Cliente cliente;
	private StatusPV stpv;
	private PecasDoPedido pecasPdv;
	private PecasDoPedidoDAO pdvDAO;
	

	public PedidoDeVendaBean() {
		System.out.println("entrou PDV Bean");
		listapdv = new ArrayList<PedidoDeVenda>();
		facade = new FacadeBusiness();
		stpv = new StatusPV();
		pecasPdv = new PecasDoPedido();
		pdv= new PedidoDeVenda();
		pdvDAO = new PecasDoPedidoDAO();
		//listaPeca = new ArrayList<Peca>();
		//peca = new Peca();
		cliente = new Cliente();
		//listarPecas();
		//pBean = new PecaBean();
		//peca = pBean.getPeca();
		System.out.println("Loucura Loucura Loucura: "+peca.getDescricao()); 
		System.out.println("Tamanho lista: "+listaPeca.size());
		for(int i =0; i<listaPeca.size();i++) {
			System.out.println("Lista de Pecas: "+listaPeca.get(i).getId());
		}
		
	}

	public PedidoDeVendaBean(PedidoDeVenda pdv, List<PedidoDeVenda> listapdv, List<Peca> listaPeca, Peca peca) {
		super();
		this.pdv = pdv;
		this.listapdv = listapdv;
		this.listaPeca = listaPeca;
		this.peca = peca;
		
		
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
	public String adicionarCarrinho() {
		Long aux = new CadastroClienteBean().getLogin().getId();
		List<StatusPV> auxSPV = new ArrayList<StatusPV>();
		
		try {
			setCliente(facade.obterCliente(aux));
			System.out.println("cliente addCarrinho: "+this.cliente.getNome());
			auxSPV= (facade.obterStatusPV("Pedido Realizado"));			
			setStpv( auxSPV.get(0));
			System.out.println("Status do pedido: "+stpv.getDescricao());
			if ((listaPeca.size() != 0 || listaPeca != null)&&(cliente.getId()!=null)) {
			
				//pdv.setPecaspdv2(listaPeca);
				pdv.setStatusPV(stpv);
				pdv.setCliente(cliente);
				
				facade.inserirPedidoDeVenda(pdv);
				
				for(int i = 0; i< listaPeca.size();i++) {
				pecasPdv.setId_pdv(pdv);
				pecasPdv.setId_peca(listaPeca.get(i));
				pdvDAO.inserir(pecasPdv);
				} 
				
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
			System.out.println("ADD peca: "+peca.getId());
			for(int i =0; i<listaPeca.size();i++) {
				System.out.println("Lista de Pecas em addPeca: "+listaPeca.get(i).getId());
			}
		
		} else {
			System.out.println("entrou else add peca");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Necessário Realizar Login", null);
			pdv = new PedidoDeVenda();
		}
		return "addPeca";
	}

	public void listarPecas() {
		Long aux = new CadastroClienteBean().getLogin().getId();
		try {
			if (aux != null) {
				System.out.println("Trouxe pedido de venda");
				pdv = facade.obterPedidoDeVenda(aux);
			} else {
				pdv = new PedidoDeVenda();
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		System.out.println("Get peca: "+peca.getId());
		return peca;
	}

	public void setPeca(Peca peca) {
		System.out.println("Set peca: "+peca.getId());
		this.peca = peca;
	}

	public PedidoDeVenda getPdv() {
		return pdv;
	}

	public void setPdv(PedidoDeVenda pdv) {
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
