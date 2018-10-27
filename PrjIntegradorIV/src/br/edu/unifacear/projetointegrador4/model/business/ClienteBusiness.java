package br.edu.unifacear.projetointegrador4.model.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.model.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.model.entity.Cliente;
import br.edu.unifacear.projetointegrador4.model.entity.TipoCliente;

public class ClienteBusiness {
	
public void inserir(Cliente c) throws BusinessException {
		
		
		List<Cliente> lc = FabricaDAO.criarClienteDAO().listar();
		
		c.setStatus(true);
		
		if(c.getNome() == null) {
			throw new BusinessException("Erro: Necessário informar descrição");
		} else if (c.getCpf() == null) {
			throw new BusinessException("Erro: Necessário informar CPF.");
		} else if(c.getTelefone().size() < 1) {
			throw new BusinessException("Erro: Necessário informar pelo menos um telefone.");
		} else if(c.getSenha() == null) {
			throw new BusinessException("Erro: Necessário informar uma senha.");
		} else {
			
			if(lc.size() < 1) {
				FabricaDAO.criarClienteDAO().inserir(c);
			} else {
				
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
	
	public List<Cliente> listar(Boolean status) {
		
		List<Cliente> lista = FabricaDAO.criarClienteDAO().listar();
		List<Cliente> retorno = new ArrayList<Cliente>();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getStatus() == status) {
				retorno.add(lista.get(i));
			}
		}
		
		return retorno;
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
	
	public Cliente obterPorCpf(String cpf) throws BusinessException {
		
		List<Cliente> lista = FabricaDAO.criarClienteDAO().listar();
		Cliente c = new Cliente();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCpf().equals(cpf)) {
				c = lista.get(i);
				break;
			}
		}
		
		if(c.getNome().equals(null)) {
			throw new BusinessException("Cliente não encontrado.");
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
		
		if(lc.size() < 1) {
			throw new BusinessException("Cliente não encontrado.");
		}
		
		return lc;
	}
	
	public List<Cliente> obter(String nome, Boolean status) throws BusinessException {
		
		List<Cliente> lc = new ArrayList<Cliente>();
		List<Cliente> retorno = new ArrayList<Cliente>();
		
		if (nome == null) {
			lc = null;
			throw new BusinessException("Erro: Necessário informar nome.");
		} else {
			lc = FabricaDAO.criarClienteDAO().obter(nome);
			
			for(int i = 0; i < lc.size(); i++) {
				if(lc.get(i).getStatus() == status) {
					retorno.add(lc.get(i));
				}
			}
		} 
		
		if(retorno.size() < 1) {
			throw new BusinessException("Cliente não encontrado.");
		}
		
		return retorno;
	}
	
	public List<Cliente> obter(TipoCliente tipo) throws BusinessException {
		
		List<Cliente> lista = FabricaDAO.criarClienteDAO().listar();
		List<Cliente> retorno = new ArrayList<Cliente>();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getTipo().equals(tipo)) {
				retorno.add(lista.get(i));
			}
		}
		
		if(retorno.size() < 1) {
			throw new BusinessException("Não há clientes do tipo: " + tipo.getDescricao());
		}
		
		return retorno;
	}
	
	public List<Cliente> obter(TipoCliente tipo, Boolean status) throws BusinessException {
		
		List<Cliente> lista = FabricaDAO.criarClienteDAO().listar();
		List<Cliente> retorno = new ArrayList<Cliente>();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getTipo().equals(tipo) && lista.get(i).getStatus() == status) {
				retorno.add(lista.get(i));
			}
		}
		
		if(retorno.size() < 1 && status == true) {
			throw new BusinessException("Não há clientes ativos do tipo: " + tipo.getDescricao());
		} else if(retorno.size() < 1 && status == false) {
			throw new BusinessException("Não há cliente inativos do tipo: " + tipo.getDescricao());
		}
		
		return retorno;
	}
	
	public void excluir(Cliente c) {
		
		FabricaDAO.criarClienteDAO().excluir(c);
	}
	
	public void reativar(Cliente c) {
		c.setStatus(true);
		
		FabricaDAO.criarClienteDAO().atualizar(c);
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
