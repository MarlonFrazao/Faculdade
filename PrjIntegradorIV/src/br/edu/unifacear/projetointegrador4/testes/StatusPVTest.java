package br.edu.unifacear.projetointegrador4.testes;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.unifacear.projetointegrador4.business.BusinessException;
import br.edu.unifacear.projetointegrador4.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.entity.StatusPV;

public class StatusPVTest {
	
	@Test
	public void testeInserir() {
		
		StatusPV s = new StatusPV();
		
		s.setDescricao("Confirmadi");
		System.out.println("============= Inserir =============");
		System.out.println("inserindo descrição errada: " + s.getDescricao());
		
		try {
			new FacadeBusiness().inserirStatusPV(s);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(true, s.getId() != null);
	}
	
	@Test
	public void testeAtualizar() throws BusinessException {
		StatusPV s = new FacadeBusiness().obterStatusPV((long) 2 );
		
		s.setDescricao("Confirmado");
		
		new FacadeBusiness().atualizarStatusPV(s);
		
		s = new FacadeBusiness().obterStatusPV((long) 2);
		System.out.println("============= Atualizar =============");
		System.out.println("Corrigindo descrição: " + s.getDescricao());
		
		assertEquals(true, s.getId() != null);
	}
	
	@Test
	public void testeListar() {
		List<StatusPV> lista = new FacadeBusiness().listarStatusPV();
		System.out.println("============= Listar =============");
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
		StatusPV s = null;
		
		try {
			s = new FacadeBusiness().obterStatusPV((long) 1);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("============= Obter por Id =============");
		System.out.println("Buscando por id");
		System.out.println("Id: " + s.getId() + "\nDescricao: " + s.getDescricao());
	}
	
	@Test
	public void testeObterPorDescricao() {
		List<StatusPV> lista = null;
		try { 
			lista = new FacadeBusiness().obterStatusPV("Carr");
		} catch(BusinessException e) {
			e.printStackTrace();
		}
		
		System.out.println("============= Obter por Descrição =============");
		System.out.println("teste obter por descricao");
		for(int i = 0; i < lista.size(); i++) {
			System.out.println("id: " + lista.get(i).getId() + 
					"\nDescricao:  " + lista.get(i).getDescricao());
		}
		
	}
	
	@Test
	public void testeExcluir() throws BusinessException {
		StatusPV s = new FacadeBusiness().obterStatusPV((long) 1);
		
		new FacadeBusiness().excluirStatusPV(s);
	}
}
