package br.edu.unifacear.projetointegrador4.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.unifacear.projetointegrador4.model.dao.DAO;

@Entity
public class Telefone implements DAO{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private Long telefone;
	private String tipo;
	
	
	
	public Telefone() {}
	
	@Override
	public String toString() {
		return "Telefone [id=" + id + ", cpf=" + cpf + ", telefone=" + telefone + ", tipo=" + tipo + "]";
	}



	public Telefone(Long id, String cpf, Long telefone, String tipo) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.telefone = telefone;
		this.tipo = tipo;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public void setStatus(Boolean status) {
		// TODO Auto-generated method stub
		
	}
	
}
