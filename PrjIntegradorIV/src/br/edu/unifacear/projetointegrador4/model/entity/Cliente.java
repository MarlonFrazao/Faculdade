package br.edu.unifacear.projetointegrador4.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.edu.unifacear.projetointegrador4.model.dao.DAO;

@Entity
public class Cliente implements DAO{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String cpf;
	private String nome;
	private String endereco;
	private String email;
	@OneToMany
	private List<Telefone> telefone;
	@OneToOne
	private TipoCliente tipo;
	private Long senha;
	
	private Boolean status;
	
	
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", endereco=" + endereco + ", email=" + email
				+ ", tipo=" + tipo + ", senha=" + senha + ", status=" + status + "]";
	}



	public Cliente() {}
	
	
	
	public Cliente(Long id, String cpf, String nome, String endereco, String email, List<Telefone> telefone,
			TipoCliente tipo, Long senha, Boolean status) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.tipo = tipo;
		this.senha = senha;
		this.status = status;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}
	
	public Boolean status() {
		return status;
	}

	@Override
	public void setStatus(Boolean status) {
		this.status = status;
		
	}

	public Long getSenha() {
		return senha;
	}

	public void setSenha(Long senha) {
		this.senha = senha;
	}	
	
}
