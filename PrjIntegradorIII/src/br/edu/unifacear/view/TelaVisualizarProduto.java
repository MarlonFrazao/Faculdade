package br.edu.unifacear.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.unifacear.model.Categoria;
import br.edu.unifacear.model.Colecao;
import br.edu.unifacear.model.Cor;
import br.edu.unifacear.model.Genero;
import br.edu.unifacear.model.Produto;
import br.edu.unifacear.model.Situacao;
import br.edu.unifacear.model.Tamanho;
import br.edu.unifacear.model.Unidade;
import br.edu.unifacear.session.CategoriaSession;
import br.edu.unifacear.session.ColecaoSession;
import br.edu.unifacear.session.CorSession;
import br.edu.unifacear.session.GeneroSession;
import br.edu.unifacear.session.ProdutoSession;
import br.edu.unifacear.session.SituacaoSession;
import br.edu.unifacear.session.TamanhoSession;
import br.edu.unifacear.session.UnidadeSession;
import br.edu.unifacear.util.JNumberFormatField;

public class TelaVisualizarProduto extends JFrame implements ActionListener{
		private static Produto prod;
		private JButton btnSair,btnExcluirPro, btnRelatorio, btnVoltar, btnCadastrarFuncionario, btnConsultarFuncionario,
				btnCadastrarProduto, btnConsultarProduto, btnEntradaProduto, btnSaidaProduto, btnNovoTamanho,
				btnNovaCategoria, btnNovaUnidade, btnNovaCor, btnNovoGenero, btnNovaColecao, btnSalvar;
		private JLabel lblHome, lblFuncionario, lblEstoque, lblCodProduto, lblVolume1, lblPeso1, lblAtivo;
		private JFrame pnlPrincipal;
		private JTextField txtCodProduto;
		private static JTextField txtAtivo;
		private JTextField txtNomeProduto;
		private JTextField txtPeso;
		private JTextField txtVolume;
		private JNumberFormatField txtValorUn;
		private JTextField txtNumPontos;
		private JTextField txtQtdaMax;
		private JTextField txtQtdaMin;
		private JTextField cmbUni;
		
