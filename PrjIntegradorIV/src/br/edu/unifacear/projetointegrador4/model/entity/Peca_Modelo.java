package br.edu.unifacear.projetointegrador4.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.edu.unifacear.projetointegrador4.model.dao.DAO;

@Entity
public class Peca_Modelo implements DAO{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="peca_id", referencedColumnName = "id")
	private Peca id_peca;
	
	
	@ManyToOne
	@JoinColumn(name="modelo_id", referencedColumnName = "id")
	private Modelo id_modelo;
	public Peca_Modelo() {

	}
	
	

	@Override
	public String toString() {
		return "Peca_Modelo [id=" + id + ", id_peca=" + id_peca + ", id_modelo=" + id_modelo + "]";
	}



	public Peca_Modelo(Peca peca, Modelo modelo, Long id) {
		super();
		this.id_peca = peca;
		this.id_modelo = modelo;
		this.id = id;
	}

	public Peca getPeca() {
		return id_peca;
	}

	public void setPeca(Peca peca) {
		this.id_peca = peca;
	}

	public Modelo getModelo() {
		return id_modelo;
	}

	public void setModelo(Modelo modelo) {
		this.id_modelo = modelo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public void setStatus(Boolean status) {
		// TODO Auto-generated method stub
		
	}

}
