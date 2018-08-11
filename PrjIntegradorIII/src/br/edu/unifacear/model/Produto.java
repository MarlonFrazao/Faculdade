package br.edu.unifacear.model;

public class Produto {
	private long id;
	private String nome;
	private boolean status;
	private long qtde;
	private long qtdeEntrada;
	private long qtdeSaida;
	private Categoria categoria;
	private Cor cor;
	private Genero genero;
	private float volume;
	private float peso;
	private Unidade unidade;
	private Tamanho tamanho;
	private long numPontos;
	private long qtdeMin;
	private long qtdeMax;
	private Colecao colecao;
	private Situacao situacao;
	private float valorUnitario;
	private float valorEntrada;
	private float valorSaida;
	
	public Produto() {}
	public Produto(long id, String nome, boolean status, long qtde, Categoria categoria, Cor cor, Genero genero,
			float volume, float peso, Unidade unidade, Tamanho tamanho, long numPontos, long qtdeMin, long qtdeMax,
			Colecao colecao, Situacao situacao, float valorUnitario) {
		super();
		this.id = id;
		this.nome = nome;
		this.status = status;
		this.qtde = qtde;
		this.categoria = categoria;
		this.cor = cor;
		this.genero = genero;
		this.volume = volume;
		this.peso = peso;
		this.unidade = unidade;
		this.tamanho = tamanho;
		this.numPontos = numPontos;
		this.qtdeMin = qtdeMin;
		this.qtdeMax = qtdeMax;
		this.colecao = colecao;
		this.situacao = situacao;
		this.valorUnitario = valorUnitario;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public long getQtde() {
		return qtde;
	}
	public void setQtde(long qtde) {
		this.qtde = qtde;
	}
	public long getQtdeEntrada() {
		return qtdeEntrada;
	}
	public void setQtdeEntrada(long qtdeEntrada) {
		this.qtdeEntrada = qtdeEntrada;
	}
	public long getQtdeSaida() {
		return qtdeSaida;
	}
	public void setQtdeSaida(long qtdeSaida) {
		this.qtdeSaida = qtdeSaida;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Cor getCor() {
		return cor;
	}
	public void setCor(Cor cor) {
		this.cor = cor;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public float getVolume() {
		return volume;
	}
	public void setVolume(float volume) {
		this.volume = volume;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	public Tamanho getTamanho() {
		return tamanho;
	}
	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}
	public long getNumPontos() {
		return numPontos;
	}
	public void setNumPontos(long numPontos) {
		this.numPontos = numPontos;
	}
	public long getQtdeMin() {
		return qtdeMin;
	}
	public void setQtdeMin(long qtdeMin) {
		this.qtdeMin = qtdeMin;
	}
	public long getQtdeMax() {
		return qtdeMax;
	}
	public void setQtdeMax(long qtdeMax) {
		this.qtdeMax = qtdeMax;
	}
	public Colecao getColecao() {
		return colecao;
	}
	public void setColecao(Colecao colecao) {
		this.colecao = colecao;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public float getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public float getValorEntrada() {
		return valorEntrada;
	}
	public void setValorEntrada(float valorEntrada) {
		this.valorEntrada = valorEntrada;
	}
	public float getValorSaida() {
		return valorSaida;
	}
	public void setValorSaida(float valorSaisda) {
		this.valorSaida = valorSaisda;
	}
	
	
}
