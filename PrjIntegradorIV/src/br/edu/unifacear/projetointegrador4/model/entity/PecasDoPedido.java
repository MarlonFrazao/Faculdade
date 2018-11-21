package br.edu.unifacear.projetointegrador4.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.unifacear.projetointegrador4.model.dao.DAO;

@Entity
public class PecasDoPedido implements DAO{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id",unique=true, nullable = false)
	private Long id;
	@ManyToOne
	@JoinColumn(name="peca_id", referencedColumnName = "id")
	private Peca id_peca;
	//@Id
	@ManyToOne
	@JoinColumn(name="pdv_id", referencedColumnName = "id")
	private PedidoDeVenda id_pdv;
	
	
	
	@Override
	public String toString() {
		return "PecasDoPedido [id=" + id + ", id_peca=" + id_peca + ", id_pdv=" + id_pdv + "]";
	}
	public PecasDoPedido() {
		super();
	}
	public PecasDoPedido(Long id, Peca id_peca, PedidoDeVenda id_pdv) {
		super();
		this.id = id;
		this.id_peca = id_peca;
		this.id_pdv = id_pdv;
	}
	public Peca getId_peca() {
		return id_peca;
	}
	public void setId_peca(Peca id_peca) {
		this.id_peca = id_peca;
	}
	public PedidoDeVenda getId_pdv() {
		return id_pdv;
	}
	public void setId_pdv(PedidoDeVenda id_pdv) {
		this.id_pdv = id_pdv;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setStatus(Boolean status) {
		// TODO Auto-generated method stub
		
	}
}
