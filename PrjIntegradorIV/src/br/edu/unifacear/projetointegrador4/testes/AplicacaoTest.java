package br.edu.unifacear.projetointegrador4.testes;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.unifacear.projetointegrador4.business.BusinessException;
import br.edu.unifacear.projetointegrador4.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.entity.Aplicacao;

public class AplicacaoTest {
	//JUnit Build Path - add library - JUnit - JUnit 4 
<<<<<<< HEAD
	@Test //Indica que é um teste
=======
/*	@Test //Indica que é um teste
>>>>>>> refs/remotes/origin/master
	public void testeInserir() {
		
		Aplicacao a = new Aplicacao();
<<<<<<< HEAD
		a.setDescricao("Motor");
=======
		a.setDescricao("teste3");
		System.out.println("testeInserir: "+a.getDescricao());
>>>>>>> refs/remotes/origin/master
		
		try {
			new FacadeBusiness().inserirAplicacao(a);
		} catch(BusinessException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, a.getId() != null);
	}
	
	//para testar: clicar com direito - Run As - JUnit
	
	/*@Test
	public void testeObterPorDescricao() {
		List<Aplicacao> la = null;
		try { 
			la = new FacadeBusiness().obterAplicacao("t");
		} catch(BusinessException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, la.get(0).getId() != null);
		
		for(int i = 0; i < la.size(); i++) {
			System.out.println("id: " + la.get(i).getId() + 
					"\nDescricao:  " + la.get(i).getDescricao());
		}
		
	}*/
	
}
