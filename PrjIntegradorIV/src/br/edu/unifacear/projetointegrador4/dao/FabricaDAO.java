package br.edu.unifacear.projetointegrador4.dao;

public class FabricaDAO {

	public static AplicacaoDAO criarAplicacaoDAO() {
		return new AplicacaoDAO();
	}
	
	public static FabricanteDAO criarFabricanteDAO() {
		return new FabricanteDAO();
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
}
