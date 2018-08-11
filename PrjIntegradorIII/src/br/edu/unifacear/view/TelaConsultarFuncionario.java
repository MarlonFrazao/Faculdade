package br.edu.unifacear.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import br.edu.unifacear.util.ModeloTabela;
import br.edu.unifacear.util.Render;
import br.edu.unifacear.model.Funcionario;
import br.edu.unifacear.session.CargoSession;
import br.edu.unifacear.session.FuncionarioSession;

public class TelaConsultarFuncionario extends JFrame implements ActionListener, ItemListener {

	private JButton btnSair, btnVoltar, btnCadastrarFuncionario, btnConsultarFuncionario, btnCadastrarProduto,
			btnConsultarProduto, btnEntradaProduto, btnSaidaProduto, btnBuscar, btnRelatorio;
	private JLabel lblHome, lblFuncionario, lblEstoque, lblBuscar;
	private static JFrame pnlPrincipal;
	private static JComboBox boxBuscar;
	private static JRadioButton radioAtivo;
	private static JRadioButton radioInativo;
	private static JRadioButton radioAmbos;
	private ButtonGroup radioGroup;
	private String radioSelecionado;
	private static JTextField txtBuscar;
	private JTable resultBusca;
	private static ModeloTabela modelo;
	private JScrollPane scroll;
	private Render btnTableVisualizar,btnTabelaAlterar, btnTabelaExcluir;
	private MouseEvent evento;
	private int column;
	private int row;

