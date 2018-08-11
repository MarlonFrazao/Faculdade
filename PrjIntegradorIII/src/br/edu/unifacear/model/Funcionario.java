package br.edu.unifacear.model;

import java.sql.Date;

public class Funcionario {
	private long matricula;
	private String senha;
	private String nome;
	private Cargo cargo;
	private long cpf;
	private long ctps;
	private long pis;
	private Date dataNasc;
	private Date dataAdmissao;
	private String endereco;
	private boolean status;
	
	public Funcionario () {}
	public Funcionario(long matricula, String senha, String nome, Cargo cargo, long cpf, long ctps, long pis,
			Date dataNasc, Date dataAdmissao, String endereco, boolean status) {
		super();
		this.matricula = matricula;
		this.senha = senha;
		this.nome = nome;
		this.cargo = cargo;
		this.cpf = cpf;
		this.ctps = ctps;
		this.pis = pis;
		this.dataNasc = dataNasc;
		this.dataAdmissao = dataAdmissao;
		this.endereco = endereco;
		this.status = status;
	}
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public long getCtps() {
		return ctps;
	}
	public void setCtps(long ctps) {
		this.ctps = ctps;
	}
	public long getPis() {
		return pis;
	}
	public void setPis(long pis) {
		this.pis = pis;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
