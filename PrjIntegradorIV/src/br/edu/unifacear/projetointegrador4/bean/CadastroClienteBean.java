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
	private static Cliente login = new Cliente();
	private FacadeCliente facade = null;
	private Long confirmaSenha = null;
	private static Telefone telefone2 = new Telefone();;
	private FacadeTelefone facTel = null;
	

	public CadastroClienteBean() {
		cliente = new Cliente();
		facade = new FacadeCliente();
		facTel = new FacadeTelefone();
		confirmaSenha = null;
		telefone = new ArrayList<Telefone>();
		
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
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas Não Conferem", null));
				return "cadastrarcliente";
			}
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return "cadastrarcliente";
		}
	}
	public String retornaLogin() {
		return "sucesso";
	}
	public String retornaFalha() {
		return "falha";
	}
	public void login() {

		System.out.println("valida senha login");
		FacesMessage message = null;
		boolean loggedIn = false;

		try {
			System.out.println("valida senha login try");
			this.login = facade.obterCliente(cliente.getCpf(), cliente.getSenha()).get(0);
			this.telefone = facTel.obterTelefoneCpf(cliente);
			telefone2 = telefone.get(0);
			System.out.println("telefone do cara: "+telefone2.getTelefone());
			System.out.println("valida senha login obter nome: " + login.getNome() + " cpf " + login.getCpf());
			if (this.login.getNome() != null) {
				loggedIn = true;
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem Vindo ", login.getNome().toString());

				System.out.println("valida senha login retornou login");
				retornaLogin();
				// return "login";
			} else {
				loggedIn = false;
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login inválido", "CPF ou Senha incorretos");

				System.out.println("valida senha login retornou falha");
				retornaFalha();
				// return "falha";

			}
			FacesContext.getCurrentInstance().addMessage(null, message);
			PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
		} catch (Exception e) {

			System.out.println("valida senha login exception");

			// return "falha";
		}

	}
	
	public String atualizar() {
		System.out.println("entra 1");
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			System.out.println("entra 2");
			cliente = login;
			telefone = facTel.obterTelefoneCpf(cliente);
			System.out.println("recebeu lista");
			for(int i =0; i<telefone.size();i++) {
				System.out.println("lista antes if -- CPF: "+telefone.get(i).getCpf()+" tel: "+telefone.get(i).getTelefone());
				if(telefone2.getId() == (telefone.get(i).getId()) && telefone2.getTelefone() != telefone.get(i).getTelefone()) {
					System.out.println("antes de mudar -- CPF: "+telefone.get(i).getCpf()+" tel: "+telefone.get(i).getTelefone());
					telefone.set(i, telefone2);
					System.out.println("iiiiiiiii: "+i);
					System.out.println("depois de mudar -- CPF: "+telefone.get(i).getCpf()+" tel: "+telefone.get(i).getTelefone());
					facTel.atualizarTelefone(telefone2);	
					System.out.println("telefones diferentes -- CPF: "+telefone.get(i).getCpf()+" tel: "+telefone.get(i).getTelefone());
					System.out.println("entrou for telefone");
					
				}else {
					System.out.println("para telefones iguais -- CPF: "+telefone.get(i).getCpf()+" tel: "+telefone.get(i).getTelefone());
				}
			}
			//telefone.add(telefone2);
			//cliente.setTelefone(telefone);

			facade.atualizarCliente(cliente);

			login();
			return "sucesso";

		} catch (Exception e) {
			System.out.println("entra exception alterar ");
			System.out.println("-----" + e.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return "perfil";
		}
	}

}
