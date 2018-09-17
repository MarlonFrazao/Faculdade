package br.edu.unifacear.projetointegrador4.testes;


import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.dao.LinhaDeVeiculoDAO;
import br.edu.unifacear.projetointegrador4.dao.ModeloDAO;
import br.edu.unifacear.projetointegrador4.dao.MontadoraDAO;
import br.edu.unifacear.projetointegrador4.dao.PecaDAO;
import br.edu.unifacear.projetointegrador4.entity.LinhaDeVeiculo;
import br.edu.unifacear.projetointegrador4.entity.Modelo;
import br.edu.unifacear.projetointegrador4.entity.Montadora;
import br.edu.unifacear.projetointegrador4.entity.Peca;
import br.edu.unifacear.projetointegrador4.entity.Peca_Modelo;





//a Pasta META-INF com o arquivo persistence.xml é obrigatório estar dentro da pasta src

public class Teste {
	
	public static void main(String[] args) {
		
		//----------------------------------------------------------------------//
		//criando e testando a tabela MONTADORA
		
		//MontadoraDAO dao = new MontadoraDAO();
		//não é necessario setar ID pq vai ser gerado automaticamente

		/*
		Montadora m = new Montadora();

		
		/*Montadora m = new Montadora();
		
		m.setDescricao("Honda");
		m.setStatus(true);
		
		new MontadoraDAO().inserir(m);
		*/
		
		
		/*
		Montadora m = new Montadora();
		Montadora m2 = new Montadora();
				
		m.setId((long) 2);
		m.setDescricao("Yamaha");
		m.setStatus(true);
		
		MontadoraDAO dao = new MontadoraDAO();
		dao.atualizar(m);
				
		System.out.println("Descrição: "+m2.getDescricao());
		*/
		
		/*
		MontadoraDAO dao = new MontadoraDAO();
		Montadora m = new Montadora();
		m.setDescricao("a");
		for(Montadora mL: dao.obter(m.getDescricao())) {
			System.out.println("=============================");
			System.out.println("Id: "+mL.getId());
			System.out.println("Descrição: "+mL.getDescricao());
			System.out.println("Status: "+mL.getStatus());
			
		}*/
		
		
		/*
		MontadoraDAO dao = new MontadoraDAO();
		for(Montadora m: dao.listar()) {
			System.out.println("Descrição: "+m.getDescricao());
		}
		
		*/
		
		
		//----------------------------------------------------------------------//
		//criando e testando a tabela APLICACAO
		
		//AplicacaoDAO dao = new AplicacaoDAO();
		
		/*
		Aplicacao a = new Aplicacao();
		a.setDescricao("Iluminação");
		a.setStatus(true);
		dao.inserir(a);
		*/
		
		
		/*
		for(Aplicacao a: dao.listar()) {
			System.out.println("=============================");
			System.out.println("Id: "+a.getId());
			System.out.println("Descricao: "+a.getDescricao());
			System.out.println("Status: "+a.getStatus());
		}
		*/
		
		
		/*
		 Aplicacao a = new Aplicacao();
		 Aplicacao a2 = new Aplicacao();
		 a.setId((long) 2);
		 a2 = dao.obter(Aplicacao.class, a.getId());
		 
		System.out.println("Descrição: "+a2.getDescricao());
		*/
		
		
		/*
		Aplicacao a = new Aplicacao();
		a.setDescricao("l");
		
		for(Aplicacao aL: dao.obter(a.getDescricao())) {
			System.out.println("=============================");
			System.out.println("Id: "+aL.getId());
			System.out.println("Descricao: "+aL.getDescricao());
			System.out.println("Status: "+aL.getStatus());
		}
		*/
		
		//----------------------------------------------------------------------//
		//criando e testando a tabela LINHA DE VEICULO
		

		/*LinhaDeVeiculoDAO dao = new LinhaDeVeiculoDAO();

	//	LinhaDeVeiculoDAO dao = new LinhaDeVeiculoDAO();

		
		
		LinhaDeVeiculo ldv = new LinhaDeVeiculo();
		ldv.setDescricao("Leve");
		ldv.setStatus(true);
		dao.inserir(ldv);
		*/
		
		
		/*
		for(LinhaDeVeiculo ldv: dao.listar()) {
			System.out.println("=============================");
			System.out.println("Id: "+ldv.getId());
			System.out.println("Descricao: "+ldv.getDescricao());
			System.out.println("Status: "+ldv.getStatus());
		}
		*/
		
		
		/*
		 LinhaDeVeiculo ldv = new LinhaDeVeiculo();
		 LinhaDeVeiculo ldv2 = new LinhaDeVeiculo();
		 ldv.setId((long) 2);
		 ldv2 = dao.obter(LinhaDeVeiculo.class, ldv.getId());
		 
		System.out.println("Descrição: "+ldv2.getDescricao());
		*/
		
		
		/*
		LinhaDeVeiculo ldv = new LinhaDeVeiculo();
		ldv.setDescricao("l");
		
		for(LinhaDeVeiculo ldvL: dao.obter(ldv.getDescricao())) {
			System.out.println("=============================");
			System.out.println("Id: "+ldvL.getId());
			System.out.println("Descricao: "+ldvL.getDescricao());
			System.out.println("Status: "+ldvL.getStatus());
		}
		*/
		
		//----------------------------------------------------------------------//
				//criando e testando a tabela Modelo
				/*
				ModeloDAO dao = new ModeloDAO();
				MontadoraDAO montDao = new MontadoraDAO();
				Montadora mont = new Montadora();
				mont = montDao.obter(Montadora.class, (long) 1);
				LinhaDeVeiculoDAO linDao = new LinhaDeVeiculoDAO();
				LinhaDeVeiculo linha = new LinhaDeVeiculo();
				linha = linDao.obter(LinhaDeVeiculo.class, (long) 1);
				PecaDAO peDAO = new PecaDAO();
				List<Peca> listaPe = new ArrayList<Peca>();
				Peca_Modelo peca_modelo = new Peca_Modelo();
				Peca_Modelo peca_modelo2 = new Peca_Modelo();
				Peca_Modelo peca_modelo3 = new Peca_Modelo();
				//listaPe = peDAO.listar();
				
				Modelo modelo = new Modelo();
				
				modelo.setDescricao("Torto");
				modelo.setMontadora(mont);
				modelo.setLinha(linha);
				//modelo.setPecas(listaPe);
				modelo.setAno(2016);
				modelo.setStatus(true);
				
				// primeira peca do modelo
				peca_modelo.setPeca(peDAO.obter(Peca.class, (long) 7));				
				peca_modelo.setModelo(modelo);	
				
				peca_modelo2.setPeca(peDAO.obter(Peca.class, (long) 8));
				peca_modelo2.setModelo(modelo);
				
				peca_modelo3.setPeca(peDAO.obter(Peca.class, (long) 9));
				peca_modelo3.setModelo(modelo);
				
				modelo.adicionarPeca_Modelo(peca_modelo);
				modelo.adicionarPeca_Modelo(peca_modelo2);
				modelo.adicionarPeca_Modelo(peca_modelo3);
				
				dao.inserir(modelo);
				*/
		
		//Listando modelos por peça
		ModeloDAO dao2 = new ModeloDAO();
		List<Modelo> lista = new ArrayList<Modelo>();
		Peca pe = new Peca();
		PecaDAO peDAO = new PecaDAO();
		pe = peDAO.obter(Peca.class, (long) 21);
		
		lista = dao2.obter(pe);
		
		for(int i = 0; i< lista.size(); i ++) {
			System.out.println("======================================");
			System.out.println("Id modelo: "+lista.get(i).getId());
			System.out.println("Descrição modelo: "+lista.get(i).getDescricao());
			System.out.println("Ano modelo: "+lista.get(i).getAno());
			System.out.println("Linha modelo: "+lista.get(i).getLinha().getDescricao());
			System.out.println("Montadora modelo: "+lista.get(i).getMontadora().getDescricao());
			System.out.println("Descricão peça: "+pe.getDescricao());
			System.out.println("Id peça: "+pe.getId());
		}
		
		
		
		
				//modelo = dao.obter(Modelo.class, (long) 1);
				/*
				modelo.setPecas(listaPe);
				dao.atualizar(modelo);
				*/
				
		

		//Modelo mod = new Modelo();
		//Peca peca = new Peca();
		//ModeloDAO modDAO = new ModeloDAO();
		//PecaDAO pecaDAO = new PecaDAO();
				
				
				/*
				for(LinhaDeVeiculo ldv: dao.listar()) {
					System.out.println("=============================");
					System.out.println("Id: "+ldv.getId());
					System.out.println("Descricao: "+ldv.getDescricao());
					System.out.println("Status: "+ldv.getStatus());
				}
				*/
				
				
				/* 
				 LinhaDeVeiculo ldv = new LinhaDeVeiculo();
				 LinhaDeVeiculo ldv2 = new LinhaDeVeiculo();
				 ldv.setId((long) 2);
				 ldv2 = dao.obter(ldv.getId());
				 
				System.out.println("Descrição: "+ldv2.getDescricao());
				*/
				
				
				/*
				LinhaDeVeiculo ldv = new LinhaDeVeiculo();
				ldv.setDescricao("l");
				
				for(LinhaDeVeiculo ldvL: dao.obter(ldv.getDescricao())) {
					System.out.println("=============================");
					System.out.println("Id: "+ldvL.getId());
					System.out.println("Descricao: "+ldvL.getDescricao());
					System.out.println("Status: "+ldvL.getStatus());
				}
				*/
		
				//----------------------------------------------------------------------//
				//criando e testando a tabela PECA
				/*
				PecaDAO dao = new PecaDAO();
				
				AplicacaoDAO apDAO = new AplicacaoDAO();
				Aplicacao apli = new Aplicacao();
				apli = apDAO.obter(Aplicacao.class, (long) 2);
				ModeloDAO modDAO = new ModeloDAO();
				Peca_Modelo peca_modelo = new Peca_Modelo();
				Peca_Modelo peca_modelo2 = new Peca_Modelo();
				Peca_Modelo peca_modelo3 = new Peca_Modelo();
				Calendar data = Calendar.getInstance();
				Modelo modpeca = new Modelo();
				
				Peca peca = new Peca();
				peca.setDescricao("Arruela");
				peca.setAplicacao(apli);
				peca.setAdicional(" ");					
				peca.setMediaAvaliacao((float) 2);			
				peca.setNumVisualizacao((long) 5);				
				peca.setQtdeTotal((long) 15);
				peca.setTotalAvaliacao((long) 2);
				peca.setStatus(true);
				
				// primeiro modelo da peça
				modpeca = modDAO.obter(Modelo.class, (long) 2);				
				peca_modelo.setModelo(modpeca);				
				peca_modelo.setPeca(peca);				
				
				//segundo modelo da peça
				modpeca = modDAO.obter(Modelo.class, (long) 3);
				peca_modelo2.setModelo(modpeca);
				peca_modelo2.setPeca(peca);
				
				//terceiro modelo da peca
				modpeca = modDAO.obter(Modelo.class, (long) 4);
				peca_modelo3.setModelo(modpeca);
				peca_modelo3.setPeca(peca);	
				
				
				//adicionando para a lista de modelos
				peca.adicionarPeca_Modelo(peca_modelo);	
				peca.adicionarPeca_Modelo(peca_modelo2);
				peca.adicionarPeca_Modelo(peca_modelo3);
				
				// persistindo no banco de dados				
				dao.inserir(peca);
			*/
				
		/*		
		//listando peças por modelo
		PecaDAO dao2 = new PecaDAO();
		List<Peca> lista = new ArrayList<Peca>();
		Modelo mod = new Modelo();
		ModeloDAO modDAO2 = new ModeloDAO();
		mod = modDAO2.obter(Modelo.class, (long) 2);
		
		lista = dao2.obter(mod);
		
		
		
		for(int i = 0; i< lista.size(); i++) {
			System.out.println("=============================");
			System.out.println("Id: "+lista.get(i).getId());
			System.out.println("Descricao: "+lista.get(i).getDescricao());
			System.out.println("Status: "+lista.get(i).getStatus());
			System.out.println("Adicional: "+lista.get(i).getAdicional());
			System.out.println("Media: "+lista.get(i).getMediaAvaliacao());
			System.out.println("Vizualiz: "+lista.get(i).getNumVisualizacao());
			System.out.println("QTDA: "+lista.get(i).getQtdeTotal());
			System.out.println("Desc Modelo: "+mod.getDescricao());
			System.out.println("Id Modelo: "+mod.getId());
		
		}
		*/
		
		/*
		Peca peca = new Peca();
		PecaDAO dao = new PecaDAO();
		ModeloDAO modDAO = new ModeloDAO();
		List<Modelo> lista = new ArrayList<Modelo>();
		lista = modDAO.listar();
		
		peca.setId((long) 1);
		peca.setModelo(lista);
		dao.atualizar(peca);
		*/
		
		

	}

}
