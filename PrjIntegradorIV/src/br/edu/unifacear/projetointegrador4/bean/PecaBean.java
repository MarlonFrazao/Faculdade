package br.edu.unifacear.projetointegrador4.bean;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.model.entity.Aplicacao;
import br.edu.unifacear.projetointegrador4.model.entity.Modelo;
import br.edu.unifacear.projetointegrador4.model.entity.Peca;
import br.edu.unifacear.projetointegrador4.model.entity.Peca_Modelo;

@ManagedBean(name="pecaBean")
@RequestScoped
public class PecaBean {
	
	private Peca peca;
	private FacadeBusiness facade;
	private List<Peca> pecas;
	private List<Modelo> modelos;
	private Aplicacao aplicacao;
	private Peca_Modelo peca_Modelo;
	private Modelo modelo;
	private UploadedFile foto;
	
	public PecaBean() {
		peca = new Peca();
		facade = new FacadeBusiness();
		pecas = new ArrayList<Peca>();
		modelos = new ArrayList<Modelo>();
		aplicacao = new Aplicacao();
		peca_Modelo = new Peca_Modelo();
		modelo = new Modelo();
		
		
	}
	
	
	
	public UploadedFile getFoto() {
		return foto;
	}



	public void setFoto(UploadedFile foto) {
		this.foto = foto;
	}



	public Modelo getMod() {
		return modelo;
	}



	public void setMod(Modelo modelo) {
		this.modelo = modelo;
	}



	public Aplicacao getAplicacao() {
		return aplicacao;
	}



	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}



	public Peca_Modelo getPeca_Modelo() {
		return peca_Modelo;
	}



	public void setPeca_Modelo(Peca_Modelo peca_Modelo) {
		this.peca_Modelo = peca_Modelo;
	}



	public List<Modelo> getModelo() {
		return modelos;
	}



	public void setModelo(List<Modelo> modelos) {
		this.modelos = modelos;
	}



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
	
	
	public String inserir() {
		System.out.println("entra 1");
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			System.out.println("entra 2");
			peca.setAplicacao(aplicacao);
			peca_Modelo.setPeca(peca);
			peca_Modelo.setModelo(modelo);
			
			peca.adicionarPeca_Modelo(peca_Modelo);
			peca.setFoto(foto.getFileName());
			
			System.out.println("nome foto: "+peca.getFoto());
			
			facade.inserirPeca(peca);

			
			return "sucesso";

		} catch (Exception e) {
			System.out.println("entra exception inserir ");
			System.out.println("-----" + e.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return "cadastropecas";
		}
	}
	
	public String inserirModelo() {
		System.out.println("entra 1");
		FacesContext context = FacesContext.getCurrentInstance();
		ModeloBean modeloBean = new ModeloBean();
		try {
			System.out.println("entra 2");
			modelo = modeloBean.getModelo();			
			facade.inserirModelo(modelo);

			
			return "sucesso";

		} catch (Exception e) {
			System.out.println("entra exception inserir ");
			System.out.println("-----" + e.getMessage());
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return "cadastropecas";
		}
	}

}
