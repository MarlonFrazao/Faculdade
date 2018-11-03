package br.edu.unifacear.projetointegrador4.testes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.edu.unifacear.projetointegrador4.model.business.PecaBusiness;
import br.edu.unifacear.projetointegrador4.model.entity.Peca;

public class PecaTest {
	
	@Test
	public void testeFiltro(){
		List<Peca> p = new ArrayList<Peca>();
		
		try {
			p = new PecaBusiness().filtrar("Farol");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < p.size(); i++) {
			System.out.println("Id: " + p.get(i).getId() + 
					"\nDescricao: " + p.get(i).getDescricao());
		}
		
		assertEquals(true, p.get(0).getId() != null);
	}
}
