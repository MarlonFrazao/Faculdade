package br.edu.unifacear.projetointegrador4.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.unifacear.projetointegrador4.model.dao.DAO;

@Entity
public class LinhaDeVeiculo implements DAO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private Boolean status;
	
	public LinhaDeVeiculo() {}

	
	
	@Override
	public String toString() {
		return "LinhaDeVeiculo [id=" + id + ", descricao=" + descricao + ", status=" + status + "]";
	}



	public LinhaDeVeiculo(Long id, String descricao, Boolean status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.status = status;
	}
	@Override
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
	@Override
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
