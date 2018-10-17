package br.edu.unifacear.projetointegrador4.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.unifacear.projetointegrador4.model.entity.Cliente;
import br.edu.unifacear.projetointegrador4.model.entity.Telefone;
import br.edu.unifacear.projetointegrador4.model.facade.FacadeCliente;

@ManagedBean(name="cadastroClienteBean")
@RequestScoped
public class CadastroClienteBean {
	
	private Cliente cliente;
	private List<Telefone> telefone = new ArrayList<Telefone>();
	private FacadeCliente facade;
	
	public void CadatroClienteBean() {
		cliente = new Cliente();
		facade = new FacadeCliente();
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}
	
	
	
	

}
