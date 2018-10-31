package br.edu.unifacear.projetointegrador4.model.business;

import java.util.List;

import br.edu.unifacear.projetointegrador4.model.entity.Aplicacao;
import br.edu.unifacear.projetointegrador4.model.entity.Cargo;
import br.edu.unifacear.projetointegrador4.model.entity.Cliente;
import br.edu.unifacear.projetointegrador4.model.entity.Funcionario;
import br.edu.unifacear.projetointegrador4.model.entity.LinhaDeVeiculo;
import br.edu.unifacear.projetointegrador4.model.entity.Modelo;
import br.edu.unifacear.projetointegrador4.model.entity.Montadora;
import br.edu.unifacear.projetointegrador4.model.entity.Peca;
import br.edu.unifacear.projetointegrador4.model.entity.PedidoDeVenda;
import br.edu.unifacear.projetointegrador4.model.entity.StatusPV;
import br.edu.unifacear.projetointegrador4.model.entity.Telefone;
import br.edu.unifacear.projetointegrador4.model.entity.TipoCliente;

public class FacadeBusiness {

	// Aplicação
	public void inserirAplicacao(Aplicacao a) throws BusinessException {
		new AplicacaoBusiness().inserir(a);
	}

	public void atualizarAplicacao(Aplicacao a) throws BusinessException {
		new AplicacaoBusiness().atualizar(a);
	}

	public List<Aplicacao> listarAplicacao() throws BusinessException {
		return new AplicacaoBusiness().listar();
	}
	
	public List<Aplicacao> listarAplicacao(Boolean status) throws BusinessException {
		return new AplicacaoBusiness().listar(status);
	}

	public Aplicacao obterAplicacao(Long id) throws BusinessException {
		return new AplicacaoBusiness().obter(id);
	}

	public List<Aplicacao> obterAplicacao(String descricao) throws BusinessException {
		return new AplicacaoBusiness().obter(descricao);
	}
	
	public List<Aplicacao> obterAplicacao(String descricao, Boolean status) throws BusinessException {
		return new AplicacaoBusiness().obter(descricao, status);
	}

	public void excluirAplicacao(Aplicacao a) {
		new AplicacaoBusiness().excluir(a);
	}
	
	public void reativarAplicacao(Aplicacao a) {
		new AplicacaoBusiness().reativar(a);
	}

	// Linha de Veículo
	public void inserirLinhaDeVeiculo(LinhaDeVeiculo ldv) throws BusinessException {
		new LinhaDeVeiculoBusiness().inserir(ldv);
	}

	public void atualizarLinhaDeVeiculo(LinhaDeVeiculo ldv) throws BusinessException {
		new LinhaDeVeiculoBusiness().atualizar(ldv);
	}

	public List<LinhaDeVeiculo> listarLinhaDeVeiculo() {
		return new LinhaDeVeiculoBusiness().listar();
	}

	public LinhaDeVeiculo obterLinhaDeVeiculo(Long id) throws BusinessException {
		return new LinhaDeVeiculoBusiness().obter(id);
	}

	public List<LinhaDeVeiculo> obterLinhaDeVeiculo(String descricao) throws BusinessException {
		return new LinhaDeVeiculoBusiness().obter(descricao);
	}

	public void excluirLinhaDeVeiculo(LinhaDeVeiculo ldv) throws BusinessException {
		new LinhaDeVeiculoBusiness().excluir(ldv);
	}

	// Montadora
	public void inserirMontadora(Montadora m) throws BusinessException {
		new MontadoraBusiness().inserir(m);
	}

	public void atualizarMontadora(Montadora m) throws BusinessException {
		new MontadoraBusiness().atualizar(m);
	}

	public List<Montadora> listarMontadora() throws BusinessException{
		return new MontadoraBusiness().listar();
	}

	public Montadora obterMontadora(Long id) throws BusinessException {
		return new MontadoraBusiness().obter(id);
	}

	public List<Montadora> obterMontadora(String descricao) throws BusinessException {
		return new MontadoraBusiness().obter(descricao);
	}

	public void excluirMontadora(Montadora m) throws BusinessException {
		new MontadoraBusiness().excluir(m);
	}

	// Cargo
	public void inserirCargo(Cargo c) throws BusinessException {
		new CargoBusiness().inserir(c);
	}

	public void atualizarCargo(Cargo c) throws BusinessException {
		new CargoBusiness().atualizar(c);
	}

	public List<Cargo> listarCargo() {
		return new CargoBusiness().listar();
	}

	public Cargo obterCargo(Long id) throws BusinessException {
		return new CargoBusiness().obter(id);
	}

	public List<Cargo> obterCargo(String descricao) throws BusinessException {
		return new CargoBusiness().obter(descricao);
	}

	public void excluirCargo(Cargo c) throws BusinessException {
		new CargoBusiness().excluir(c);
	}

	// StatusPV
	public void inserirStatusPV(StatusPV s) throws BusinessException {
		new StatusPVBusiness().inserir(s);
	}

	public void atualizarStatusPV(StatusPV s) throws BusinessException {
		new StatusPVBusiness().atualizar(s);
	}

	public List<StatusPV> listarStatusPV() {
		return new StatusPVBusiness().listar();
	}

	public StatusPV obterStatusPV(Long id) throws BusinessException {
		return new StatusPVBusiness().obter(id);
	}

	public List<StatusPV> obterStatusPV(String descricao) throws BusinessException {
		return new StatusPVBusiness().obter(descricao);
	}

	public void excluirStatusPV(StatusPV s) throws BusinessException {
		new StatusPVBusiness().excluir(s);
	}

