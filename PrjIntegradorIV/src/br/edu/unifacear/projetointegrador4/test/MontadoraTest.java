package br.edu.unifacear.projetointegrador4.test;

import org.junit.Test;

import br.edu.unifacear.projetointegrador4.dao.MontadoraDAO;
import br.edu.unifacear.projetointegrador4.entity.Montadora;

public class MontadoraTest {
	
	@Test
	public void inserirMontadora() {
		
		Montadora m = new Montadora();
		m.setDescricao("teste");
		new MontadoraDAO().inserir(m);
		
		System.out.println(m.getId());
	}
}
