package br.edu.unifacear.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import br.edu.unifacear.model.Categoria;
import br.edu.unifacear.model.Colecao;
import br.edu.unifacear.model.Cor;
import br.edu.unifacear.model.Entrada;
import br.edu.unifacear.model.Funcionario;
import br.edu.unifacear.model.Genero;
import br.edu.unifacear.model.Produto;
import br.edu.unifacear.model.Situacao;
import br.edu.unifacear.model.Tamanho;
import br.edu.unifacear.model.Unidade;
import br.edu.unifacear.session.CategoriaSession;
import br.edu.unifacear.session.ColecaoSession;
import br.edu.unifacear.session.CorSession;
import br.edu.unifacear.session.EntradaSession;
import br.edu.unifacear.session.FuncionarioSession;
import br.edu.unifacear.session.GeneroSession;
import br.edu.unifacear.session.ProdutoSession;
import br.edu.unifacear.session.SituacaoSession;
import br.edu.unifacear.session.TamanhoSession;
import br.edu.unifacear.session.UnidadeSession;
import br.edu.unifacear.util.ModeloTabela;
import br.edu.unifacear.util.Render;
import br.edu.unifacear.util.TabelaConsulta;
import br.edu.unifacear.util.TabelaEntrada;

public class TelaConsultarProduto extends JFrame implements ActionListener {
	
