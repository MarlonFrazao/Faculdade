package br.edu.unifacear.projetointegrador4.model.dao;

public class FabricaDAO {

	public static AplicacaoDAO criarAplicacaoDAO() {
		return new AplicacaoDAO();
	}
	
	public static LinhaDeVeiculoDAO criarLinhaDeVeiculoDAO() {
		return new LinhaDeVeiculoDAO();
	}
	
	public static ModeloDAO criarModeloDAO() {
		return new ModeloDAO();
	}
	
	public static MontadoraDAO criarMontadoraDAO() {
		return new MontadoraDAO();
	}
	
	public static PecaDAO criarPecaDAO() {
		return new PecaDAO();
	}
	
	public static FuncionarioDAO criarFuncionarioDAO() {
		
		return new FuncionarioDAO();
	}
	
	public static PedidoDeVendaDAO criarPedidoDeVendaDAO() {
		return new PedidoDeVendaDAO();
	}
	
	public static StatusPVDAO criarStatusPVDAO() {
		return new StatusPVDAO();
	}
	
	public static TipoClienteDAO criarTipoClienteDAO() {
		return new TipoClienteDAO();
	}
	
	public static CargoDAO criarCargoDAO() {
		return new CargoDAO();
	}
	public static ClienteDAO criarClienteDAO() {
		return new ClienteDAO();
	}

	public static TelefoneDAO criarTelefoneDAO() {		
		return new TelefoneDAO();
	}
	
	public static Peca_ModeloDAO criarPeca_ModeloDAO() {
		return new Peca_ModeloDAO();
	}
}
