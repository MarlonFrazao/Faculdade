package br.edu.unifacear.projetointegrador4.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.model.entity.Peca;

@ManagedBean(name="pecaBean")
@RequestScoped
public class PecaBean {
	
	private Peca peca;
	private FacadeBusiness facade;
	private List<Peca> pecas;
	
	public Peca getPeca() {
		return peca;
	}
	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	
	public List<Peca> getPecas() {
		return pecas;
	}
	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}
	
	public PecaBean() {
		peca = new Peca();
		facade = new FacadeBusiness();
		pecas = new ArrayList<Peca>();
		
	}
	
	@PostConstruct
	public void listar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			System.out.println("entrou listar");
			pecas = facade.listarPeca();
			
		} catch (BusinessException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					e.getMessage(),""));
			
		}
		
		
		
	}
	
	

}