		private JTextField cmbCol;
		private JTextField cmbCat;
		private JTextField cmbGen;
		private JTextField cmbCor;
		private JTextField cmbTam;
		private JTextField cmbSituacao, cmbVolume, cmbPeso;
		private JLabel lblQuantidade;
		private JTextField txtQtda;
	public TelaVisualizarProduto(Produto pro) {
		
		super("Visualizar Produto");
		prod = new Produto();
		prod = pro;
		pnlPrincipal = new JFrame("Loja Lupo - Estoque - Visualizar Produto");
		pnlPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pnlPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pnlPrincipal.setLocationRelativeTo(null);
		pnlPrincipal.setResizable(true);
		pnlPrincipal.getContentPane().setLayout(null);
		
		lblHome = new JLabel("Visualizar Produto");
		lblHome.setBounds(807, 47, 480, 30);
		lblHome.setForeground(Color.BLACK);
		lblHome.setFont(new Font("Arial", Font.BOLD, 36));
		pnlPrincipal.getContentPane().add(lblHome);
		
		lblFuncionario = new JLabel("Funcionários");
		lblFuncionario.setBounds(50, 100, 250, 23);
		lblFuncionario.setForeground(Color.BLACK);
		lblFuncionario.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		pnlPrincipal.getContentPane().add(lblFuncionario);
		
		lblEstoque = new JLabel("Estoque");
		lblEstoque.setBounds(50, 250, 250, 23);
		lblEstoque.setForeground(Color.black);
		lblEstoque.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		pnlPrincipal.getContentPane().add(lblEstoque);

		btnCadastrarFuncionario = new JButton("Cadastrar Funcionário");
		btnCadastrarFuncionario.setBounds(50, 150, 250, 23);
		btnCadastrarFuncionario.addActionListener(this);
		btnCadastrarFuncionario.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		pnlPrincipal.getContentPane().add(btnCadastrarFuncionario);

		btnConsultarFuncionario = new JButton("Consultar Funcionário");
		btnConsultarFuncionario.setBounds(50, 200, 250, 23);
		btnConsultarFuncionario.addActionListener(this);
		btnConsultarFuncionario.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		pnlPrincipal.getContentPane().add(btnConsultarFuncionario);
		
		btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.setBounds(50, 300, 250, 23);
		btnCadastrarProduto.addActionListener(this);
		btnCadastrarProduto.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		pnlPrincipal.getContentPane().add(btnCadastrarProduto);
		
		btnConsultarProduto = new JButton("Consultar Produto");
		btnConsultarProduto.setBounds(50, 350, 250, 23);
		btnConsultarProduto.addActionListener(this);
		btnConsultarProduto.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		pnlPrincipal.getContentPane().add(btnConsultarProduto);
		
		btnEntradaProduto = new JButton("Registrar Entradas");
		btnEntradaProduto.setBounds(50, 400, 250, 23);
		btnEntradaProduto.addActionListener(this);
		btnEntradaProduto.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		pnlPrincipal.getContentPane().add(btnEntradaProduto);
		
		btnSaidaProduto = new JButton("Registrar Saídas");
		btnSaidaProduto.setBounds(50, 450, 250, 23);
		btnSaidaProduto.addActionListener(this);
		btnSaidaProduto.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		pnlPrincipal.getContentPane().add(btnSaidaProduto);

		btnSair = new JButton("Sair");
		btnSair.setBounds(1000, 600, 100, 23);
		btnSair.addActionListener(this);
		btnSair.setFont(new Font("Ariel", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		pnlPrincipal.getContentPane().add(btnSair);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(1150, 600, 100, 23);
		btnVoltar.addActionListener(this);
		
		btnVoltar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		pnlPrincipal.getContentPane().add(btnVoltar);
		
		lblCodProduto = new JLabel("Código do Produto:");
		lblCodProduto.setForeground(Color.black);
		lblCodProduto.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblCodProduto.setBounds(350, 150, 180, 23);
		pnlPrincipal.getContentPane().add(lblCodProduto);
		
		txtCodProduto = new JTextField();
		txtCodProduto.setFont(new Font("Arial", Font.PLAIN, 20));
		txtCodProduto.setBounds(525, 150, 222, 22);
		ProdutoSession ps = new ProdutoSession();
		txtCodProduto.setText(String.valueOf(pro.getId()));
		txtCodProduto.setEditable(false);
		pnlPrincipal.getContentPane().add(txtCodProduto);
		txtCodProduto.setColumns(10);
		
		JLabel lblNomeProduto = new JLabel("Nome do Produto:");
		lblNomeProduto.setForeground(Color.BLACK);
		lblNomeProduto.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNomeProduto.setBounds(350, 186, 180, 23);
		pnlPrincipal.getContentPane().add(lblNomeProduto);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setFont(new Font("Arial", Font.PLAIN, 20));
		txtNomeProduto.setColumns(10);
		txtNomeProduto.setText(pro.getNome());
		txtNomeProduto.setEditable(false);
		txtNomeProduto.setBounds(525, 186, 222, 22);
		pnlPrincipal.getContentPane().add(txtNomeProduto);
		
		JLabel lblCor = new JLabel(" Cor:");
		lblCor.setForeground(Color.BLACK);
		lblCor.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCor.setBounds(759, 150, 104, 23);
		pnlPrincipal.getContentPane().add(lblCor);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setForeground(Color.BLACK);
		lblTamanho.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTamanho.setBounds(759, 189, 104, 23);
		pnlPrincipal.getContentPane().add(lblTamanho);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setForeground(Color.BLACK);
		lblCategoria.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCategoria.setBounds(759, 228, 104, 23);
		pnlPrincipal.getContentPane().add(lblCategoria);
		
		JLabel lblGenero = new JLabel("Gênero:");
		lblGenero.setForeground(Color.BLACK);
		lblGenero.setFont(new Font("Arial", Font.PLAIN, 20));
		lblGenero.setBounds(759, 264, 104, 23);
		pnlPrincipal.getContentPane().add(lblGenero);
		
		JLabel lblColecao = new JLabel("Coleção:");
		lblColecao.setForeground(Color.BLACK);
		lblColecao.setFont(new Font("Arial", Font.PLAIN, 20));
		lblColecao.setBounds(759, 300, 104, 23);
		pnlPrincipal.getContentPane().add(lblColecao);
		
		JLabel lblUnidade = new JLabel("Unidade:");
		lblUnidade.setForeground(Color.BLACK);
		lblUnidade.setFont(new Font("Arial", Font.PLAIN, 20));
		lblUnidade.setBounds(759, 336, 104, 23);
		pnlPrincipal.getContentPane().add(lblUnidade);
		
		JLabel lblVolume = new JLabel("Volume:");
		lblVolume.setForeground(Color.BLACK);
		lblVolume.setFont(new Font("Arial", Font.PLAIN, 20));
		lblVolume.setBounds(350, 222, 71, 23);
		pnlPrincipal.getContentPane().add(lblVolume);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setForeground(Color.BLACK);
		lblPeso.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPeso.setBounds(350, 258, 71, 23);
		pnlPrincipal.getContentPane().add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setFont(new Font("Arial", Font.PLAIN, 20));
		txtPeso.setColumns(10);
		txtPeso.setText(String.valueOf(pro.getPeso()));
		txtPeso.setEditable(false);
		txtPeso.setBounds(424, 258, 181, 22);
		pnlPrincipal.getContentPane().add(txtPeso);
		
		txtVolume = new JTextField();
		txtVolume.setFont(new Font("Arial", Font.PLAIN, 20));
		txtVolume.setColumns(10);
		txtVolume.setText(String.valueOf(pro.getVolume()));
		txtVolume.setEditable(false);
		txtVolume.setBounds(424, 222, 181, 22);
		pnlPrincipal.getContentPane().add(txtVolume);
		
		JLabel lblNumeroDePontos = new JLabel("Numero de Pontos:");
		lblNumeroDePontos.setForeground(Color.BLACK);
		lblNumeroDePontos.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNumeroDePontos.setBounds(350, 300, 180, 23);
		pnlPrincipal.getContentPane().add(lblNumeroDePontos);
		
		JLabel lblValorUnitario = new JLabel("Valor Unitário: R$ ");
		lblValorUnitario.setForeground(Color.BLACK);
		lblValorUnitario.setFont(new Font("Arial", Font.PLAIN, 20));
		lblValorUnitario.setBounds(350, 336, 180, 23);
		pnlPrincipal.getContentPane().add(lblValorUnitario);
		
		txtValorUn = new JNumberFormatField();
		txtValorUn.setFont(new Font("Arial", Font.PLAIN, 20));
		txtValorUn.setColumns(10);
		txtValorUn.setText(String.valueOf(pro.getValorUnitario()));
		txtValorUn.setEditable(false);
		txtValorUn.setBounds(525, 336, 107, 22);
		pnlPrincipal.getContentPane().add(txtValorUn);
		
		txtNumPontos = new JTextField();
		txtNumPontos.setFont(new Font("Arial", Font.PLAIN, 20));
		txtNumPontos.setColumns(10);
		txtNumPontos.setText(String.valueOf(pro.getNumPontos()));
		txtNumPontos.setEditable(false);
		txtNumPontos.setBounds(525, 300, 222, 22);
		pnlPrincipal.getContentPane().add(txtNumPontos);
		
		JLabel lblQtdaMax = new JLabel("Quantidade M\u00E1xima:");
		lblQtdaMax.setForeground(Color.BLACK);
		lblQtdaMax.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQtdaMax.setBounds(350, 372, 187, 23);
		pnlPrincipal.getContentPane().add(lblQtdaMax);
		
		txtQtdaMax = new JTextField();
		txtQtdaMax.setFont(new Font("Arial", Font.PLAIN, 20));
		txtQtdaMax.setColumns(10);
		txtQtdaMax.setText(String.valueOf(pro.getQtdeMax()));
		txtQtdaMax.setEditable(false);
		txtQtdaMax.setBounds(535, 371, 212, 22);
		pnlPrincipal.getContentPane().add(txtQtdaMax);
		
		JLabel lblQtdaMin = new JLabel("Quantidade M\u00EDnima:");
		lblQtdaMin.setForeground(Color.BLACK);
		lblQtdaMin.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQtdaMin.setBounds(759, 372, 180, 23);
		pnlPrincipal.getContentPane().add(lblQtdaMin);
		
		txtQtdaMin = new JTextField();
		txtQtdaMin.setFont(new Font("Arial", Font.PLAIN, 20));
		txtQtdaMin.setColumns(10);
		txtQtdaMin.setText(String.valueOf(pro.getQtdeMin()));
		txtQtdaMin.setEditable(false);
		txtQtdaMin.setBounds(944, 372, 156, 22);
		pnlPrincipal.getContentPane().add(txtQtdaMin);
		
		
		lblVolume1 = new JLabel("Cm³");
		lblVolume1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblVolume1.setBounds(620, 221, 127, 22);
	
		
		pnlPrincipal.getContentPane().add(lblVolume1);
		
		lblPeso1 = new JLabel("Gramas");
		lblPeso1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPeso1.setBounds(620, 258, 127, 22);
		
		
		pnlPrincipal.getContentPane().add(lblPeso1);
		
		
		cmbUni = new JTextField();
		cmbUni.setFont(new Font("Arial", Font.PLAIN, 16));
		cmbUni.setBounds(870, 336, 153, 22);
		
		UnidadeSession uni = new UnidadeSession();
		List<Unidade> listaUni = uni.obter();
		cmbUni.setText(pro.getUnidade().getNome());;
		cmbUni.setEditable(false);
		
		pnlPrincipal.getContentPane().add(cmbUni);
		
		cmbCol = new JTextField();
		cmbCol.setFont(new Font("Arial", Font.PLAIN, 16));
		cmbCol.setBounds(870, 300, 153, 22);
		cmbCol.setEditable(false);
		
		ColecaoSession col = new ColecaoSession();
		List<Colecao> listaCol = col.obter();
		cmbCol.setText(pro.getColecao().getNome());;
		
		
		pnlPrincipal.getContentPane().add(cmbCol);
		
		cmbCat = new JTextField();
		cmbCat.setFont(new Font("Arial", Font.PLAIN, 16));
		cmbCat.setBounds(870, 228, 153, 22);
		
		CategoriaSession cat = new CategoriaSession();
		List<Categoria> listaCat = cat.obter();
		cmbCat.setText(pro.getCategoria().getNome());
		cmbCat.setEditable(false);
		
		
		pnlPrincipal.getContentPane().add(cmbCat);
		
		cmbGen = new JTextField();
		cmbGen.setFont(new Font("Arial", Font.PLAIN, 16));
		cmbGen.setBounds(870, 264, 153, 22);
		
		GeneroSession gen = new GeneroSession();
		List<Genero> listaGen = gen.obter();
		cmbGen.setText(pro.getGenero().getNome());
		cmbGen.setEditable(false);
		
		
		pnlPrincipal.getContentPane().add(cmbGen);
		
		cmbCor = new JTextField();
		cmbCor.setFont(new Font("Arial", Font.PLAIN, 16));
		cmbCor.setBounds(870, 150, 153, 22);
		
		CorSession cor = new CorSession();
		List<Cor> listaCor = cor.obter();
		cmbCor.setText(pro.getCor().getNome());
		cmbCor.setEditable(false);
		
		
		
		
		pnlPrincipal.getContentPane().add(cmbCor);
		
		cmbTam = new JTextField();
		cmbTam.setFont(new Font("Arial", Font.PLAIN, 16));
		cmbTam.setBounds(870, 186, 153, 22);
		
		TamanhoSession tam = new TamanhoSession();
		List<Tamanho> listaTam = tam.obter();
		cmbTam.setText(pro.getTamanho().getNome());
		cmbTam.setEditable(false);
		
		
		pnlPrincipal.getContentPane().add(cmbTam);
		
		lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setForeground(Color.BLACK);
		lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQuantidade.setBounds(350, 408, 180, 23);
		pnlPrincipal.getContentPane().add(lblQuantidade);
		
		txtQtda = new JTextField();
		txtQtda.setFont(new Font("Arial", Font.PLAIN, 20));
		txtQtda.setColumns(10);
		txtQtda.setText(String.valueOf(pro.getQtde()));
		txtQtda.setEditable(false);
		txtQtda.setBounds(535, 408, 156, 22);
		pnlPrincipal.getContentPane().add(txtQtda);
		
		btnExcluirPro = new JButton("Desativar");
		btnExcluirPro.setForeground(Color.black);
		btnExcluirPro.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnExcluirPro.setBounds(759, 408, 130, 23);
		btnExcluirPro.addActionListener(this);
		pnlPrincipal.getContentPane().add(btnExcluirPro);
		
		
		
		
		btnSalvar = new JButton("Atualizar");
		btnSalvar.setForeground(Color.black);
		btnSalvar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnSalvar.setBounds(849, 601, 110, 23);
		btnSalvar.addActionListener(this);
		pnlPrincipal.getContentPane().add(btnSalvar);
		
		btnRelatorio = new JButton("Emitir Relatórios");
		btnRelatorio.addActionListener(this);
		btnRelatorio.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnRelatorio.setBounds(50, 500, 250, 23);
		pnlPrincipal.getContentPane().add(btnRelatorio);
		
		lblAtivo = new JLabel("Status: ");
		lblAtivo.setForeground(Color.BLACK);
		lblAtivo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAtivo.setBounds(350, 450, 180, 23);
		pnlPrincipal.getContentPane().add(lblAtivo);
		
		txtAtivo = new JTextField();
		txtAtivo.setFont(new Font("Arial", Font.PLAIN, 20));
		txtAtivo.setColumns(10);
		
		if(prod.isStatus()==true) {
			txtAtivo.setText("Ativo");
		}else {
			txtAtivo.setText("Inativo");
		}
		
		txtAtivo.setEditable(false);
		txtAtivo.setBounds(535, 450, 156, 22);
		pnlPrincipal.getContentPane().add(txtAtivo);
		

		pnlPrincipal.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnCadastrarFuncionario) {
			TelaCadastrarFuncionario tcf = new TelaCadastrarFuncionario();
			pnlPrincipal.dispose();
		}else 
			if(e.getSource() == btnConsultarFuncionario) {
				TelaConsultarFuncionario tcf = new TelaConsultarFuncionario();
				pnlPrincipal.dispose();
			} else
		if(e.getSource() == btnCadastrarProduto) {
			TelaCadastrarProduto tcp = new TelaCadastrarProduto();
			pnlPrincipal.dispose();
		} else
		
		if(e.getSource() == btnConsultarProduto) {
			TelaConsultarProduto tcp = new TelaConsultarProduto();
			pnlPrincipal.dispose();
		} else
			
		if(e.getSource() == btnEntradaProduto) {
			TelaRegistrarEntrada tre = new TelaRegistrarEntrada();
			pnlPrincipal.dispose();
		} else
		
		if(e.getSource() == btnSaidaProduto) {
			TelaRegistrarSaida trs = new TelaRegistrarSaida();
			pnlPrincipal.dispose();
		} else
		
		if (e.getSource() == btnVoltar) {
			TelaConsultarProduto tcp = new TelaConsultarProduto();
			pnlPrincipal.dispose();
		} else
		if (e.getSource() == btnSair) {
			pnlPrincipal.dispose();
		}else
		if(e.getSource()==btnSalvar) {
			
			TelaAtualizarProduto tap = new TelaAtualizarProduto(prod);
			pnlPrincipal.dispose();
			
		
		}else
		if (e.getSource() == btnExcluirPro ) {
			
			TelaExcluirPro tep = new TelaExcluirPro(prod);
			
		}else
		if(e.getSource() == btnNovaColecao) {
			
		}else
		if(e.getSource()== btnNovaCor) {
			
		}else
		if(e.getSource()==btnNovaUnidade) {
			
		}else
		if(e.getSource()== btnNovoGenero) {
			
		}else
		if(e.getSource()==btnNovoTamanho) {
			
		}else if (e.getSource()== btnRelatorio) {
			TelaRelatorio tr = new TelaRelatorio();
			pnlPrincipal.dispose();
		}
	}
	public static void refresh() {
		if(prod.isStatus()==true) {
			txtAtivo.setText("Ativo");
			txtAtivo.setEnabled(false);
		}else {
			txtAtivo.setText("Inativo");
			txtAtivo.setEnabled(false);
		}
	}

}
