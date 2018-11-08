package br.edu.unifacear.projetointegrador4.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.model.entity.Modelo;
import br.edu.unifacear.projetointegrador4.model.entity.Peca_Modelo;

@ManagedBean(name="modeloBean")
@RequestScoped
public class ModeloBean {
		private Modelo modelo;
		private FacadeBusiness facade;
		private List<Modelo> modelos;
		private Peca_Modelo peca_Modelo;
		
		
		public ModeloBean() {
			System.out.println("entrouBean modelo");
			modelo = new Modelo();
			facade = new FacadeBusiness();
			modelos = new ArrayList<Modelo>();
			peca_Modelo = new Peca_Modelo();
		}
		
		
		
		public Peca_Modelo getPeca_Modelo() {
			return peca_Modelo;
		}



		public void setPeca_Modelo(Peca_Modelo peca_Modelo) {
			this.peca_Modelo = peca_Modelo;
		}



		public Modelo getModelo() {
			return modelo;
		}
		public void setModelo(Modelo modelo) {
			System.out.println("setou modelo");
			this.modelo = modelo;
		}
		public List<Modelo> getModelos() {
			return modelos;
		}
		public void setModelos(List<Modelo> modelos) {
			this.modelos = modelos;
		}
		
		@PostConstruct
		public void listar() {
			FacesContext context = FacesContext.getCurrentInstance();
			
			try {
				modelos = facade.listarModelo();
				
			} catch (BusinessException e) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						e.getMessage(),""));
				
			}
			
		}
		
		
		public String inserir(ActionEvent event) {
			System.out.println("inserir antes try modelo");
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				System.out.println("inserir modelo");
				facade.inserirModelo(modelo);
				
				return "sucesso";
			} catch(Exception e) {
				System.out.println("-----"+e.getMessage());
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						e.getMessage(),""));
				return "cadastrarmodelo";
			}
		}
		
}