package br.edu.unifacear.projetointegrador4.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Modelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	@ManyToOne
	private Montadora montadora;
	@ManyToOne
	private LinhaDeVeiculo linha;
	private Integer ano;
	private Boolean status;
	
	public Modelo() {}

	public Modelo(Long id, String descricao, Montadora montadora, LinhaDeVeiculo linha, Integer ano, Boolean status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.montadora = montadora;
		this.linha = linha;
		this.ano = ano;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Montadora getMontadora() {
		return montadora;
	}

	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}

	public LinhaDeVeiculo getLinha() {
		return linha;
	}

	public void setLinha(LinhaDeVeiculo linha) {
		this.linha = linha;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
