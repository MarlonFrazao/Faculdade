package br.edu.unifacear.projetointegrador4.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.projetointegrador4.model.entity.Cliente;
import br.edu.unifacear.projetointegrador4.model.entity.Telefone;
import br.edu.unifacear.projetointegrador4.model.facade.FacadeCliente;
import br.edu.unifacear.projetointegrador4.model.facade.FacadeTelefone;

@ManagedBean(name = "cadastroClienteBean")
@RequestScoped
public class CadastroClienteBean {

	private Cliente cliente =null;
	private List<Telefone> telefone=null;
	private FacadeCliente facade = null;
	private Long confirmaSenha =null ;
	private Telefone telefone2=null;
	private FacadeTelefone facTel=null;

	public CadastroClienteBean() {
		System.out.println("Entrou no bean");
		cliente = new Cliente();
		facade = new FacadeCliente();
		facTel = new FacadeTelefone();
		confirmaSenha = null;
		telefone = new ArrayList<Telefone>();
		telefone2 = new Telefone();
		

	}
	
	
	
	public Telefone getTelefone2() {
		return telefone2;
	}



	public void setTelefone2(Telefone telefone2) {
		this.telefone2 = telefone2;
	}



	public Long getConfirmaSenha() {
		return confirmaSenha;
	}



	public void setConfirmaSenha(Long confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}



	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		System.out.println("entrou set cli: "+cliente.getCpf());
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	public String inserir() {
			System.out.println("entra 1");
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			System.out.println("entra 2");
				telefone2.setCpf(cliente.getCpf());
				facTel.inserirTelefone(telefone2);
				telefone.add(telefone2);
				cliente.setTelefone(telefone);
				
				
				facade.inserirCliente(cliente);
				
				
				return "sucesso";
			
				
		} catch (Exception e) {
			System.out.println("entra exception inserir ");
			System.out.println("-----" + e.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return "cadastrousuario";
		}
	}
	
	public String confirmaSenha() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if(this.cliente.getSenha() == this.confirmaSenha) {
				return "ok";
			}else {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas Não Conferem", null));
				return "cadastrarcliente";
			}
		}
			catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return "cadastrarcliente";
		}
	}

}
