package br.edu.unifacear.projetointegrador4.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//@Entity
public class Peca_Modelo {

	//@Id
	//@ManyToOne
	//@JoinTable(name = "peca", joinColumns = @JoinColumn(name = "peca_id"), inverseJoinColumns = @JoinColumn(name = "id"))
	private Peca peca_id;
	//@Id
	//@ManyToOne
	//@JoinTable(name = "modelo", joinColumns = @JoinColumn(name = "modelo_id"), inverseJoinColumns = @JoinColumn(name = "modelo_id"))
	private Modelo modelo_id;

	public Peca_Modelo() {

	}

	public Peca_Modelo(Peca peca, Modelo modelo) {
		super();
		this.peca_id = peca;
		this.modelo_id = modelo;
	}

	public Peca getPeca() {
		return peca_id;
	}

	public void setPeca(Peca peca) {
		this.peca_id = peca;
	}

	public Modelo getModelo() {
		return modelo_id;
	}

	public void setModelo(Modelo modelo) {
		this.modelo_id = modelo;
	}

}
