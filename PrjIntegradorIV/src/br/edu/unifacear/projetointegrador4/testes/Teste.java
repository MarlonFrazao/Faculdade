package br.edu.unifacear.projetointegrador4.testes;

import br.edu.unifacear.projetointegrador4.dao.LinhaDeVeiculoDAO;
import br.edu.unifacear.projetointegrador4.dao.MontadoraDAO;
import br.edu.unifacear.projetointegrador4.entity.LinhaDeVeiculo;
import br.edu.unifacear.projetointegrador4.entity.Montadora;

//a Pasta META-INF com o arquivo persistence.xml é obrigatório estar dentro da pasta src

public class Teste {
	
	public static void main(String[] args) {
		
		//----------------------------------------------------------------------//
		//criando e testando a tabela MONTADORA
		
		//MontadoraDAO dao = new MontadoraDAO();
		//não é necessario setar ID pq vai ser gerado automaticamente
		
		Montadora m = new Montadora();
		
		m.setDescricao("Chevrolet");
		m.setStatus(true);
		
		new MontadoraDAO().inserir(m);
		
		
		
		/*
		Montadora m = new Montadora();
		Montadora m2 = new Montadora();
				
		m.setId((long) 2);
		m.setDescricao("Fiat");
		m.setStatus(true);
		
		MontadoraDAO dao = new MontadoraDAO();
		m2 = dao.inserir(m);
				
		System.out.println("Descrição: "+m2.getDescricao());
		*/
		
		
		/*
		Montadora m = new Montadora();
		m.setDescricao("f");
		for(Montadora mL: dao.obter(m.getDescricao())) {
			System.out.println("=============================");
			System.out.println("Id: "+mL.getId());
			System.out.println("Descrição: "+mL.getDescricao());
			System.out.println("Status: "+mL.getStatus());
			
		}
		*/
		
		
		/*
		for(Montadora m: dao.listar()) {
			System.out.println("Descrição: "+m.getDescricao());
		}
		*/
		
		
		
		//----------------------------------------------------------------------//
		//criando e testando a tabela APLICACAO
		
		//AplicacaoDAO dao = new AplicacaoDAO();
		
		/*
		Aplicacao a = new Aplicacao();
		a.setDescricao("Lataria");
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
		 a2 = dao.obter(a.getId());
		 
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
				//criando e testando a tabela FABRICANTE
				
				//FabricanteDAO dao = new FabricanteDAO();
				
				/*
				Fabricante f = new Fabricante();
				f.setDescricao("Zagalo");
				f.setStatus(true);
				dao.inserir(f);
				*/
				
				
				/*
				for(Fabricante f: dao.listar()) {
					System.out.println("=============================");
					System.out.println("Id: "+f.getId());
					System.out.println("Descricao: "+f.getDescricao());
					System.out.println("Status: "+f.getStatus());
				}
				*/
				
				
				/* 
				 Fabricante f = new Fabricante();
				 Fabricante f2 = new Fabricante();
				 f.setId((long) 2);
				 f2 = dao.obter(a.getId());
				 
				System.out.println("Descrição: "+f2.getDescricao());
				*/
				
				
				/*
				Fabricante f = new Fabricante();
				f.setDescricao("l");
				
				for(Fabricante fL: dao.obter(f.getDescricao())) {
					System.out.println("=============================");
					System.out.println("Id: "+fL.getId());
					System.out.println("Descricao: "+fL.getDescricao());
					System.out.println("Status: "+fL.getStatus());
				}
				*/
		
		//----------------------------------------------------------------------//
		//criando e testando a tabela LINHA DE VEICULO
		
		LinhaDeVeiculoDAO dao = new LinhaDeVeiculoDAO();
		
		/*
		LinhaDeVeiculo ldv = new LinhaDeVeiculo();
		ldv.setDescricao("Ret");
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
		
		
	}

}
