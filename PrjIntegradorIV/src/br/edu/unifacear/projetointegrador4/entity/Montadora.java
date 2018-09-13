package br.edu.unifacear.projetointegrador4.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.unifacear.projetointegrador4.dao.DAO;



@Entity //Essa anotação diz que a classe é uma tabela do BD
public class Montadora implements DAO {
	
	
	@Id //Essa anotação diz que o id é a chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Essa anotação diz que o id é auto increment e o strategy se refere ao BD do MySql
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