	// TipoCliente
	public void inserirTipoCliente(TipoCliente tc) throws BusinessException {
		new TipoClienteBusiness().inserir(tc);
	}

	public void atualizarTipoCliente(TipoCliente tc) throws BusinessException {
		new TipoClienteBusiness().atualizar(tc);
	}

	public List<TipoCliente> listarTipoCliente() {
		return new TipoClienteBusiness().listar();
	}

	public TipoCliente obterTipoCliente(Long id) throws BusinessException {
		return new TipoClienteBusiness().obter(id);
	}

	public List<TipoCliente> obterTipoCliente(String descricao) throws BusinessException {
		return new TipoClienteBusiness().obter(descricao);
	}

	public void excluirTipoCliente(TipoCliente tc) throws BusinessException {
		new TipoClienteBusiness().excluir(tc);
	}

	// Cliente
	public void inserirCliente(Cliente c) throws BusinessException {
		new ClienteBusiness().inserir(c);
	}

	public void atualizarCliente(Cliente c) throws BusinessException {
		new ClienteBusiness().atualizar(c);
	}

	public List<Cliente> listarCliente() {
		return new ClienteBusiness().listar();
	}

	public Cliente obterCliente(Long id) throws BusinessException {
		return new ClienteBusiness().obter(id);
	}

	public List<Cliente> obterCliente(String nome) throws BusinessException {
		return new ClienteBusiness().obter(nome);
	}

	public void excluirCliente(Cliente c) throws BusinessException {
		new ClienteBusiness().excluir(c);
	}

	// Funcionario
	public void inserirFuncionario(Funcionario f) throws BusinessException {
		new FuncionarioBusiness().inserir(f);
	}

	public void atualizarFuncionario(Funcionario f) throws BusinessException {
		new FuncionarioBusiness().atualizar(f);
	}

	public List<Funcionario> listarFuncionario() {
		return new FuncionarioBusiness().listar();
	}

	public Funcionario obterFuncionario(Long id) throws BusinessException {
		return new FuncionarioBusiness().obter(id);
	}

	public List<Funcionario> obterFuncionario(String nome) throws BusinessException {
		return new FuncionarioBusiness().obter(nome);
	}

	public void excluirFuncionario(Funcionario f) throws BusinessException {
		new FuncionarioBusiness().excluir(f);
	}

	// Modelo
	public void inserirModelo(Modelo m) throws BusinessException {
		new ModeloBusiness().inserir(m);
	}

	public void atualizarModelo(Modelo m) throws BusinessException {
		new ModeloBusiness().atualizar(m);
	}

	public List<Modelo> listarModelo() throws BusinessException{
		return new ModeloBusiness().listar();
	}

	public Modelo obterModelo(Long id) throws BusinessException {
		return new ModeloBusiness().obter(id);
	}

	public List<Modelo> obterModelo(String descricao) throws BusinessException {
		return new ModeloBusiness().obter(descricao);
	}

	public void excluirModelo(Modelo m) throws BusinessException {
		new ModeloBusiness().excluir(m);
	}
	public List<Modelo> obterModeloPeca(Long id_peca) throws BusinessException{
		return new ModeloBusiness().obterPeca(id_peca);
	}

	// Peca
	public void inserirPeca(Peca p) throws BusinessException {
		new PecaBusiness().inserir(p);
	}

	public void atualizarPeca(Peca p) throws BusinessException {
		new PecaBusiness().atualizar(p);
	}

	public List<Peca> listarPeca() throws BusinessException {
		return new PecaBusiness().listar();
	}

	public Peca obterPeca(Long id) throws BusinessException {
		return new PecaBusiness().obter(id);
	}

	public List<Peca> obterPeca(String descricao) throws BusinessException {
		return new PecaBusiness().obter(descricao);
	}
	
	public List<Peca> obterPecaModelo(Modelo m) throws BusinessException{
		return new PecaBusiness().obter(m);
	}

	public void excluirPeca(Peca p) throws BusinessException {
		new PecaBusiness().excluir(p);
	}

	// Pedido De Venda
	public void inserirPedidoDeVenda(PedidoDeVenda pdv) throws BusinessException {
		new PedidoDeVendaBusiness().inserir(pdv);
	}

	public void atualizarPedidoDeVenda(PedidoDeVenda pdv) throws BusinessException {
		new PedidoDeVendaBusiness().atualizar(pdv);
	}

	public List<PedidoDeVenda> listarPedidoDeVenda() {
		return new PedidoDeVendaBusiness().listar();
	}

	public PedidoDeVenda obterPedidoDeVenda(Long id) throws BusinessException {
		return new PedidoDeVendaBusiness().obter(id);
	}

	public List<PedidoDeVenda> obterPedidoDeCliente(Long id_cliente) throws BusinessException {
		return new PedidoDeVendaBusiness().obterCliente(id_cliente);
	}

	public void excluirPedidoDeVenda(PedidoDeVenda pdv) throws BusinessException {
		new PedidoDeVendaBusiness().excluir(pdv);
	}
	
	//Telefone
	
	public void inserirTelefone () throws BusinessException {
		new TelefoneBusiness().inserir(null);
		
	}
	public void atualizarTelefone(Telefone tel) throws BusinessException{
		new TelefoneBusiness().atualizar(tel);
	}
	public List<Telefone> listarTelefone(){
		return new TelefoneBusiness().listar();
	}
	public void excluirTelefone(Telefone t) throws BusinessException{
		new TelefoneBusiness().excluir(t);
	}

}
