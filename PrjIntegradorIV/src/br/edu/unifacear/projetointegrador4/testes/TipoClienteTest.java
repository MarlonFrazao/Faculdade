package br.edu.unifacear.projetointegrador4.testes;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.unifacear.projetointegrador4.business.BusinessException;
import br.edu.unifacear.projetointegrador4.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.entity.StatusPV;
import br.edu.unifacear.projetointegrador4.entity.TipoCliente;

public class TipoClienteTest {
	@Test
	public void testeInserir() {
		
		TipoCliente tc = new TipoCliente();
		
		tc.setDescricao("Ourrr");
		
		System.out.println("inserindo descrição errada: " + tc.getDescricao());
		
		try {
			new FacadeBusiness().inserirTipoCliente(tc);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(true, tc.getId() != null);
	}
	
	@Test
	public void testeAtualizar() throws BusinessException {
		TipoCliente tc = new FacadeBusiness().obterTipoCliente((long) 1 );
		
		tc.setDescricao("Ouro");
		
		new FacadeBusiness().atualizarTipoCliente(tc);
		
		tc = new FacadeBusiness().obterTipoCliente((long) 1);
		
		System.out.println("Corrigindo descrição: " + tc.getDescricao());
		
		assertEquals(true, tc.getId() != null);
	}
	
	@Test
	public void testeListar() {
		List<TipoCliente> lista = new FacadeBusiness().listarTipoCliente();
		
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
		TipoCliente tc = null;
		
		try {
			tc = new FacadeBusiness().obterTipoCliente((long) 1);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Buscando por id");
		System.out.println("Id: " + tc.getId() + "/nDescricao: " + tc.getDescricao());
	}
	
	@Test
	public void testeObterPorDescricao() {
		List<TipoCliente> lista = null;
		try { 
			lista = new FacadeBusiness().obterTipoCliente("o");
		} catch(BusinessException e) {
			e.printStackTrace();
		}
		
		//assertEquals(true, lista.get(0).getId() != null);
		System.out.println("teste obter por descricao");
		for(int i = 0; i < lista.size(); i++) {
			System.out.println("id: " + lista.get(i).getId() + 
					"\nDescricao:  " + lista.get(i).getDescricao());
		}
		
	}
	
	@Test
	public void testeExcluir() throws BusinessException {
		TipoCliente tc = new FacadeBusiness().obterTipoCliente((long) 1);
		
		new FacadeBusiness().excluirTipoCliente(tc);
	}
}
