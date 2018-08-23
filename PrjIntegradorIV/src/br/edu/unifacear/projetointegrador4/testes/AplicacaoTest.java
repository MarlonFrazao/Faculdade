package br.edu.unifacear.projetointegrador4.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.edu.unifacear.projetointegrador4.business.BusinessException;
import br.edu.unifacear.projetointegrador4.business.FacadeBusiness;
import br.edu.unifacear.projetointegrador4.entity.Aplicacao;

public class AplicacaoTest {
	//JUnit Build Path - add library - JUnit - JUnit 4 
	@Test //Indica que é um teste
	public void testeInserir() {
		
		Aplicacao a = new Aplicacao();
		a.setDescricao("teste");
		
		try {
			new FacadeBusiness().inserirAplicacao(a);
		} catch(BusinessException e) {
			e.printStackTrace();
		}
		
		assertEquals(true, a.getId() != null);
	}
	
	//para testar: clicar com direito - Run As - JUnit
}
