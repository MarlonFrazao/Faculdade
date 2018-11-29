package br.edu.unifacear.projetointegrador4.bean;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Faces;
import org.primefaces.PrimeFaces;

import com.sun.jersey.spi.resource.PerRequest;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.model.entity.Cliente;
import br.edu.unifacear.projetointegrador4.model.entity.Funcionario;
import br.edu.unifacear.projetointegrador4.model.entity.Telefone;
import br.edu.unifacear.projetointegrador4.model.facade.FacadeCliente;
import br.edu.unifacear.projetointegrador4.model.facade.FacadeTelefone;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {
	
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
	private static String nome;
	
	
	
	
	public LoginBean() {
		this.cliente = new Cliente();
		this.telefone = new ArrayList<Telefone>();
		this.facade = new FacadeCliente();
		this.facTel = new FacadeTelefone();
		this.facadeg = new FacadeBusiness();
		login = new Cliente();
		loginf = new Funcionario();
		telefone2 = new Telefone();
		fun = new Funcionario();
		
		
	}
	public LoginBean(Cliente cliente, List<Telefone> telefone, FacadeCliente facade, Long confirmaSenha,
			FacadeTelefone facTel, FacadeBusiness facadeg, String cpf, Long senha, String nome) {
		super();
		this.cliente = cliente;
		this.telefone = telefone;
		this.facade = facade;
		this.confirmaSenha = confirmaSenha;
		this.facTel = facTel;
		this.facadeg = facadeg;
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
	}
	
	
	public void logout() {
		login = new Cliente();
		nome="";
		telefone2 = new Telefone();
		loginf = new Funcionario();
		new PedidoDeVendaBean().setListapdv(null);
		new CadastroClienteBean().setLoginf(loginf);
		new CadastroClienteBean().setLogin(login);
		new CadastroClienteBean().setCliente(login);
		System.out.println("Entrou Logout --------------------");
		

	}
	public void loginFun() {
		//logout();
		try {
			System.out.println("-----troca-----");
			this.loginf = facadeg.obterFuncionario(this.cpf, this.senha).get(0);
			nome = loginf.getNome();
			new CadastroClienteBean().setLoginf(loginf);
			System.out.println("-----troca-----"+loginf.getNome());
			
		} catch (BusinessException e) {
			System.out.println("caiu catch troca");
			
			e.printStackTrace();
		}finally {
			if(loginf.getNome() == null ) {
				System.out.println("1");
				
				loginf = new Funcionario();
			}
			if(login.getNome() == null) {
				System.out.println("2");
				
				login = new Cliente();
			}
			}
		}	
	
	public void loginCli() {
		//logout();
		try {
			System.out.println("-----troca de Cliente-----");
			this.login = facade.obterCliente(this.cpf, this.senha).get(0);
			this.telefone = facTel.obterTelefoneCpf(login);
			nome = login.getNome();
			new CadastroClienteBean().setLogin(login);
			new CadastroClienteBean().setCliente(login);
			
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
				System.out.println("caiu catch loginFun ");
			}
			try {
				loginCli();
			}catch(Exception e1) {
				System.out.println("caiu catch loginCli->->->->-> ");
			}
			
			//System.out.println("telefone do cara: " + telefone2.getTelefone());
			System.out.println("valida senha login obter nome: " + login.getNome() + " cpf " + login.getCpf());
			System.out.println("valida senha funcionario obter nome: " + loginf.getNome() + " cpf " + loginf.getCpf());

			if (loginf.getNome() != null) {
				loggedIn = true;
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem Vindo ", loginf.getNome().toString());

				System.out.println("valida senha login retornou login");
				try {
					Faces.redirect("./homefaces2.jsf");
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
				try {
					Faces.redirect("./homefaces.jsf");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				retornaLogin();
				new PedidoDeVendaBean().listarPedidos();

				// return "login";
			} else if (loginf.getNome() == null && login.getNome() == null){
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
	
	
	
	
	
	
	
	
	public String retornaLogin() {
		return "sucesso";
	}

	public String retornaFalha() {
		return "falha";
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
	public static Cliente getLogin() {
		return login;
	}
	public static void setLogin(Cliente login) {
		LoginBean.login = login;
	}
	public static Funcionario getLoginf() {
		return loginf;
	}
	public static void setLoginf(Funcionario loginf) {
		LoginBean.loginf = loginf;
	}
	public FacadeCliente getFacade() {
		return facade;
	}
	public void setFacade(FacadeCliente facade) {
		this.facade = facade;
	}
	public Long getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(Long confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	public static Telefone getTelefone2() {
		return telefone2;
	}
	public static void setTelefone2(Telefone telefone2) {
		LoginBean.telefone2 = telefone2;
	}
	public FacadeTelefone getFacTel() {
		return facTel;
	}
	public void setFacTel(FacadeTelefone facTel) {
		this.facTel = facTel;
	}
	public static Funcionario getFun() {
		return fun;
	}
	public static void setFun(Funcionario fun) {
		LoginBean.fun = fun;
	}
	public FacadeBusiness getFacadeg() {
		return facadeg;
	}
	public void setFacadeg(FacadeBusiness facadeg) {
		this.facadeg = facadeg;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
