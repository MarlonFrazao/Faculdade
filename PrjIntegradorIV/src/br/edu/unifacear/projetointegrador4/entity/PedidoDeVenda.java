package br.edu.unifacear.projetointegrador4.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;




public class PedidoDeVenda {
	
	
	private Long id;	

	private Cliente cliente;

	private List<Peca> peca;
	private Date data;

	private StatusPV statusPV;
	
	public PedidoDeVenda() {}

	public PedidoDeVenda(Long id, Cliente cliente, List<Peca> peca, Date data, StatusPV statusPV) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.peca = peca;
		this.data = data;
		this.statusPV = statusPV;
	}

	public Long getId() {
		return id;
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

	public List<Peca> getPeca() {
		return peca;
	}

	public void setPeca(List<Peca> peca) {
		this.peca = peca;
	}

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
