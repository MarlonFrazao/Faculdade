package br.edu.unifacear.projetointegrador4.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.unifacear.projetointegrador4.dao.DAO;



@Entity //Essa anota��o diz que a classe � uma tabela do BD
public class Montadora implements DAO {
	
	
	@Id //Essa anota��o diz que o id � a chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Essa anota��o diz que o id � auto increment e o strategy se refere ao BD do MySql
	private Long id;
	private String descricao;
	private Boolean status;
	
	public Montadora() {}
	
	public Montadora(Long id, String descricao, Boolean status) {
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
