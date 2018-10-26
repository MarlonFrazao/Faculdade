package br.edu.unifacear.projetointegrador4.model.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.model.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.model.entity.Cliente;

public class ClienteBusiness {
	
public void inserir(Cliente c) throws BusinessException {
		
		//busca as aplicações cadastradas para verificação
		List<Cliente> lc = FabricaDAO.criarClienteDAO().obter(c.getNome());
		
		c.setStatus(true);
		
		if(c.getNome() == null) {
			throw new BusinessException("Erro: Necessário informar descrição");
		} else {
			//verifica se há cadastro no banco de dados, se não há, insere o objeto
			if(lc.size() < 1) {
				FabricaDAO.criarClienteDAO().inserir(c);
			} else {
				//verifica se já existe objeto com a mesma descricao
				for(int i = 0; i < lc.size(); i++) {
					if(c.getCpf().equals(lc.get(i).getCpf())) {
						throw new BusinessException("Cliente já cadastrado(a)!");
						
					} else {
						FabricaDAO.criarClienteDAO().inserir(c);
					}
				}
			}
		}
	}
	
	public void atualizar(Cliente c) {
		
		FabricaDAO.criarClienteDAO().atualizar(c);
	}
	
	public List<Cliente> listar() {
		
		return FabricaDAO.criarClienteDAO().listar();
	}
	
	public Cliente obter(Long id) throws BusinessException {
		Cliente c = new Cliente();
		
		if(id == null) {
			c = null;
			throw new BusinessException("Erro: Necessário informar código.");
		} else {
			c = FabricaDAO.criarClienteDAO().obter(Cliente.class, id);
		}
		
		return c;
	}
	
	public List<Cliente> obter(String nome) throws BusinessException {
		
		List<Cliente> lc = new ArrayList<Cliente>();
		
		if (nome == null) {
			lc = null;
			throw new BusinessException("Erro: Necessário informar nome.");
		} else {
			lc = FabricaDAO.criarClienteDAO().obter(nome);
		} 
		
		return lc;
	}
	
	public void excluir(Cliente c) {
		
		FabricaDAO.criarClienteDAO().excluir(c);
	}

	public List<Cliente> obter(String cpf, Long senha) throws BusinessException  {
		List<Cliente> cliente = new ArrayList<Cliente>();
		if(cpf == null) {
			throw new BusinessException("Erro: Necessário informar CPF."); 
		}else if(senha == null) {
			throw new BusinessException("Erro: Necessário informar SENHA."); 
		}else {
			cliente = FabricaDAO.criarClienteDAO().obter(cpf, senha);
		}
		return cliente;
	}

}
