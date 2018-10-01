package br.edu.unifacear.projetointegrador4.testes;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.model.entity.Aplicacao;

public class TelefoneTest {
	//JUnit Build Path - add library - JUnit - JUnit 4 

	//Indica que é um teste
	/*
	@Test //Indica que é um teste

	public void testeInserir() {
		
		Aplicacao a = new Aplicacao();

		a.setDescricao("Freio");

		System.out.println("============= Inserir =============");
		System.out.println("testeInserir: "+a.getDescricao());

		
		try {
			new FacadeBusiness().inserirAplicacao(a);
		} catch(BusinessException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, a.getId() != null);
	}
	
	//para testar: clicar com direito - Run As - JUnit
	
	@Test
	public void testeAtualizar() throws BusinessException {
		Aplicacao a = new FacadeBusiness().obterAplicacao((long) 6);

		a.setDescricao("Sistema de Frenagem");

		
		System.out.println("testeAtualizar: "+a.getDescricao());

		
		try {
			new FacadeBusiness().atualizarAplicacao(a);
		} catch(BusinessException e) {
			e.printStackTrace();
		}
		a = new FacadeBusiness().obterAplicacao((long) 6);
		System.out.println("============= Atualizar =============");
		System.out.println("testeAtualizar: "+a.getDescricao());
		
		assertEquals(true, a.getId() != null);
	}
	*/
	@Test 
	public void testeListar() throws BusinessException {
		List<Aplicacao> lista = new FacadeBusiness().listarAplicacao();
		System.out.println("============= Listar =============");
		if(lista.size() < 1) {
			System.out.println("Deu ruim! :(");
		} else {
			System.out.println("Deu boa! :)\n\nTesteListar!");
			
			for(int i = 0; i < lista.size(); i++) {
				System.out.println("Id: " + lista.get(i).getId() + 
						" descricao: " + lista.get(i).getDescricao());
			}
		}
	}
	
	@Test
	public void testeObterPorId() {
		Aplicacao a = null;
		try { 
			a = new FacadeBusiness().obterAplicacao((long) 2);
		} catch(BusinessException e) {
			e.printStackTrace();
		}
		
		System.out.println("============= Obter por Id =============");
		System.out.println("teste obter por id");
		
		System.out.println("id: " + a.getId() + 
					"\nDescricao:  " + a.getDescricao());
		
	}
	
	@Test
	public void testeObterPorDescricao() {
		List<Aplicacao> la = null;
		try { 
			la = new FacadeBusiness().obterAplicacao("Suspensão");
		} catch(BusinessException e) {
			e.printStackTrace();
		}
		System.out.println("============= Obter por Descrição =============");
		assertEquals(true, la.get(0).getId() != null);
		System.out.println("teste obter por descricao");
		for(int i = 0; i < la.size(); i++) {
			System.out.println("id: " + la.get(i).getId() + 
					"\nDescricao:  " + la.get(i).getDescricao());
		}
		
	}
	
	/*
	@Test
	public void testeExcluir() throws BusinessException {
		Aplicacao a = new FacadeBusiness().obterAplicacao((long) 1);
		
		new FacadeBusiness().excluirAplicacao(a);
	}*/
	
}
