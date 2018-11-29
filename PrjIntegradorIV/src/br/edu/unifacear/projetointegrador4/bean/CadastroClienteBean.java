package br.edu.unifacear.projetointegrador4.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.primefaces.PrimeFaces;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.model.entity.Cliente;
import br.edu.unifacear.projetointegrador4.model.entity.Funcionario;
import br.edu.unifacear.projetointegrador4.model.entity.Telefone;
import br.edu.unifacear.projetointegrador4.model.facade.FacadeCliente;
import br.edu.unifacear.projetointegrador4.model.facade.FacadeTelefone;

@ManagedBean(name = "cadastroClienteBean")
@RequestScoped
public class CadastroClienteBean {

	private Cliente cliente = null;
	private List<Telefone> telefone = null;
	private static Cliente login = new Cliente();
	private static Funcionario loginf = new Funcionario();
	private FacadeCliente facade = null;
	private Long confirmaSenha = null;
	private static Telefone telefone2 = new Telefone();;
	private FacadeTelefone facTel = null;
	private static Funcionario fun = new Funcionario();
	private FacadeBusiness facadeg;
	private String cpf;
	private Long senha;
	private String nome;

	public CadastroClienteBean() {
		cliente = new Cliente();
		facade = new FacadeCliente();
		facTel = new FacadeTelefone();
		confirmaSenha = null;
		telefone = new ArrayList<Telefone>();
		fun = new Funcionario();
		facadeg = new FacadeBusiness();
		System.out.println("login estável de cliente: " + login.getNome());
		System.out.println("login estável de funcionario: " + loginf.getNome());

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Funcionario getLoginf() {
		return loginf;
	}

	public void setLoginf(Funcionario loginf) {
		this.loginf = loginf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getSenha() {
		return senha;
	}

	public void setSenha(Long senha) {
		this.senha = senha;
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

	public static Funcionario getFun() {
		return fun;
	}

	public void setFun(Funcionario fun) {
		this.fun = fun;
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

			//new LoginBean().setCliente(cliente);
			//new LoginBean().login();
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

	public String atualizar() {
		System.out.println("entra 1");
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			System.out.println("entra 2");
			cliente = login;
			telefone = facTel.obterTelefoneCpf(cliente);
			System.out.println("recebeu lista");
			for (int i = 0; i < telefone.size(); i++) {
				System.out.println("lista antes if -- CPF: " + telefone.get(i).getCpf() + " tel: "
						+ telefone.get(i).getTelefone());
				if (telefone2.getId() == (telefone.get(i).getId())
						&& telefone2.getTelefone() != telefone.get(i).getTelefone()) {
					System.out.println("antes de mudar -- CPF: " + telefone.get(i).getCpf() + " tel: "
							+ telefone.get(i).getTelefone());
					telefone.set(i, telefone2);
					System.out.println("iiiiiiiii: " + i);
					System.out.println("depois de mudar -- CPF: " + telefone.get(i).getCpf() + " tel: "
							+ telefone.get(i).getTelefone());
					facTel.atualizarTelefone(telefone2);
					System.out.println("telefones diferentes -- CPF: " + telefone.get(i).getCpf() + " tel: "
							+ telefone.get(i).getTelefone());
					System.out.println("entrou for telefone");

				} else {
					System.out.println("para telefones iguais -- CPF: " + telefone.get(i).getCpf() + " tel: "
							+ telefone.get(i).getTelefone());
				}
			}

			facade.atualizarCliente(cliente);

			//new LoginBean().setCliente(cliente);
			//new LoginBean().login();
			return "sucesso";

		} catch (Exception e) {
			System.out.println("entra exception alterar ");
			System.out.println("-----" + e.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return "perfil";
		}
	}

}
