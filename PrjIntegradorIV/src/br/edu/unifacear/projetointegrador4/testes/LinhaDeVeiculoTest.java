package br.edu.unifacear.projetointegrador4.testes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.model.entity.LinhaDeVeiculo;

public class LinhaDeVeiculoTest {
	
	@Test
	public void testeInserir() {
		
		LinhaDeVeiculo ldv = new LinhaDeVeiculo();
		
		ldv.setDescricao("Pesadp");
		System.out.println("============= Inserir =============");
		System.out.println("inserindo descri��o errada: " + ldv.getDescricao());
		
		try {
			new FacadeBusiness().inserirLinhaDeVeiculo(ldv);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(true, ldv.getId() != null);
	}
	
	@Test
	public void testeAtualizar() throws BusinessException {
		LinhaDeVeiculo ldv = new FacadeBusiness().obterLinhaDeVeiculo((long) 2 );
		
		ldv.setDescricao("Pesado");
		
		new FacadeBusiness().atualizarLinhaDeVeiculo(ldv);
		
		ldv = new FacadeBusiness().obterLinhaDeVeiculo((long) 2);
		System.out.println("============= Atualizar =============");
		System.out.println("Corrigindo descri��o: " + ldv.getDescricao());
		
		assertEquals(true, ldv.getId() != null);
	}
	
	@Test
	public void testeListar() {
		List<LinhaDeVeiculo> lista = new ArrayList<LinhaDeVeiculo>();
		try {
			lista = new FacadeBusiness().listarLinhaDeVeiculo();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("============= Listar =============");
		if(lista.size() < 1) {
			System.out.println(":(");
		} else {
			System.out.println(":)");
			
			for(int i = 0; i < lista.size(); i ++) {
				System.out.println("ID: " + lista.get(i).getId() + 
						"\nDescri��o: " + lista.get(i).getDescricao() + 
						"\nStatus: " + lista.get(i).getStatus());
			}
		}
	}
	
	@Test
	public void testeObterPorId() {
		LinhaDeVeiculo ldv = null;
		
		try {
			ldv = new FacadeBusiness().obterLinhaDeVeiculo((long) 1);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("============= Obter por Id =============");
		System.out.println("Buscando por id");
		System.out.println("Id: " + ldv.getId() + "\nDescricao: " + ldv.getDescricao());
	}
	
	@Test
	public void testeObterPorDescricao() {
		List<LinhaDeVeiculo> lista = null;
		try { 
			lista = new FacadeBusiness().obterLinhaDeVeiculo("Leve");
		} catch(BusinessException e) {
			e.printStackTrace();
		}
		System.out.println("============= Obter por Descri��o =============");
		assertEquals(true, lista.get(0).getId() != null);
		System.out.println("teste obter por descricao");
		for(int i = 0; i < lista.size(); i++) {
			System.out.println("id: " + lista.get(i).getId() + 
					"\nDescricao:  " + lista.get(i).getDescricao());
		}
		
	}
	
	@Test
	public void testeExcluir() throws BusinessException {
		LinhaDeVeiculo ldv = new FacadeBusiness().obterLinhaDeVeiculo((long) 1);
		
		new FacadeBusiness().excluirLinhaDeVeiculo(ldv);
	}
}
