package br.edu.unifacear.model;

import java.sql.Date;
import java.util.List;

public class Entrada {
	private long id;
	private long pedidoCompra;
	private Date dataEntrada;
	private Funcionario funcionario;
	private List<Produto> listaProdutos;
	private String motivo;
	
	public Entrada() {}
	public Entrada(long id, long pedidoCompra, Date dataEntrada, Funcionario funcionario, 
			List<Produto> listaProdutos, String motivo) {
		super();
		this.id = id;
		this.pedidoCompra = pedidoCompra;
		this.dataEntrada = dataEntrada;
		this.funcionario = funcionario;
		this.listaProdutos = listaProdutos;
		this.motivo = motivo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPedidoCompra() {
		return pedidoCompra;
	}

	public void setPedidoCompra(long pedidoCompra) {
		this.pedidoCompra = pedidoCompra;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}
