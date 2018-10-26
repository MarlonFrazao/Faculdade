package br.edu.unifacear.projetointegrador4.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.model.entity.Montadora;


@ManagedBean(name="montadoraBean")
@RequestScoped
public class MontadoraBean {
	private Montadora montadora;
	private FacadeBusiness facade;
	private List<Montadora> montadoras;
	
	public MontadoraBean() {
		montadora = new Montadora();
		facade = new FacadeBusiness();
		
	}

	public Montadora getmontadora() {
		return montadora;
	}

	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}

	public List<Montadora> getMontadoras() {
		return montadoras;
	}

	public void setMontadoras(List<Montadora> montadoras) {
		this.montadoras = montadoras;
	}

	public String inserir() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			
			facade.inserirMontadora(montadora);
			
			return "sucesso";
		} catch(Exception e) {
			System.out.println("-----"+e.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					e.getMessage(),""));
			return "cadastrarmontadora";
		}
	}
	
	public String atualizar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			facade.atualizarMontadora(montadora);
			return "sucesso";
		} catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					e.getMessage(),""));
			return "errow";
		}
	}
	
	@PostConstruct
	public void listar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			montadoras = facade.listarMontadora();
			
		} catch (BusinessException e)  {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					e.getMessage(),""));
			
		}
		
	}
}
