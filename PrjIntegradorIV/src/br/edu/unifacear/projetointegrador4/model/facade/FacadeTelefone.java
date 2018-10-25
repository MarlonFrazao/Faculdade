package br.edu.unifacear.projetointegrador4.model.facade;

import java.util.List;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.business.TelefoneBusiness;
import br.edu.unifacear.projetointegrador4.model.entity.Cliente;
import br.edu.unifacear.projetointegrador4.model.entity.Telefone;

public class FacadeTelefone {
	
	public void inserirTelefone (Telefone tel) throws BusinessException {
		new TelefoneBusiness().inserir(tel);
		
	}
	public void atualizarTelefone(Telefone tel) throws BusinessException{
		new TelefoneBusiness().atualizar(tel);
	}
	public List<Telefone> obterTelefoneCpf(Cliente cli) throws BusinessException{		
		return new TelefoneBusiness().listar(cli);
	}
	public List<Telefone> listarTelefone(){
		return new TelefoneBusiness().listar();
	}
	public void excluirTelefone(Telefone t) throws BusinessException{
		new TelefoneBusiness().excluir(t);
	}
}
