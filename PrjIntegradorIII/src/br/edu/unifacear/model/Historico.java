package br.edu.unifacear.model;

import java.sql.Date;

public class Historico {
	private long idEntrada;
	private Date data;
	private String descricao;
	
	public Historico() {}
	
	public Historico(long idEntrada, Date data, String descricao) {
		super();
		this.idEntrada = idEntrada;
		this.data = data;
		this.descricao = descricao;
	}

	public long getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(long idEntrada) {
		this.idEntrada = idEntrada;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
