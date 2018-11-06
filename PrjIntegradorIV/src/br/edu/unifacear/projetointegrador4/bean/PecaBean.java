package br.edu.unifacear.projetointegrador4.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.model.business.PecaBusiness;
import br.edu.unifacear.projetointegrador4.model.entity.Aplicacao;
import br.edu.unifacear.projetointegrador4.model.entity.Modelo;
import br.edu.unifacear.projetointegrador4.model.entity.Peca;
import br.edu.unifacear.projetointegrador4.model.entity.Peca_Modelo;

@ManagedBean(name = "pecaBean")
@RequestScoped
public class PecaBean {

	private Peca peca;
	private FacadeBusiness facade;
	private List<Peca> pecas;
	private Aplicacao aplicacao;
	private List<Aplicacao> aplicacoes;
	private Peca_Modelo peca_Modelo;
	private List<Modelo> modelos;
	private Modelo modelo;
	private UploadedFile foto;
	private String desc;
	private Boolean status;
	private PecaBusiness business;
	private String diretorioDestino;

	public PecaBean() {

		System.out.println("Entrou bean");

		peca = new Peca();
		facade = new FacadeBusiness();
		pecas = new ArrayList<Peca>();
		aplicacao = new Aplicacao();
		peca_Modelo = new Peca_Modelo();
		modelo = new Modelo();
		aplicacoes = new ArrayList<Aplicacao>();
		diretorioDestino = "C:\\Temp\\";
		listarApli();
		listarMod();
		System.out.println("desc antes: " + desc);
		desc = "";
		System.out.println("desc depois: " + desc);
		status = null;
		business = new PecaBusiness();
		this.listar();
	}

	public void listarMod() {
		try {
			modelos = new FacadeBusiness().listarModelo();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listarApli() {
		try {
			aplicacoes = new FacadeBusiness().listarAplicacao();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Aplicacao> getAplicacoes() {
		return aplicacoes;
	}

	public void setAplicacoes(List<Aplicacao> aplicacoes) {
		this.aplicacoes = aplicacoes;
	}

	public UploadedFile getFoto() {
		return foto;
	}

	public void setFoto(UploadedFile foto) {
		this.foto = foto;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		System.out.println("Aplicacao: " + aplicacao.getDescricao());
		this.aplicacao = aplicacao;
	}

	public Peca_Modelo getPeca_Modelo() {
		return peca_Modelo;
	}

	public void setPeca_Modelo(Peca_Modelo peca_Modelo) {
		this.peca_Modelo = peca_Modelo;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	public List<Peca> getPecas() {
		for (int i = 0; i < pecas.size(); i++) {
			System.out.println("Id: " + pecas.get(i).getId());
			System.out.println("Nome: " + pecas.get(i).getDescricao());
			System.out.println("QTD: " + pecas.get(i).getQtdeTotal());
		}
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	// @PostConstruct
	public void listar() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			System.out.println("entrou listar");
			pecas = facade.listarPeca();

		} catch (BusinessException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));

		}

	}

	public void pegaModelo() {
		this.modelo = new ModeloBean().getModelo();
		System.out.println("pecaBean pega modelo" + modelo.getDescricao());
	}

	public String inserir() {
		System.out.println("entra 1");
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			// pegaModelo();

			System.out.println("entra 2");
			System.out.println("peca Nome:" + peca.getDescricao());
			System.out.println("peca adicional:" + peca.getAdicional());
			System.out.println("peca id apli:" + peca.getAplicacao().getId());
			System.out.println("peca qtd:" + peca.getQtdeTotal());

			// peca.setAplicacao(aplicacao);

			// peca.setFoto(foto.getFileName());

			// System.out.println("nome foto: " + peca.getFoto());
			peca_Modelo.setPeca(peca);
			peca_Modelo.setModelo(modelo);

			peca.adicionarPeca_Modelo(peca_Modelo);
			System.out.println("meu nome de foto: "+peca.getFoto());
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

	public String filtrar() {
		FacesContext context = FacesContext.getCurrentInstance();
		System.out.println("Filtrar");

		try {
			int aux = 0;

			if (!desc.equals("")) {
				aux = aux + 1;
			}

			if (modelo.getId() != null) {
				aux = aux + 2;
			}

			if (aplicacao.getId() != null) {
				aux = aux + 4;
			}

			if (status != null) {
				aux = aux + 8;
			}

			System.out.println("aux: " + aux);
			if (aux == 0) {
				pecas = facade.listarPeca();
			} else if (aux == 1) {
				System.out.println("Desc filtrar: " + desc);
				pecas = business.filtrar(desc);
			} else if (aux == 2) {
				pecas = business.filtrar(modelo);
			} else if (aux == 3) {
				pecas = business.filtrar(desc, modelo);
			} else if (aux == 4) {
				pecas = business.filtrar(aplicacao);
			} else if (aux == 5) {
				pecas = business.filtrar(desc, aplicacao);
			} else if (aux == 6) {
				pecas = business.filtrar(modelo, aplicacao);
			} else if (aux == 7) {
				pecas = business.filtrar(desc, modelo, aplicacao);
			} else if (aux == 8) {
				pecas = business.filtrar(status);
			} else if (aux == 9) {
				pecas = business.filtrar(desc, status);
			} else if (aux == 10) {
				pecas = business.filtrar(modelo, status);
			} else if (aux == 11) {
				pecas = business.filtrar(desc, modelo, status);
			} else if (aux == 12) {
				pecas = business.filtrar(aplicacao, status);
			} else if (aux == 13) {
				pecas = business.filtrar(desc, aplicacao, status);
			} else if (aux == 14) {
				pecas = business.filtrar(modelo, aplicacao, status);
			} else if (aux == 15) {
				pecas = business.filtrar(desc, modelo, aplicacao, status);
			}

			System.out.println("lista no feijão: " + pecas.size());

			
			return "filtrou";

		} catch (Exception e) {
			try {
				pecas = facade.listarPeca();
				System.out.println("caiu catch try");
			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				System.out.println("caiu catch catch");
				e1.printStackTrace();
			}
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
			return "filtrar";
		}

	}

	public void upload(FileUploadEvent event) {

		// Nome do Arquivo que quero gerar 17-11-2015-13:14:21.584.png
		String nomeArq = getFileName(event.getFile().getFileName());
		peca.setFoto(nomeArq);
		System.out.println(peca.getFoto());

		System.out.println(event.getFile().getFileName());

		FacesMessage msg = new FacesMessage("Sucesso! ", nomeArq + " foi carregado.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		// Do what you want with the file
		try {
			copyFile(nomeArq, event.getFile().getInputstream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void copyFile(String fileName, InputStream in) {
		try {
			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(diretorioDestino
					+ fileName));
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("Novo arquivo criado '"+fileName+"'!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getExtensao(String nomeArquivo)
    {
		int posicaoPonto = nomeArquivo.lastIndexOf(".");
		int tamanhoString = nomeArquivo.length();
		return nomeArquivo.substring(posicaoPonto + 1, tamanhoString);  
    }

	public String getFileName(String nomeArquivo) {
		String data = "yyyy-MM-dd";
		String hora = "HH-mm-ss-SSS";
		String data1, hora1;

		java.util.Date agora = new java.util.Date();
		SimpleDateFormat formata = new SimpleDateFormat(data);
		data1 = formata.format(agora);
		formata = new SimpleDateFormat(hora);
		hora1 = formata.format(agora);
		return data1 + "-" + hora1+"."+getExtensao(nomeArquivo);
	}

}
