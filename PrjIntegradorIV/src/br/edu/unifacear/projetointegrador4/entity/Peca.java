package br.edu.unifacear.projetointegrador4.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.unifacear.projetointegrador4.dao.DAO;


public class Peca implements DAO{
	
	

	private Long id;
	private String descricao;
	private List<Modelo> modelo;
	private Aplicacao aplicacao;
	private Long qtdeTotal;
	private String adicional;
	private Date dataCadastro;
	private Long totalAvaliacao;
	private Float mediaAvaliacao;
	private Long numVisualizacao;
	private String foto;
	private Boolean status;
	
	public Peca() {}

	public Peca(Long id, String descricao, List<Modelo> modelo, Aplicacao aplicacao, Long qtdeTotal, String adicional,
			Date dataCadastro, Long totalAvaliacao, Float mediaAvaliacao, Long numVisualizacao, String foto,
			Boolean status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.modelo = modelo;
		this.aplicacao = aplicacao;
		this.qtdeTotal = qtdeTotal;
		this.adicional = adicional;
		this.dataCadastro = dataCadastro;
		this.totalAvaliacao = totalAvaliacao;
		this.mediaAvaliacao = mediaAvaliacao;
		this.numVisualizacao = numVisualizacao;
		this.foto = foto;
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

	public List<Modelo> getModelo() {
		return modelo;
	}

	public void setModelo(List<Modelo> modelo) {
		this.modelo = modelo;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public Long getQtdeTotal() {
		return qtdeTotal;
	}

	public void setQtdeTotal(Long qtdeTotal) {
		this.qtdeTotal = qtdeTotal;
	}

	public String getAdicional() {
		return adicional;
	}

	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Long getTotalAvaliacao() {
		return totalAvaliacao;
	}

	public void setTotalAvaliacao(Long totalAvaliacao) {
		this.totalAvaliacao = totalAvaliacao;
	}

	public Float getMediaAvaliacao() {
		return mediaAvaliacao;
	}

	public void setMediaAvaliacao(Float mediaAvaliacao) {
		this.mediaAvaliacao = mediaAvaliacao;
	}

	public Long getNumVisualizacao() {
		return numVisualizacao;
	}

	public void setNumVisualizacao(Long numVisualizacao) {
		this.numVisualizacao = numVisualizacao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Boolean getStatus() {
		return status;
	}
	@Override
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
