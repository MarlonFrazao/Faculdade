package br.edu.unifacear.projetointegrador4.entity;

public class LinhaDeVeiculo {
	
	private Long id;
	private String descricao;
	private Boolean status;
	
	public LinhaDeVeiculo() {}

	public LinhaDeVeiculo(Long id, String descricao, Boolean status) {
		super();
		this.id = id;
		this.descricao = descricao;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
