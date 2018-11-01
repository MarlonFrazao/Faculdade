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
import br.edu.unifacear.projetointegrador4.model.entity.LinhaDeVeiculo;

@ManagedBean(name="linhaDeVeiculoBean")
@RequestScoped
public class LinhaDeVeiculoBean {
		private LinhaDeVeiculo linha;
		private List<LinhaDeVeiculo> linhas;
		private FacadeBusiness facade;
		
		
		public LinhaDeVeiculoBean() {
			linha = new LinhaDeVeiculo();
			linhas = new ArrayList<LinhaDeVeiculo>();
			facade = new FacadeBusiness();
		}
		public LinhaDeVeiculoBean(LinhaDeVeiculo linha, List<LinhaDeVeiculo> linhas) {
			super();
			this.linha = linha;
			this.linhas = linhas;
		}
		public LinhaDeVeiculo getLinha() {
			return linha;
		}
		public void setLinha(LinhaDeVeiculo linha) {
			this.linha = linha;
		}
		public List<LinhaDeVeiculo> getLinhas() {
			return linhas;
		}
		public void setLinhas(List<LinhaDeVeiculo> linhas) {
			this.linhas = linhas;
		}
		
		@PostConstruct
		public void listar() {
			FacesContext context = FacesContext.getCurrentInstance();
			
			try {
				linhas = facade.listarLinhaDeVeiculo();
				
			} catch (BusinessException e) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						e.getMessage(),""));
				
			}
			
		}
		
		
}
