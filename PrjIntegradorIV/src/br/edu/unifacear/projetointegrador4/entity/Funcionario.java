package br.edu.unifacear.projetointegrador4.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Funcionario {
	

	private Long matricula;
	private String nome;
	private String cpf;
	private List<Telefone> telefone;
	private Cargo cargo;
	private Boolean status;
	
	public Funcionario() {}

	public Funcionario(Long matricula, String nome, String cpf, List<Telefone> telefone, 
			Cargo cargo, Boolean status) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.cargo = cargo;
		this.status = status;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
