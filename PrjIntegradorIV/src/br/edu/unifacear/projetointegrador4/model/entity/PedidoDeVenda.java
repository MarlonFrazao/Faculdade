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
	@OneToMany
	private List<Peca> peca;
	private Date data;
	@ManyToOne
	private StatusPV statusPV;
	private Boolean status;
	
	@OneToMany(mappedBy = "id_pdv", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
	private List<PecasDoPedido> pecaspdv;
	
	public PedidoDeVenda() {
		cliente = new Cliente();
		peca = new ArrayList<Peca>();
		statusPV = new StatusPV();
		
		
	}

	
	public PedidoDeVenda(Long id, Cliente cliente, List<Peca> peca, Date data, StatusPV statusPV, Boolean status,
			List<PecasDoPedido> pecaspdv) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.peca = peca;
		this.data = data;
		this.statusPV = statusPV;
		this.status = status;
		this.pecaspdv = pecaspdv;
	}




	@Override
	public String toString() {
		return "PedidoDeVenda [id=" + id + ", data=" + data + ", status=" + status + "]";
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
