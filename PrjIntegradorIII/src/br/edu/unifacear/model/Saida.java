package br.edu.unifacear.model;

import java.sql.Date;
import java.util.List;

public class Saida {
	private long id;
	private long pedidoVenda;
	private Date dataSaida;
	private Funcionario funcionario;
	private List<Produto> listaProdutos;
	private String motivo;
	
	public Saida() {}

	public Saida(long id, long pedidoVenda, Date dataSaida, Funcionario funcionario, List<Produto> listaProdutos,
			String motivo) {
		super();
		this.id = id;
		this.pedidoVenda = pedidoVenda;
		this.dataSaida = dataSaida;
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

	public long getPedidoVenda() {
		return pedidoVenda;
	}

	public void setPedidoVenda(long pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
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
