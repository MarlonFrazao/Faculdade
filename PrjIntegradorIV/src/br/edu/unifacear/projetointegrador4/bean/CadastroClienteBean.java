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

	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static Funcionario getLoginf() {
		return loginf;
	}

	public static void setLoginf(Funcionario loginf) {
		CadastroClienteBean.loginf = loginf;
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

	public static void setFun(Funcionario fun) {
		CadastroClienteBean.fun = fun;
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

	public String logout() {
		login = new Cliente();
		telefone2 = new Telefone();
		loginf = new Funcionario();
		new PedidoDeVendaBean().setListapdv(null);
		System.out.println("Entrou Logout --------------------");
		return "logout";

	}
	public void loginFun() {
		try {
			System.out.println("-----troca-----");
			this.loginf = facadeg.obterFuncionario(this.cpf, this.senha).get(0);
			System.out.println("-----troca-----"+loginf.getNome());
			
		} catch (BusinessException e) {
			System.out.println("caiu catch troca");
			
			e.printStackTrace();
		}finally {
			if(loginf.getNome()!=null) {
				nome = loginf.getNome();
			}
			}
		}	
	
	public void loginCli() {
		try {
			System.out.println("-----troca de Cliente-----");
			this.login = facade.obterCliente(this.cpf, this.senha).get(0);
			this.telefone = facTel.obterTelefoneCpf(login);
			nome = login.getNome();
			
		} catch (BusinessException e1) {
			e1.printStackTrace();
		}finally {
			if(loginf.getNome() == null ) {
				System.out.println("1");
				System.out.println("valida senha login obter nome: " + login.getNome() + " cpf " + login.getCpf());
				System.out.println("valida senha funcionario obter nome: " + loginf.getNome() + " cpf " + loginf.getCpf());
				loginf = new Funcionario();
			}
			if(login.getNome() == null) {
				System.out.println("2");
				System.out.println("valida senha login obter nome: " + login.getNome() + " cpf " + login.getCpf());
				System.out.println("valida senha funcionario obter nome: " + loginf.getNome() + " cpf " + loginf.getCpf());
				login = new Cliente();
			}
		}
	}

	public void login() {

		System.out.println("valida senha login");
		FacesMessage message = null;
		boolean loggedIn = false;

		//try {
			System.out.println("valida senha login try");
			try {
			loginFun();
			}catch(Exception e) {
				
			}
			try {
				loginCli();
			}catch(Exception e1) {
				
			}
			
			//System.out.println("telefone do cara: " + telefone2.getTelefone());
			System.out.println("valida senha login obter nome: " + login.getNome() + " cpf " + login.getCpf());
			System.out.println("valida senha funcionario obter nome: " + loginf.getNome() + " cpf " + loginf.getCpf());

			if (loginf.getNome() != null) {
				loggedIn = true;
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem Vindo ", loginf.getNome().toString());

				System.out.println("valida senha login retornou login");
				try {
					Faces.redirect("./cadastropecas.jsf");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				retornaLogin();
			} else {
				loggedIn = false;
				message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login inválido", "CPF ou Senha incorretos");

				System.out.println("valida senha login retornou falha");
				retornaFalha();
				// return "falha";
			}
				if (this.login.getNome() != null) {
			
				loggedIn = true;
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem Vindo ", login.getNome().toString());

				System.out.println("valida senha login retornou login");
				retornaLogin();
				new PedidoDeVendaBean().listarPedidos();

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
		/*} catch (Exception e) {

			System.out.println("valida senha login exception");

			// return "falha";
		}*/

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
			// telefone.add(telefone2);
			// cliente.setTelefone(telefone);

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
