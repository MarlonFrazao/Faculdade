package br.edu.unifacear.projetointegrador4.testes;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.model.entity.Montadora;

public class MontadoraTest {
	
	@Test
	public void testeInserir() {
		
		
		
		Montadora m = new Montadora();
		
		m.setDescricao("Kawasaki");
		System.out.println("============= Inserir =============");
		System.out.println("inserindo descrição errada: " + m.getDescricao());
		
		try {
			new FacadeBusiness().inserirMontadora(m);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(true, m.getId() != null);
	}
	
	@Test
	public void testeAtualizar() throws BusinessException {
		
		Montadora m = new FacadeBusiness().obterMontadora((long) 5 );
		
		m.setDescricao("Troller");
		
		new FacadeBusiness().atualizarMontadora(m);
		
		m = new FacadeBusiness().obterMontadora((long) 5);
		System.out.println("============= Atualizar =============");
		System.out.println("Corrigindo descrição: " + m.getDescricao());
		
		assertEquals(true, m.getId() != null);
	}
	
	@Test
	public void testeListar() {
		System.out.println("============= Listar =============");
		List<Montadora> lista = new FacadeBusiness().listarMontadora();
		
		if(lista.size() < 1) {
			System.out.println(":(");
		} else {
			System.out.println(":)");
			
			for(int i = 0; i < lista.size(); i ++) {
				System.out.println("ID: " + lista.get(i).getId() + 
						"\nDescrição: " + lista.get(i).getDescricao() + 
						"\nStatus: " + lista.get(i).getStatus());
			}
		}
	}
	
	@Test
	public void testeObterPorId() {
		
		Montadora m = null;
		
		try {
			m = new FacadeBusiness().obterMontadora((long) 1);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("============= Obter por Id =============");
		System.out.println("Buscando por id");
		System.out.println("Id: " + m.getId() + "\nDescricao: " + m.getDescricao());
	}
	
	@Test
	public void testeObterPorDescricao() {
		
		List<Montadora> lista = null;
		try { 
			lista = new FacadeBusiness().obterMontadora("on");
		} catch(BusinessException e) {
			e.printStackTrace();
		}
		System.out.println("============= Obter por Descrição =============");
		assertEquals(true, lista.get(0).getId() != null);
		System.out.println("teste obter por descricao");
		for(int i = 0; i < lista.size(); i++) {
			System.out.println("id: " + lista.get(i).getId() + 
					"\nDescricao:  " + lista.get(i).getDescricao());
		}
		
	}
	
	@Test
	public void testeExcluir() throws BusinessException {
		
		Montadora m = new FacadeBusiness().obterMontadora((long) 1);
		
		new FacadeBusiness().excluirMontadora(m);
	}
}
