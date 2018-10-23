package br.edu.unifacear.projetointegrador4.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.PrimeFaces;

import br.edu.unifacear.projetointegrador4.model.entity.Cliente;
import br.edu.unifacear.projetointegrador4.model.entity.Telefone;
import br.edu.unifacear.projetointegrador4.model.facade.FacadeCliente;
import br.edu.unifacear.projetointegrador4.model.facade.FacadeTelefone;

@ManagedBean(name = "cadastroClienteBean")
@RequestScoped
public class CadastroClienteBean {

	private Cliente cliente = null;
	private List<Telefone> telefone = null;
	private Cliente login = null;
	private FacadeCliente facade = null;
	private Long confirmaSenha = null;
	private Telefone telefone2 = null;
	private FacadeTelefone facTel = null;

	public CadastroClienteBean() {
		System.out.println("Entrou no bean");
		cliente = new Cliente();
		facade = new FacadeCliente();
		facTel = new FacadeTelefone();
		confirmaSenha = null;
		telefone = new ArrayList<Telefone>();
		telefone2 = new Telefone();
		login = new Cliente();

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
		System.out.println("entrou set cli: " + cliente.getCpf());
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	public Cliente getLogin() {
		return login;
	}

	public void setLogin(Cliente login) {
		this.login = login;
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

			login();
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
			if (this.cliente.getSenha() == this.confirmaSenha) {
				return "ok";
			} else {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas N�o Conferem", null));
				return "cadastrarcliente";
			}
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return "cadastrarcliente";
		}
	}

	public void login() {

		System.out.println("valida senha login");
		FacesMessage message = null;
		boolean loggedIn = false;

		try {
			System.out.println("valida senha login try");
			this.login = facade.obterCliente(cliente.getCpf(), cliente.getSenha()).get(0);
			System.out.println("valida senha login obter nome: " + login.getNome() + " cpf " + login.getCpf());
			if (this.login.getNome() != null) {
				loggedIn = true;
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem Vindo ", login.getNome().toString());

				System.out.println("valida senha login retornou login");
				// return "login";
			} else {
				loggedIn = false;
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login inv�lido", "CPF ou Senha incorretos");

				System.out.println("valida senha login retornou falha");
				// return "falha";

			}
			FacesContext.getCurrentInstance().addMessage(null, message);
			PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		} catch (Exception e) {

			System.out.println("valida senha login exception");

			// return "falha";
		}

	}

}
