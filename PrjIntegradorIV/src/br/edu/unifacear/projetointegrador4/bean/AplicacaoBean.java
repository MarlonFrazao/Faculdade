package br.edu.unifacear.projetointegrador4.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.entity.Aplicacao;
import br.edu.unifacear.projetointegrador4.model.facade.FacadeAplicacao;

@ManagedBean(name="aplicacaoBean")
@RequestScoped
public class AplicacaoBean {
	
	private Aplicacao aplicacao;
	private FacadeAplicacao facade;
	private List<Aplicacao> aplicacoes;
	
	public AplicacaoBean() {
		aplicacao = new Aplicacao();
		facade = new FacadeAplicacao();
		aplicacoes = new ArrayList<Aplicacao>();
		listar();
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public void setAplicacoes(List<Aplicacao> aplicacoes) {
		this.aplicacoes = aplicacoes;
	}

	public String inserir() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			
			facade.inserir(aplicacao);
			aplicacao = new Aplicacao();
			return "sucesso";
		} catch(Exception e) {
			System.out.println("-----"+e.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					e.getMessage(),""));
			return "cadastraraplicacao";
		}
	}
	
	public String atualizar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			facade.atualizar(aplicacao);
			return "sucesso";
		} catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					e.getMessage(),""));
			return "errow";
		}
	}
	
	//@PostConstruct
	public void listar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			aplicacoes = facade.listar(true);
			
		} catch (BusinessException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					e.getMessage(),""));
			
		}
		
	}
}
