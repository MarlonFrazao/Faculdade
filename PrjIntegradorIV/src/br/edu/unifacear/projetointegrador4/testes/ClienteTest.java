package br.edu.unifacear.projetointegrador4.testes;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.model.dao.TipoClienteDAO;
import br.edu.unifacear.projetointegrador4.model.entity.Cliente;
import br.edu.unifacear.projetointegrador4.model.entity.Telefone;
import br.edu.unifacear.projetointegrador4.model.entity.TipoCliente;

public class ClienteTest {

	@Test
	public void testInserir() throws BusinessException {
		Cliente c = new Cliente();
		List<Cliente> lista = FabricaDAO.criarClienteDAO().obter(c.getCpf());

		List<Telefone> teleLista = new ArrayList<Telefone>();
		Telefone t = new Telefone();
		TipoClienteDAO tcDAO = new TipoClienteDAO();

		c.setCpf("1234567894");
		c.setEmail("yahoo@yahoo.com.br");
		c.setEndereco("rua da esquina 321");
		c.setNome("Zico");
		c.setStatus(true);
		c.setTipo(tcDAO.obter(TipoCliente.class, (long) 1));

		if (c.getCpf() == null) {
			throw new BusinessException("Erro: Necessário informar CPF");
		} else if (c.getEmail() == null) {
			throw new BusinessException("Erro: Necessário informar Email");
		} else if (c.getEndereco() == null) {
			throw new BusinessException("Erro: Necessário informar Endereço");
		} else if (c.getNome() == null) {
			throw new BusinessException("Erro: Necessário informar Nome");
		} else {
			if (lista == null || lista.size() < 1) {
				FabricaDAO.criarClienteDAO().inserir(c);
			} else {
				for (int i = 0; i < lista.size(); i++) {
					if (c.getCpf().equals(lista.get(i).getCpf())) {
						throw new BusinessException("CPF já cadastrada!");
					} else {
						FabricaDAO.criarClienteDAO().inserir(c);
					}

				}
			}
		}
		
		/*t.setCpf(c.getCpf());
		t.setTelefone((long) 12345678);
		t.setTipo("Celular");
		teleLista.add(t);
		t.setCpf(c.getCpf());
		t.setTelefone((long) 87654321);
		t.setTipo("Residencial");
		teleLista.add(t);
		c.setTelefone(teleLista);
*/
	}
	/*
	 * @Test public void testAtualizar() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testListar() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testObterLong() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testObterString() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testExcluir() { fail("Not yet implemented"); }
	 */
}
