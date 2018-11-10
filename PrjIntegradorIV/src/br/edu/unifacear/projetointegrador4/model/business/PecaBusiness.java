package br.edu.unifacear.projetointegrador4.model.business;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacear.projetointegrador4.model.dao.FabricaDAO;
import br.edu.unifacear.projetointegrador4.model.entity.Aplicacao;
import br.edu.unifacear.projetointegrador4.model.entity.Modelo;
import br.edu.unifacear.projetointegrador4.model.entity.Peca;
import br.edu.unifacear.projetointegrador4.model.entity.Peca_Modelo;

public class PecaBusiness {
	public void inserir(Peca p) throws BusinessException {
		
		List<Peca> lp = FabricaDAO.criarPecaDAO().obter(p.getDescricao());
		
		p.setStatus(true);
		
		if(p.getDescricao() == null) {
			throw new BusinessException("Erro: Necessário informar descrição");
		} else {
			
			if(lp.size() < 1) {
				FabricaDAO.criarPecaDAO().inserir(p);
			} else {
				
				for(int i = 0; i < lp.size(); i++) {
					if(p.getDescricao().equals(lp.get(i).getDescricao())) {
						throw new BusinessException("Peça já cadastrada!");
						
					} else {
						FabricaDAO.criarPecaDAO().inserir(p);
					}
				}
			}
		}
	}
	
	public void atualizar(Peca p) {
		
		FabricaDAO.criarPecaDAO().atualizar(p);
	}
	
	public List<Peca> listar() {
		
		return FabricaDAO.criarPecaDAO().listar();
	}
	
