package br.edu.unifacear.projetointegrador4.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.model.entity.Cargo;
import br.edu.unifacear.projetointegrador4.model.entity.Cliente;
import br.edu.unifacear.projetointegrador4.model.entity.Funcionario;
import br.edu.unifacear.projetointegrador4.model.entity.Telefone;
import br.edu.unifacear.projetointegrador4.model.facade.FacadeCliente;
import br.edu.unifacear.projetointegrador4.model.facade.FacadeTelefone;

@ManagedBean(name = "funcionarioBean")
@RequestScoped
public class FuncionarioBean {
	private Cliente cliente = null;
	private List<Telefone> telefone = null;
	private static Cliente login = new Cliente();
	private static Funcionario loginf = new Funcionario();
	private FacadeCliente facade = null;
	private Funcionario fun;
	private Long confirmaSenha = null;
	private static Telefone telefone2 = new Telefone();;
	private FacadeTelefone facTel = null;
	private static Funcionario funcionario = new Funcionario();
	private FacadeBusiness facadeg;
	private String cpf;
	private Long senha;
	private String nome;
	private Cargo cargo;
	private List<Cargo> listaCargo;
	private List<Funcionario> listaFun;
	
	
	public FuncionarioBean() {
		super();
		cargo = new Cargo();
		cliente = new Cliente();
		facade = new FacadeCliente();
		facTel = new FacadeTelefone();
		confirmaSenha = null;
		telefone = new ArrayList<Telefone>();
		fun = new Funcionario();
		facadeg = new FacadeBusiness();
		listaCargo = new ArrayList<Cargo>();
		listaFun = new ArrayList<Funcionario>();
		listarCargo();
		listarFuncionarios();
		System.out.println("login estável de cliente: "+login.getNome());
		System.out.println("login estável de funcionario: "+loginf.getNome());
	}
	
	public FuncionarioBean(Cliente cliente, List<Telefone> telefone, FacadeCliente facade, Funcionario fun,
			Long confirmaSenha, FacadeTelefone facTel, FacadeBusiness facadeg, String cpf, Long senha, String nome,
			Cargo cargo, List<Cargo> listaCargo, List<Funcionario> listaFun) {
		super();
		this.cliente = cliente;
		this.telefone = telefone;
		this.facade = facade;
		this.fun = fun;
		this.confirmaSenha = confirmaSenha;
		this.facTel = facTel;
		this.facadeg = facadeg;
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
		this.cargo = cargo;
		this.listaCargo = listaCargo;
		this.listaFun = listaFun;
	}

	public String inserir() {
		System.out.println("entra 1");
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			System.out.println("entra 2");
			telefone2.setCpf(fun.getCpf());
			facTel.inserirTelefone(telefone2);
			telefone.add(telefone2);
			fun.setTelefone(telefone);
			System.out.println("Cargo do funcionario: "+getCargo().getDescricao());
			fun.setCargo(cargo);

			facadeg.inserirFuncionario(fun);
			telefone2 = new Telefone();
			
			return "sucesso";

		} catch (Exception e) {
			System.out.println("entra exception inserir ");
			System.out.println("-----" + e.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return "cadastrofuncionario";
		}
	}
	
	public String atualizar() {
		try {
			facadeg.atualizarFuncionario(fun);
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "atualizou";
	}
	
	public void listarFuncionarios() {
		listaFun=facadeg.listarFuncionario();
	}

	public String confirmaSenha() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			if (this.cliente.getSenha() == this.confirmaSenha) {
				return "ok";
			} else {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas Não Conferem", null));
				return "cadastrarfuncionario";
			}
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return "cadastrarfuncionario";
		}
	}
	
	public List<Funcionario> getListaFun() {
		return listaFun;
	}

	public void setListaFun(List<Funcionario> listaFun) {
		this.listaFun = listaFun;
	}

	public void listarCargo() {
		listaCargo = facadeg.listarCargo();
	}
	
	
	
	public List<Cargo> getListaCargo() {
		return listaCargo;
	}


	public void setListaCargo(List<Cargo> listaCargo) {
		this.listaCargo = listaCargo;
	}


	public static Funcionario getFuncionario() {
		return funcionario;
	}
	public static void setFuncionario(Funcionario funcionario) {
		FuncionarioBean.funcionario = funcionario;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		System.out.println("cargo: "+cargo.getDescricao());
		this.cargo = cargo;
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
		FuncionarioBean.login = login;
	}
	public static Funcionario getLoginf() {
		return loginf;
	}
	public static void setLoginf(Funcionario loginf) {
		FuncionarioBean.loginf = loginf;
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
	public Telefone getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(Telefone telefone2) {
		telefone2 = telefone2;
	}
	public FacadeTelefone getFacTel() {
		return facTel;
	}
	public void setFacTel(FacadeTelefone facTel) {
		this.facTel = facTel;
	}
	public Funcionario getFun() {
		return fun;
	}
	public void setFun(Funcionario fun) {
		System.out.println("set funnnnnnnnn");
		fun= fun;
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
