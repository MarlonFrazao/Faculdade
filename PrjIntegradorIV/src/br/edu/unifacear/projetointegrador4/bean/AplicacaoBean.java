package br.edu.unifacear.projetointegrador4.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.projetointegrador4.model.entity.Aplicacao;
import br.edu.unifacear.projetointegrador4.model.facade.FacadeAplicacao;

@ManagedBean(name="aplicacaoBean")
@RequestScoped
public class AplicacaoBean {
	
	private Aplicacao aplicacao;
	private FacadeAplicacao facade;
	
	public AplicacaoBean() {
		aplicacao = new Aplicacao();
		facade = new FacadeAplicacao();
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public String inserir() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			System.out.println("---------OK---------");
			Aplicacao apli = new Aplicacao();
			//FacadeAplicacao fa = new FacadeAplicacao();
			System.out.println(aplicacao);
			
			apli.setDescricao(aplicacao.getDescricao());
			System.out.println(apli.getDescricao());
			facade.inserir(apli);
			System.out.println("---------OK3---------");
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
}
