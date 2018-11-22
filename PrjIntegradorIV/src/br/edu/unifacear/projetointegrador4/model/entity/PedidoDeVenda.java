package br.edu.unifacear.projetointegrador4.model.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.edu.unifacear.projetointegrador4.model.dao.DAO;



@Entity
public class PedidoDeVenda implements DAO{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	@ManyToOne
	private Cliente cliente;
	//@OneToMany
	//private List<Peca> peca;
	private Date data;
	@ManyToOne
	private StatusPV statusPV;
	private Boolean status;
	
	@OneToMany(mappedBy = "id_pdv", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
	private List<PecasDoPedido> pecaspdv;
	
	public PedidoDeVenda() {
		cliente = new Cliente();
		//peca = new ArrayList<Peca>();
		statusPV = new StatusPV();
		pecaspdv = new ArrayList<PecasDoPedido>();
		
		
		
	}

	
	public PedidoDeVenda(Long id, Cliente cliente, Date data, StatusPV statusPV, Boolean status,
			List<PecasDoPedido> pecaspdv) {
		super();
		this.id = id;
		this.cliente = cliente;
		//this.peca = peca;
		this.data = data;
		this.statusPV = statusPV;
		this.status = status;
		this.pecaspdv = pecaspdv;
	}




	@Override
	public String toString() {
		return "PedidoDeVenda [id=" + id + ", data=" + data + ", status=" + status + "]";
	}
	
	public void adicionarPecasDoPedido(Peca peca) {			
		PecasDoPedido pecasPdv = new PecasDoPedido();
		pecasPdv.setId_peca(peca);		
		this.pecaspdv.add(pecasPdv);
		System.out.println("adicionar pecas do pedido entity: "+pecasPdv.getId_peca().getDescricao());
	}
	public void removerPecasDoPedido(int index) {
		PecasDoPedido pecasPdv = this.pecaspdv.get(index);
		this.pecaspdv.remove(index);
	}
	public List<PecasDoPedido> getPecaspdv() {
		return pecaspdv;
	}
	public void setPecaspdv2(List<Peca> listaPeca) {
		for(int i =0; i<listaPeca.size();i++) {
			System.out.println("pecinhas boladas: "+listaPeca.get(i).getDescricao());
			
		}
		PecasDoPedido pecasPdv = new PecasDoPedido();
		for(int i=0; i< listaPeca.size();i++) {
			pecasPdv.setId_peca(listaPeca.get(i));
			System.out.println("set Prca 2: "+pecasPdv.getId_peca().getDescricao());
			this.pecaspdv.add(pecasPdv);
			System.out.println("lista de pecas que veio da bean: "+pecasPdv.getId_peca().getDescricao());
		}
		
		for(int i =0; i< pecaspdv.size();i++) {
			System.out.println("------------ "+pecaspdv.get(i).getId_peca().getDescricao()+" -----------");
		}
		
	}

	public void setPecaspdv(List<PecasDoPedido> pecasPdv2) {
		for(int i = 0; i<pecasPdv2.size();i++) {
			System.out.println("lista que vem da bean para entity: "+pecasPdv2.get(i).getId_peca().getDescricao());
		}
		this.pecaspdv = pecasPdv2;
	}


	@Override
	public Long getId() {
		return id;
	}

	public Boolean getStatus() {
		return status;
	}
	@Override
	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/*
	public List<Peca> getPeca() {
		return peca;
	}

	public void setPeca(List<Peca> peca) {
		this.peca = peca;
	}
*/
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public StatusPV getStatusPV() {
		return statusPV;
	}

	public void setStatusPV(StatusPV statusPV) {
		this.statusPV = statusPV;
	}


	
	
}
