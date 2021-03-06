package br.edu.unifacear.projetointegrador4.model.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.edu.unifacear.projetointegrador4.model.dao.DAO;


@Entity
public class Peca implements DAO{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
	@OneToMany(mappedBy = "id_peca", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
	private List<PecasDoPedido> pecasPdv = new ArrayList<>();
	
	@OneToMany(mappedBy = "id_peca", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
	private List<Peca_Modelo> peca_modelo = new ArrayList<>();
	@ManyToOne
	private Aplicacao aplicacao;
	private Long qtdeTotal;
	private String adicional;
	private Date dataCadastro; 
	private Long totalAvaliacao;
	private Float mediaAvaliacao;
	private Long numVisualizacao;
	private String foto;
	private Boolean status;
	private Double valorPeca;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Peca [id=" + id + ", descricao=" + descricao + ", aplicacao=" + aplicacao + ", qtdeTotal=" + qtdeTotal
				+ ", adicional=" + adicional + ", dataCadastro=" + dataCadastro + ", totalAvaliacao=" + totalAvaliacao
				+ ", mediaAvaliacao=" + mediaAvaliacao + ", numVisualizacao=" + numVisualizacao + ", foto=" + foto
				+ ", status=" + status + ", valorPeca=" + valorPeca + "]";
	}
	public void adicionarPecasDoPedido(PecasDoPedido pecasPdv) {			
		pecasPdv.setId_peca(this);		
		this.pecasPdv.add(pecasPdv);
		System.out.println("this peca: "+this.getDescricao());
	}
	public void removerPecasDoPedido(int index) {
		PecasDoPedido pecasPdv = this.pecasPdv.get(index);
		this.pecasPdv.remove(index);
	}
	
	public void adicionarPeca_Modelo(Peca_Modelo peca_modelo) {			
		peca_modelo.setPeca(this);		
		this.peca_modelo.add(peca_modelo);		
	}
	
	public void removerPeca_Modelo(int index) {
		Peca_Modelo peca_modelo = this.peca_modelo.get(index);
		this.peca_modelo.remove(index);
	}
	
	
	public Peca() {
		aplicacao = new Aplicacao();
		pecasPdv = new ArrayList<PecasDoPedido>();
		
	}

	public Peca(Long id, String descricao, List<PecasDoPedido> pecasPdv, List<Peca_Modelo> peca_modelo,
			Aplicacao aplicacao, Long qtdeTotal, String adicional, Date dataCadastro, Long totalAvaliacao,
			Float mediaAvaliacao, Long numVisualizacao, String foto, Boolean status, Double valorPeca) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.pecasPdv = pecasPdv;
		this.peca_modelo = peca_modelo;
		this.aplicacao = aplicacao;
		this.qtdeTotal = qtdeTotal;
		this.adicional = adicional;
		this.dataCadastro = dataCadastro;
		this.totalAvaliacao = totalAvaliacao;
		this.mediaAvaliacao = mediaAvaliacao;
		this.numVisualizacao = numVisualizacao;
		this.foto = foto;
		this.status = status;
		this.valorPeca = valorPeca;
	}
	
	
	public Double getValorPeca() {
		return valorPeca;
	}
	public void setValorPeca(Double valorPeca) {
		this.valorPeca = valorPeca;
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

	public List<Peca_Modelo> getPeca_Modelo() {
		return peca_modelo;
	}

	public void setPeca_Modelo(List<Peca_Modelo> peca_modelo) {
		
		
		System.out.println("lista na classe peca =========  ");
		for(int i = 0; i< peca_modelo.size(); i++) {
			System.out.println("Modelo da lista: "+peca_modelo.get(i).getModelo().getDescricao());
			System.out.println("Peca da lista add: "+peca_modelo.get(i).getPeca().getDescricao());
		}
		
		this.peca_modelo = peca_modelo;
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

	public List<PecasDoPedido> getPecasPdv() {
		return pecasPdv;
	}

	public void setPecasPdv(List<PecasDoPedido> pecasPdv) {
		this.pecasPdv = pecasPdv;
	}
	
	
	
}
