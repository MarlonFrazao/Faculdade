package br.edu.unifacear.projetointegrador4.testes;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.unifacear.projetointegrador4.business.BusinessException;
import br.edu.unifacear.projetointegrador4.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.entity.Cargo;

public class CargoTest {
	
	@Test
	public void testeInserir() {
		
		Cargo c = new Cargo();
		
		c.setDescricao("Administradr");
		
		System.out.println("inserindo descrição errada: " + c.getDescricao());
		
		try {
			new FacadeBusiness().inserirCargo(c);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(true, c.getId() != null);
	}
	
	@Test
	public void testeAtualizar() throws BusinessException {
		Cargo c = new FacadeBusiness().obterCargo((long) 1 );
		
		c.setDescricao("Administrador");
		
		new FacadeBusiness().atualizarCargo(c);
		
		c = new FacadeBusiness().obterCargo((long) 1);
		
		System.out.println("Corrigindo descrição: " + c.getDescricao());
		
		assertEquals(true, c.getId() != null);
	}
	
	@Test
	public void testeListar() {
		List<Cargo> lista = new FacadeBusiness().listarCargo();
		
		if(lista.size() < 1) {
			System.out.println(":(");
		} else {
			System.out.println(":)");
			
			for(int i = 0; i < lista.size(); i ++) {
				System.out.println("ID: " + lista.get(i).getId() + 
						"/nDescrição: " + lista.get(i).getDescricao() + 
						"/nStatus: " + lista.get(i).getStatus());
			}
		}
	}
	
	@Test
	public void testeObterPorId() {
		Cargo c = null;
		
		try {
			c = new FacadeBusiness().obterCargo((long) 1);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Buscando por id");
		System.out.println("Id: " + c.getId() + "/nDescricao: " + c.getDescricao());
	}
	
	@Test
	public void testeObterPorDescricao() {
		List<Cargo> lista = null;
		try { 
			lista = new FacadeBusiness().obterCargo("min");
		} catch(BusinessException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, lista.get(0).getId() != null);
		System.out.println("teste obter por descricao");
		for(int i = 0; i < lista.size(); i++) {
			System.out.println("id: " + lista.get(i).getId() + 
					"\nDescricao:  " + lista.get(i).getDescricao());
		}
		
	}
	
	@Test
	public void testeExcluir() throws BusinessException {
		Cargo c = new FacadeBusiness().obterCargo((long) 1);
		
		new FacadeBusiness().excluirCargo(c);
	}
}