	public TelaConsultarFuncionario() {
		super("Consultar Funcionario");

		pnlPrincipal = new JFrame("Loja Lupo - Estoque - Consulta de Funcionario");
		pnlPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pnlPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pnlPrincipal.setLocationRelativeTo(null);
		pnlPrincipal.setResizable(true);
		pnlPrincipal.getContentPane().setLayout(null);

		lblHome = new JLabel("Consulta de Funcionário");
		lblHome.setForeground(Color.BLACK);
		lblHome.setFont(new Font("Arial", Font.BOLD, 36));
		lblHome.setBounds(450, 50, 480, 30);
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
		
		btnRelatorio = new JButton("Emitir Relatórios");
		btnRelatorio.addActionListener(this);
		btnRelatorio.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnRelatorio.setBounds(50, 500, 250, 23);
		pnlPrincipal.getContentPane().add(btnRelatorio);

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

		lblBuscar = new JLabel("Buscar");
		lblBuscar.setForeground(Color.black);
		lblBuscar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblBuscar.setBounds(350, 150, 70, 23);
		pnlPrincipal.getContentPane().add(lblBuscar);

		boxBuscar = new JComboBox();
		boxBuscar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		boxBuscar.setBounds(430, 150, 150, 23);
		boxBuscar.addItem("Todos");
		boxBuscar.addItem("Por Matricula");
		boxBuscar.addItem("Por Nome");
		boxBuscar.addItem("Por Cargo");
		pnlPrincipal.getContentPane().add(boxBuscar);

		txtBuscar = new JTextField();
		txtBuscar.setForeground(Color.black);
		txtBuscar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		txtBuscar.setBounds(590, 150, 200, 23);
		pnlPrincipal.getContentPane().add(txtBuscar);

		radioGroup = new ButtonGroup();

		radioAtivo = new JRadioButton("Ativos", false);
		radioAtivo.setBounds(800, 150, 100, 23);
		radioAtivo.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));

		radioInativo = new JRadioButton("Inativos", false);
		radioInativo.setBounds(910, 150, 100, 23);
		radioInativo.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));

		radioAmbos = new JRadioButton("Ambos", true);
		radioAmbos.setBounds(1020, 150, 100, 23);
		radioAmbos.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));

		radioGroup.add(radioAtivo);
		radioGroup.add(radioInativo);
		radioGroup.add(radioAmbos);

		radioAtivo.addItemListener(this);
		radioInativo.addItemListener(this);
		radioAmbos.addItemListener(this);

		pnlPrincipal.getContentPane().add(radioAtivo);
		pnlPrincipal.getContentPane().add(radioInativo);
		pnlPrincipal.getContentPane().add(radioAmbos);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setForeground(Color.black);
		btnBuscar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnBuscar.setBounds(1130, 150, 100, 23);
		pnlPrincipal.getContentPane().add(btnBuscar);

		modelo = new ModeloTabela();
		resultBusca = new JTable(modelo);
		resultBusca.addMouseListener(modelo);
		//resultBusca.addMouseListener(btnTabelaExcluir);
		
		btnTableVisualizar = new Render(resultBusca, 4);
		btnTabelaAlterar = new Render(resultBusca, 5);
		//btnTabelaAlterar.mouseClicked(evento);
		btnTabelaExcluir = new Render(resultBusca, 6);
		//btnTabelaExcluir.mouseClicked(evento);

		scroll = new JScrollPane(resultBusca);
		scroll.setBounds(350, 200, 800, 300);
		pnlPrincipal.getContentPane().add(scroll);

		pnlPrincipal.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnCadastrarFuncionario) {
			TelaCadastrarFuncionario tcf = new TelaCadastrarFuncionario();
			pnlPrincipal.dispose();
		} else if (e.getSource() == btnConsultarFuncionario) {
			JOptionPane.showMessageDialog(null, "Você já está na Consulta de Funcionarioa");
		} else if (e.getSource() == btnCadastrarProduto) {
			TelaCadastrarProduto tcp = new TelaCadastrarProduto();
			pnlPrincipal.dispose();
		} else

		if (e.getSource() == btnConsultarProduto) {
			TelaConsultarProduto tcp = new TelaConsultarProduto();
			pnlPrincipal.dispose();
		} else

		if (e.getSource() == btnEntradaProduto) {
			TelaRegistrarEntrada tre = new TelaRegistrarEntrada();
			pnlPrincipal.dispose();
		} else

		if (e.getSource() == btnSaidaProduto) {
			TelaRegistrarSaida trs = new TelaRegistrarSaida();
			pnlPrincipal.dispose();
		} else
		
		if(e.getSource() == btnRelatorio) {
			TelaRelatorio tr = new TelaRelatorio();
			pnlPrincipal.dispose();
		} else
				
		if (e.getSource() == btnVoltar) {
			TelaMenu th = new TelaMenu();
			pnlPrincipal.dispose();
		} else if (e.getSource() == btnSair) {
			pnlPrincipal.dispose();
		} else if (e.getSource() == btnBuscar) {
			FuncionarioSession fs = new FuncionarioSession();
			Funcionario f = new Funcionario();
			List<Funcionario> lista = new ArrayList<Funcionario>();

			modelo.removeRow();
			
			

			if (radioAtivo.isSelected()) {
				if (boxBuscar.getSelectedItem() == "Todos") {
					lista = fs.listarTodos(true);

					for (int i = 0; i < lista.size(); i++) {

						modelo.addRow(lista.get(i));

					}
				}

				if (boxBuscar.getSelectedItem() == "Por Matricula") {
					f = fs.obterPorMat(Long.parseLong(txtBuscar.getText()), true);

					modelo.addRow(f);

				}
				if (boxBuscar.getSelectedItem() == "Por Nome") {
					lista = fs.obterPorNome(txtBuscar.getText(), true);

					for (int i = 0; i < lista.size(); i++) {

						modelo.addRow(lista.get(i));

					}
				}

				if (boxBuscar.getSelectedItem() == "Por Cargo") {
					CargoSession cs = new CargoSession();
					lista = fs.obterPorCargo(txtBuscar.getText(), true);

					for (int i = 0; i < lista.size(); i++) {

						modelo.addRow(lista.get(i));

					}
				}

			} else if (radioInativo.isSelected()) {

				if (boxBuscar.getSelectedItem() == "Todos") {
					lista = fs.listarTodos(false);

					for (int i = 0; i < lista.size(); i++) {

						modelo.addRow(lista.get(i));

					}
				}

				if (boxBuscar.getSelectedItem() == "Por Matricula") {
					f = fs.obterPorMat(Long.parseLong(txtBuscar.getText()), false);

					modelo.addRow(f);

				}
				if (boxBuscar.getSelectedItem() == "Por Nome") {
					lista = fs.obterPorNome(txtBuscar.getText(), false);

					for (int i = 0; i < lista.size(); i++) {

						modelo.addRow(lista.get(i));

					}
				}

				if (boxBuscar.getSelectedItem() == "Por Cargo") {
					CargoSession cs = new CargoSession();
					lista = fs.obterPorCargo(txtBuscar.getText(), false);

					for (int i = 0; i < lista.size(); i++) {

						modelo.addRow(lista.get(i));

					}

				}
			} else if (radioAmbos.isSelected()) {

				if (boxBuscar.getSelectedItem() == "Todos") {
					lista = fs.listarTodos();

					for (int i = 0; i < lista.size(); i++) {
						modelo.addRow(lista.get(i));
					}
				}

				if (boxBuscar.getSelectedItem() == "Por Matricula") {
					f = fs.obterPorMat(Long.parseLong(txtBuscar.getText()));
					modelo.addRow(f);
				}
				if (boxBuscar.getSelectedItem() == "Por Nome") {
					lista = fs.obterPorNome(txtBuscar.getText());

					for (int i = 0; i < lista.size(); i++) {
						System.out.println("nome" + lista.get(i));
						modelo.addRow(lista.get(i));
					}
				}

				if (boxBuscar.getSelectedItem() == "Por Cargo") {
					CargoSession cs = new CargoSession();
					lista = fs.obterPorCargo(txtBuscar.getText());

					for (int i = 0; i < lista.size(); i++) {
						modelo.addRow(lista.get(i));
					}
				}
			}

		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == radioAtivo) {
			radioSelecionado = "ativo";
		} else if (e.getSource() == radioInativo) {
			radioSelecionado = "inativo";
		} else if (e.getSource() == radioAmbos) {
			radioSelecionado = "ambos";
		}

	}
	public static void fechar () {
		pnlPrincipal.dispose();
	}
	
	public static void refreshTabela() {
		FuncionarioSession fs = new FuncionarioSession();
		Funcionario f = new Funcionario();
		List<Funcionario> lista = new ArrayList<Funcionario>();

		modelo.removeRow();
		
		if (radioAtivo.isSelected()) {
			if (boxBuscar.getSelectedItem() == "Todos") {
				lista = fs.listarTodos(true);

				for (int i = 0; i < lista.size(); i++) {

					modelo.addRow(lista.get(i));

				}
			}

			if (boxBuscar.getSelectedItem() == "Por Matricula") {
				f = fs.obterPorMat(Long.parseLong(txtBuscar.getText()), true);

				modelo.addRow(f);

			}
			if (boxBuscar.getSelectedItem() == "Por Nome") {
				lista = fs.obterPorNome(txtBuscar.getText(), true);

				for (int i = 0; i < lista.size(); i++) {

					modelo.addRow(lista.get(i));

				}
			}

			if (boxBuscar.getSelectedItem() == "Por Cargo") {
				CargoSession cs = new CargoSession();
				lista = fs.obterPorCargo(txtBuscar.getText(), true);

				for (int i = 0; i < lista.size(); i++) {

					modelo.addRow(lista.get(i));

				}
			}

		} else if (radioInativo.isSelected()) {

			if (boxBuscar.getSelectedItem() == "Todos") {
				lista = fs.listarTodos(false);

				for (int i = 0; i < lista.size(); i++) {

					modelo.addRow(lista.get(i));

				}
			}

			if (boxBuscar.getSelectedItem() == "Por Matricula") {
				f = fs.obterPorMat(Long.parseLong(txtBuscar.getText()), false);

				modelo.addRow(f);

			}
			if (boxBuscar.getSelectedItem() == "Por Nome") {
				lista = fs.obterPorNome(txtBuscar.getText(), false);

				for (int i = 0; i < lista.size(); i++) {

					modelo.addRow(lista.get(i));

				}
			}

			if (boxBuscar.getSelectedItem() == "Por Cargo") {
				CargoSession cs = new CargoSession();
				lista = fs.obterPorCargo(txtBuscar.getText(), false);

				for (int i = 0; i < lista.size(); i++) {

					modelo.addRow(lista.get(i));

				}

			}
		} else if (radioAmbos.isSelected()) {

			if (boxBuscar.getSelectedItem() == "Todos") {
				lista = fs.listarTodos();

				for (int i = 0; i < lista.size(); i++) {
					modelo.addRow(lista.get(i));
				}
			}

			if (boxBuscar.getSelectedItem() == "Por Matricula") {
				f = fs.obterPorMat(Long.parseLong(txtBuscar.getText()));
				modelo.addRow(f);
			}
			if (boxBuscar.getSelectedItem() == "Por Nome") {
				lista = fs.obterPorNome(txtBuscar.getText());

				for (int i = 0; i < lista.size(); i++) {
					System.out.println("nome" + lista.get(i));
					modelo.addRow(lista.get(i));
				}
			}

			if (boxBuscar.getSelectedItem() == "Por Cargo") {
				CargoSession cs = new CargoSession();
				lista = fs.obterPorCargo(txtBuscar.getText());

				for (int i = 0; i < lista.size(); i++) {
					modelo.addRow(lista.get(i));
				}
			}
		}

	
	}
}