	public List<Peca> listar(Boolean status) {
		List<Peca> retorno = new ArrayList<Peca>();
		List<Peca> lista = FabricaDAO.criarPecaDAO().listar();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getStatus() == status) {
				retorno.add(lista.get(i));
			}
		}
		
		return retorno;
	}
	
	public Peca obter(Long id) throws BusinessException {
		Peca p = new Peca();
		
		if(id == null) {
			p = null;
			throw new BusinessException("Erro: Necessário informar código.");
		} else {
			p = FabricaDAO.criarPecaDAO().obter(Peca.class, id);
		}
		
		return p;
	}
	
	public List<Peca> obter(String descricao) throws BusinessException {
		
		List<Peca> lp = new ArrayList<Peca>();
		
		if (descricao == null) {
			lp = null;
			throw new BusinessException("Erro: Necessário informar descrição.");
		} else {
			lp = FabricaDAO.criarPecaDAO().obter(descricao);
		} 
		
		return lp;
	}
	
	public List<Peca> obter(String descricao, Boolean status) throws BusinessException {
		List<Peca> retorno = new ArrayList<Peca>();
		List<Peca> lista = FabricaDAO.criarPecaDAO().obter(descricao);
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getStatus() == status) {
				retorno.add(lista.get(i));
			}
		}
		
		return retorno;
	}
	
	public List<Peca> obter(Modelo m) throws BusinessException{
		List<Peca> lp = new ArrayList<Peca>();
		
		if(m == null) {
			lp =null;
			throw new BusinessException("Erro: Necessário informar o modelo.");
		}else {
			lp = FabricaDAO.criarPecaDAO().obter(m);
		}
		return lp;
	}
	
	
	@SuppressWarnings("unlikely-arg-type")
	public List<Peca> filtrar(Object...obj) throws BusinessException{
		List<Peca> retorno = new ArrayList<Peca>();
		List<Peca> lista = FabricaDAO.criarPecaDAO().listar();
		List<Peca_Modelo> listapm = FabricaDAO.criarPeca_ModeloDAO().listar();
		Peca_Modelo pm = new Peca_Modelo();
		Modelo m = new Modelo();
		Aplicacao a = new Aplicacao();
		String desc = "";
		Boolean status = null;
		int aux = 0;
		
		System.out.println("lista do BD: " + lista.size());
		
		
		
		for(int i = 0; i < obj.length; i++) {
			if(obj[i] instanceof String) {
				desc = (String) obj[i];
				aux = aux + 1;
			}
			
			if(obj[i] instanceof Modelo) {
				m = (Modelo) obj[i];
				aux = aux + 2;
			}
			
			if(obj[i] instanceof Aplicacao) {
				a = (Aplicacao) obj[i];
				aux = aux + 4;
			}
			
			if(obj[i] instanceof Boolean) {
				status = (Boolean) obj[i];
				aux = aux + 8;
			}
		}
		
		if(aux == 1) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getDescricao().equalsIgnoreCase(desc)) {
					retorno.add(lista.get(i));
				} 
			}
			
			if(retorno.size() < 1) {
				throw new BusinessException("Desculpe, mas não encontramos :(");
			}
		}
		
		if(aux == 2) {
			
			for(int i = 0; i < listapm.size(); i++) {
				if(listapm.get(i).getModelo().getId() == m.getId()) {
					for(int j = 0; j < lista.size(); j++) {
						if(listapm.get(i).getPeca().getId() == lista.get(j).getId()) {
							retorno.add(lista.get(j));
						}
					}
				}
			}
			
			if(retorno.size() < 1) {
				throw new BusinessException("Desculpe, mas não encontramos :(");
			}
		}
		
		if(aux == 3) {
			for(int i = 0; i < listapm.size(); i++) {
				if(listapm.get(i).getModelo().getId() == m.getId()) {
					for(int j = 0; j < lista.size(); j++) {
						if(listapm.get(i).getPeca().getId() == lista.get(j).getId() &&
							lista.get(j).getDescricao().equalsIgnoreCase(desc)) {
						retorno.add(lista.get(j));
						}
					}
				}
			}
			
			if(retorno.size() < 1) {
				throw new BusinessException("Desculpe, mas não encontramos :(");
			}
		}
		
		if(aux == 4) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getAplicacao().getId() == a.getId()) {
					retorno.add(lista.get(i));
				}
			}
			
			if(retorno.size() < 1) {
				throw new BusinessException("Desculpe, mas não encontramos :(");
			}
		}
		
		if(aux == 5) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getAplicacao().getId() == a.getId() &&
						lista.get(i).getDescricao().equalsIgnoreCase(desc)) {
					retorno.add(lista.get(i));
				}
			}
			
			if(retorno.size() < 1) {
				throw new BusinessException("Desculpe, mas não encontramos :(");
			}
		}
		
		if(aux == 6) {
			for(int i = 0; i < listapm.size(); i++) {
				if(listapm.get(i).getModelo().getId() == m.getId()) {
					for(int j = 0; j < lista.size(); j++) {
						if(listapm.get(i).getPeca().getId() == lista.get(j).getId() &&
							lista.get(j).getAplicacao().getId() == a.getId()) {
						retorno.add(lista.get(j));
						}
					}
				}
			}
			
			if(retorno.size() < 1) {
				throw new BusinessException("Desculpe, mas não encontramos :(");
			}
		}
		
		if(aux == 7) {
			for(int i = 0; i < listapm.size(); i++) {
				if(listapm.get(i).getModelo().getId() == m.getId()) {
					for(int j = 0; j < lista.size(); j++) {
						if(listapm.get(i).getPeca().getId() == lista.get(j).getId() &&
							lista.get(j).getAplicacao().getId() == a.getId() &&
							lista.get(j).getDescricao().equalsIgnoreCase(desc)) {
							retorno.add(lista.get(j));
						}
					}
				}
			}
			
			if(retorno.size() < 1) {
				throw new BusinessException("Desculpe, mas não encontramos :(");
			}
		}
		
		if(aux == 8) {
			for(int i = 0; i < lista.size(); i ++) {
				if(lista.get(i).getStatus() == status) {
					retorno.add(lista.get(i));
				}
			}
			
			if(retorno.size() < 1) {
				throw new BusinessException("Desculpe, mas não encontramos :(");
			}
		}
		
		if(aux == 9) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getDescricao().equalsIgnoreCase(desc) &&
						lista.get(i).getStatus() == status) {
					retorno.add(lista.get(i));
				}
			}
			
			if(retorno.size() < 1) {
				throw new BusinessException("Desculpe, mas não encontramos :(");
			}
		}
		
		if(aux == 10) {
			for(int i = 0; i < listapm.size(); i++) {
				if(listapm.get(i).getModelo().getId() == m.getId()) {
					for(int j = 0; j < lista.size(); j++) {
						if(listapm.get(i).getPeca().getId() == lista.get(j).getId() &&
							lista.get(j).getStatus() == status) {
							retorno.add(lista.get(j));
						}
					}
				}
			}
			
			if(retorno.size() < 1) {
				throw new BusinessException("Desculpe, mas não encontramos :(");
			}
		}
		
		if(aux == 11) {
			for(int i = 0; i < listapm.size(); i++) {
				if(listapm.get(i).getModelo().getId() == m.getId()) {
					for(int j = 0; j < lista.size(); j++) {
						if(listapm.get(i).getPeca().getId() == lista.get(j).getId() &&
								lista.get(j).getDescricao().equalsIgnoreCase(desc) &&
								lista.get(j).getStatus() == status) {
							retorno.add(lista.get(j));
						}
					}
				}
			}
			
			if(retorno.size() < 1) {
				throw new BusinessException("Desculpe, mas não encontramos :(");
			}
		}
		
		if(aux == 12) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getAplicacao().getId() == a.getId() &&
						lista.get(i).getStatus() == status) {
					retorno.add(lista.get(i));
				}
			}
			
			if(retorno.size() < 1) {
				throw new BusinessException("Desculpe, mas não encontramos :(");
			}
		}
		
		if(aux == 13) {
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getDescricao().equalsIgnoreCase(desc) &&
						lista.get(i).getAplicacao().getId() == a.getId() &&
						lista.get(i).getStatus() == status) {
					retorno.add(lista.get(i));
				}
			}
			
			if(retorno.size() < 1) {
				throw new BusinessException("Desculpe, mas não encontramos :(");
			}
		}
		
		if(aux == 14) {
			for(int i = 0; i < listapm.size(); i++) {
				if(listapm.get(i).getModelo().getId() == m.getId()) {
					for(int j = 0; j < lista.size(); j++) {
						if(listapm.get(i).getPeca().getId() == lista.get(j).getId() &&
								lista.get(j).getAplicacao().getId() == a.getId() &&
								lista.get(j).getStatus() == status) {
							retorno.add(lista.get(j));
						}
					}
				}
			}
			
			if(retorno.size() < 1) {
				throw new BusinessException("Desculpe, mas não encontramos :(");
			}
		}
		
		if(aux == 15) {
			for(int i = 0; i < listapm.size(); i++) {
				if(listapm.get(i).getModelo().getId() == m.getId()) {
					for(int j = 0; j < lista.size(); j++) {
						if(listapm.get(i).getPeca().getId() == lista.get(j).getId() &&
								lista.get(j).getDescricao().equalsIgnoreCase(desc) &&
								lista.get(j).getAplicacao().getId() == a.getId() &&
								lista.get(j).getStatus() == status) {
							retorno.add(lista.get(j));
						}
					}
				}
			}
			if(retorno.size() < 1) {
				throw new BusinessException("Desculpe, mas não encontramos :(");
			}
		}
		
		
		System.out.println("lista de retorno: " + retorno.size()+" ");
		return retorno;
	}
	
	public void excluir(Peca p) {
		
		FabricaDAO.criarPecaDAO().excluir(p);
	}

	public void reativar(Peca p) {
		p.setStatus(true);
		
		FabricaDAO.criarPecaDAO().atualizar(p);
	}
}
