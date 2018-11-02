package br.edu.unifacear.projetointegrador4.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.edu.unifacear.projetointegrador4.model.dao.DAO;

@Entity
public class Modelo implements DAO {

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

	@OneToMany(mappedBy = "id_modelo", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
	private List<Peca_Modelo> peca_modelo = new ArrayList<Peca_Modelo>();

	public Modelo() {
		linha = new LinhaDeVeiculo();
		montadora = new Montadora();
	}

	@Override
	public String toString() {
		return "Modelo [id=" + id + ", descricao=" + descricao + ", ano=" + ano + ", status=" + status + "]";
	}

	public void adicionarPeca_Modelo(Peca_Modelo peca_modelo) {
		peca_modelo.setModelo(this);
		this.peca_modelo.add(peca_modelo);
	}

	public void removerPeca_Modelo(int index) {
		Peca_Modelo peca_modelo = this.peca_modelo.get(index);
		this.peca_modelo.remove(index);
	}

	public Modelo(Long id, String descricao, Montadora montadora, LinhaDeVeiculo linha, Integer ano, Boolean status,
			List<Peca_Modelo> peca_modelo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.montadora = montadora;
		this.linha = linha;
		this.ano = ano;
		this.status = status;
		this.peca_modelo = peca_modelo;
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

	@Override
	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<Peca_Modelo> getPecas() {
		return peca_modelo;
	}

	public void setPecas(List<Peca_Modelo> pecas) {
		this.peca_modelo = pecas;
	}

}
