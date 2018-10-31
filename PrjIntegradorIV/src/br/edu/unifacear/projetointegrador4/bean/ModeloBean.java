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
import br.edu.unifacear.projetointegrador4.model.entity.Modelo;

@ManagedBean(name="modeloBean")
@RequestScoped
public class ModeloBean {
		private Modelo modelo;
		private FacadeBusiness facade;
		private List<Modelo> modelos;
		
		
		public ModeloBean() {
			modelo = new Modelo();
			facade = new FacadeBusiness();
			modelos = new ArrayList<Modelo>();
			
		}
		
		
		public Modelo getModelo() {
			return modelo;
		}
		public void setModelo(Modelo modelo) {
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
		
}