	private JButton btnSair,btnRelatorio , btnConfirmarRecebimento,btnBuscar , btnVoltar, btnCadastrarFuncionario, btnConsultarFuncionario, btnCadastrarProduto, btnConsultarProduto, btnEntradaProduto, btnSaidaProduto;
	private JLabel lblHome, lblFuncionario, lblEstoque, lblNumeroPedido;
	private static JFrame pnlPrincipal;
	private JTextField txtNomeProduto;
	private JTable resultBusca;
	private static TabelaConsulta modelo;
	private JScrollPane scroll;
	private JComboBox cmbUni;
	private JComboBox cmbCol;
	private JComboBox cmbCat;
	private JComboBox cmbGen;
	private JComboBox cmbCor;
	private JComboBox cmbTam;
	private JComboBox cmbSituacao, cmbVolume,cmbPeso;
	private Render btnVizualizar;
	
	
	public TelaConsultarProduto() {
		super("Menu");

		pnlPrincipal = new JFrame("Loja Lupo - Estoque - Consulta de Produtos");
		pnlPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pnlPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pnlPrincipal.setLocationRelativeTo(null);
		pnlPrincipal.setResizable(true);
		pnlPrincipal.getContentPane().setLayout(null);
		
		lblHome = new JLabel("Consulta de Produtos");
		lblHome.setForeground(Color.BLACK);
		lblHome.setFont(new Font("Arial", Font.BOLD, 36));
		lblHome.setBounds(600, 50, 480, 30);
		pnlPrincipal.getContentPane().add(lblHome);
		
		lblFuncionario = new JLabel("Funcionários");
		lblFuncionario.setForeground(Color.BLACK);
		lblFuncionario.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblFuncionario.setBounds(50, 100, 250, 23);
		pnlPrincipal.getContentPane().add(lblFuncionario);
		
		lblEstoque = new JLabel("Estoque");
		lblEstoque.setForeground(Color.black);
		lblEstoque.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblEstoque.setBounds(50, 250, 250, 23);
		pnlPrincipal.getContentPane().add(lblEstoque);

		btnCadastrarFuncionario = new JButton("Cadastrar Funcionário");
		btnCadastrarFuncionario.addActionListener(this);
		btnCadastrarFuncionario.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnCadastrarFuncionario.setBounds(50, 150, 250, 23);
		pnlPrincipal.getContentPane().add(btnCadastrarFuncionario);

		btnConsultarFuncionario = new JButton("Consultar Funcionário");
		btnConsultarFuncionario.addActionListener(this);
		btnConsultarFuncionario.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnConsultarFuncionario.setBounds(50, 200, 250, 23);
		pnlPrincipal.getContentPane().add(btnConsultarFuncionario);
		
		btnCadastrarProduto = new JButton("Cadastrar Produto");
		btnCadastrarProduto.addActionListener(this);
		btnCadastrarProduto.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnCadastrarProduto.setBounds(50, 300, 250, 23);
		pnlPrincipal.getContentPane().add(btnCadastrarProduto);
		
		btnConsultarProduto = new JButton("Consultar Produto");
		btnConsultarProduto.addActionListener(this);
		btnConsultarProduto.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnConsultarProduto.setBounds(50, 350, 250, 23);
		pnlPrincipal.getContentPane().add(btnConsultarProduto);
		
		btnEntradaProduto = new JButton("Registrar Entradas");
		btnEntradaProduto.addActionListener(this);
		btnEntradaProduto.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnEntradaProduto.setBounds(50, 400, 250, 23);
		pnlPrincipal.getContentPane().add(btnEntradaProduto);
		
		btnSaidaProduto = new JButton("Registrar Saídas");
		btnSaidaProduto.addActionListener(this);
		btnSaidaProduto.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnSaidaProduto.setBounds(50, 450, 250, 23);
		pnlPrincipal.getContentPane().add(btnSaidaProduto);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setFont(new Font("Ariel", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnSair.setBounds(1000, 600, 100, 23);
		pnlPrincipal.getContentPane().add(btnSair);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(this);
		
		btnVoltar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnVoltar.setBounds(1150, 600, 100, 23);
		pnlPrincipal.getContentPane().add(btnVoltar);
		
		lblNumeroPedido = new JLabel("Nome do Produto:");
		lblNumeroPedido.setForeground(Color.BLACK);
		lblNumeroPedido.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNumeroPedido.setBounds(362, 150, 180, 23);
		pnlPrincipal.getContentPane().add(lblNumeroPedido);
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setFont(new Font("Arial", Font.PLAIN, 20));
		txtNomeProduto.setEditable(true);
		txtNomeProduto.setColumns(10);
		txtNomeProduto.setBounds(537, 150, 222, 22);
		pnlPrincipal.getContentPane().add(txtNomeProduto);
		
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setForeground(Color.black);
		btnBuscar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnBuscar.setBounds(1130, 150, 100, 23);
		pnlPrincipal.getContentPane().add(btnBuscar);
		
		

		modelo = new TabelaConsulta();
		resultBusca = new JTable(modelo);
		resultBusca.addMouseListener(modelo);
		resultBusca.getColumnModel().getColumn(0).setPreferredWidth(95);
		resultBusca.getColumnModel().getColumn(1).setPreferredWidth(65);
		resultBusca.getColumnModel().getColumn(2).setPreferredWidth(65);
		resultBusca.getColumnModel().getColumn(3).setPreferredWidth(65);
		resultBusca.getColumnModel().getColumn(4).setPreferredWidth(65);
		resultBusca.getColumnModel().getColumn(5).setPreferredWidth(65);
		resultBusca.getColumnModel().getColumn(6).setPreferredWidth(50);
		resultBusca.getColumnModel().getColumn(7).setPreferredWidth(50);
		resultBusca.getColumnModel().getColumn(8).setPreferredWidth(65);
		resultBusca.getColumnModel().getColumn(9).setPreferredWidth(65);
		resultBusca.getColumnModel().getColumn(10).setPreferredWidth(85);
		resultBusca.getColumnModel().getColumn(11).setPreferredWidth(70);
		resultBusca.getColumnModel().getColumn(12).setPreferredWidth(95);
		
		
		btnVizualizar = new Render(resultBusca,12);
		
		scroll = new JScrollPane(resultBusca);
		scroll.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scroll.setBounds(362, 258, 900, 300);
		pnlPrincipal.getContentPane().add(scroll);
		
		btnConfirmarRecebimento = new JButton("Confirmar Recebimento");
		btnConfirmarRecebimento.addActionListener(this);
		btnConfirmarRecebimento.setFont(new Font("Arial", Font.PLAIN, 20));
		btnConfirmarRecebimento.setBounds(1150, 513, 270, 53);
		//pnlPrincipal.getContentPane().add(btnConfirmarRecebimento);
		
		btnRelatorio = new JButton("Emitir Relatórios");
		btnRelatorio.addActionListener(this);
		btnRelatorio.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnRelatorio.setBounds(50, 500, 250, 23);
		pnlPrincipal.getContentPane().add(btnRelatorio);
		
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setForeground(Color.BLACK);
		lblCor.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCor.setBounds(362, 186, 50, 23);
		pnlPrincipal.getContentPane().add(lblCor);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setForeground(Color.BLACK);
		lblTamanho.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTamanho.setBounds(576, 185, 104, 23);
		pnlPrincipal.getContentPane().add(lblTamanho);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setForeground(Color.BLACK);
		lblCategoria.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCategoria.setBounds(771, 185, 92, 23);
		pnlPrincipal.getContentPane().add(lblCategoria);
		
		JLabel lblGenero = new JLabel("Gênero:");
		lblGenero.setForeground(Color.BLACK);
		lblGenero.setFont(new Font("Arial", Font.PLAIN, 20));
		lblGenero.setBounds(362, 222, 104, 23);
		pnlPrincipal.getContentPane().add(lblGenero);
		
		JLabel lblColecao = new JLabel("Coleção:");
		lblColecao.setForeground(Color.BLACK);
		lblColecao.setFont(new Font("Arial", Font.PLAIN, 20));
		lblColecao.setBounds(992, 186, 79, 23);
		pnlPrincipal.getContentPane().add(lblColecao);
		
		
		
		cmbCol = new JComboBox();
		cmbCol.setFont(new Font("Arial", Font.PLAIN, 16));
		cmbCol.setBounds(1077, 186, 153, 22);
		
		ColecaoSession col = new ColecaoSession();
		List<Colecao> listaCol = col.obter();
		cmbCol.addItem("");
		for(Colecao cole : listaCol) {
			if(cole.isStatus() == true) {
				cmbCol.addItem(cole.getNome());
			}
		}
		
		pnlPrincipal.getContentPane().add(cmbCol);
		
		cmbCat = new JComboBox();
		cmbCat.setFont(new Font("Arial", Font.PLAIN, 16));
		cmbCat.setBounds(865, 187, 115, 22);
		
		CategoriaSession cat = new CategoriaSession();
		List<Categoria> listaCat = cat.obter();
		cmbCat.addItem("");
		for(Categoria cate : listaCat) {
			if(cate.isStatus() == true) {
				cmbCat.addItem(cate.getNome());
			}
		}
		
		pnlPrincipal.getContentPane().add(cmbCat);
		
		cmbGen = new JComboBox();
		cmbGen.setFont(new Font("Arial", Font.PLAIN, 16));
		cmbGen.setBounds(442, 222, 122, 22);
		
		GeneroSession gen = new GeneroSession();
		List<Genero> listaGen = gen.obter();
		cmbGen.addItem("");
		for(Genero gene : listaGen) {
			if(gene.isStatus() == true) {
				cmbGen.addItem(gene.getNome());
			}
		}
		
		pnlPrincipal.getContentPane().add(cmbGen);
		
		cmbCor = new JComboBox();
		cmbCor.setFont(new Font("Arial", Font.PLAIN, 16));
		cmbCor.setBounds(411, 186, 153, 22);
		
		CorSession cor = new CorSession();
		List<Cor> listaCor = cor.obter();
		cmbCor.addItem("");
		for(Cor c : listaCor) {
			if(c.isStatus() == true) {
				cmbCor.addItem(c.getNome());
			}
		}
		
		
		
		pnlPrincipal.getContentPane().add(cmbCor);
		
		cmbTam = new JComboBox();
		cmbTam.setFont(new Font("Arial", Font.PLAIN, 16));
		cmbTam.setBounds(665, 187, 94, 22);
		
		TamanhoSession tam = new TamanhoSession();
		List<Tamanho> listaTam = tam.obter();
		cmbTam.addItem("");
		for(Tamanho tama : listaTam) {
			if(tama.isStatus() == true) {
				cmbTam.addItem(tama.getNome());
			}
		}
		
		pnlPrincipal.getContentPane().add(cmbTam);
		
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
			JOptionPane.showMessageDialog(null, "Você Já está na tela de Consulta de Produtos");
		} else
			
		if(e.getSource() == btnEntradaProduto) {
			TelaRegistrarEntrada tre = new TelaRegistrarEntrada();
			pnlPrincipal.dispose();
		} else
		
		if(e.getSource() == btnSaidaProduto) {
			TelaRegistrarSaida tre = new TelaRegistrarSaida();
			pnlPrincipal.dispose();
		} else
		
		if (e.getSource() == btnVoltar) {
			TelaMenu men =new TelaMenu();
			pnlPrincipal.dispose();
		} else
		if (e.getSource() == btnSair) {
			pnlPrincipal.dispose();
		}
		else if (e.getSource() == btnBuscar) {
			String nome;
			Categoria cat = new Categoria();
			CategoriaSession cats = new CategoriaSession();
			Cor cor = new Cor();
			CorSession cors = new CorSession();
			Genero gen = new Genero();
			GeneroSession gens = new GeneroSession();
			
			Tamanho tam = new Tamanho();
			TamanhoSession tams = new TamanhoSession();
			Colecao col = new Colecao();
			ColecaoSession cols = new ColecaoSession();
			
			Produto pro = new Produto();
			ProdutoSession ps = new ProdutoSession();
			List<Produto> lp = new ArrayList<Produto>();
			
			if(!txtNomeProduto.getText().trim().equals("")) {
				nome = txtNomeProduto.getText();
			} else {
				nome = null;
			}
			if(String.valueOf(cmbCat.getSelectedItem()) != ""){
				cat = cats.obterNome(String.valueOf(cmbCat.getSelectedItem()));
			} else {
				cat = null;
			}
			
			if(String.valueOf(cmbCor.getSelectedItem()) != "") {
				cor = cors.obterPorNome(String.valueOf(cmbCor.getSelectedItem()));
			} else {
				cor = null;
			}
			
			if(String.valueOf(cmbGen.getSelectedItem()) != "") {
				gen = gens.obterPorNome(String.valueOf(cmbGen.getSelectedItem()));
			} else {
				gen = null;
			}
			
			if(String.valueOf(cmbTam.getSelectedItem()) != "") {
				tam = tams.obterPorNome(String.valueOf(cmbTam.getSelectedItem()));
			} else {
				tam = null;
			}
			
			if(String.valueOf(cmbCol.getSelectedItem()) != "") {
				col = cols.obterPorNome(String.valueOf(cmbCol.getSelectedItem()));
			} else {
				col = null;
			}
			
			
			
			
			lp = ps.buscaCruzada(nome, cat, cor, gen, tam, col);
		
			
			
			
			modelo.removeRow();
			
			for (int i = 0; i < lp.size(); i++) {
				modelo.addRow(lp.get(i));			
			}
			
			
		}else if (e.getSource() == btnRelatorio) {
			TelaRelatorio tr = new TelaRelatorio();
			pnlPrincipal.dispose();
		}
	}
	public static void fechar () {
		pnlPrincipal.dispose();
	}
}
