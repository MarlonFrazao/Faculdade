package br.edu.unifacear.model;

public class Cargo {
	private long id;
	private String nome;
	private float salario;
	private boolean status;
	
	public Cargo() {}
	public Cargo(long id, String nome, float salario, boolean status) {
		super();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
		this.status = status;
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
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
