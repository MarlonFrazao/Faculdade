package br.edu.unifacear.projetointegrador4.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="navegacaoBean")
@RequestScoped
public class NavegacaoBean {
	
	public String home() {
		return "home";
	}
	
	public String produtos() {
		return "produtos";
	}
	
	public String carrinho() {
		return "carrinho";
	}
	
	public String cadastroUsuario() {
		return "cadastroUsuario";
	}
	
	public String clientes() {
		return "clientes";
	}

}
