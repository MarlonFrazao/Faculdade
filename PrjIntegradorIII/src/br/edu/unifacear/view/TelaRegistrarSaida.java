package br.edu.unifacear.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import br.edu.unifacear.model.Entrada;
import br.edu.unifacear.model.Funcionario;
import br.edu.unifacear.model.Produto;
import br.edu.unifacear.model.Saida;
import br.edu.unifacear.session.EntradaSession;
import br.edu.unifacear.session.FuncionarioSession;
import br.edu.unifacear.session.ProdutoSession;
import br.edu.unifacear.session.SaidaSession;
import br.edu.unifacear.util.ModeloTabela;
import br.edu.unifacear.util.TabelaEntrada;
import br.edu.unifacear.util.TabelaSaida;

public class TelaRegistrarSaida extends JFrame implements ActionListener {
	
	private JButton btnSair,btnRelatorio , btnConfirmarSaida,btnBuscar , btnVoltar, btnCadastrarFuncionario, btnConsultarFuncionario, btnCadastrarProduto, btnConsultarProduto, btnEntradaProduto, btnSaidaProduto;
	private JLabel lblHome, lblFuncionario, lblEstoque, lblNumeroPedido;
	private JFrame pnlPrincipal;
	private JTextField txtNumeroPedido, txtDataSaida;
	private JTable resultBusca;
	private static TabelaSaida modelo;
	private JScrollPane scroll;
	private Date data;
	
	
	
	public TelaRegistrarSaida() {
		super("Menu");

		pnlPrincipal = new JFrame("Loja Lupo - Estoque - Saída");
		pnlPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pnlPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pnlPrincipal.setLocationRelativeTo(null);
		pnlPrincipal.setResizable(true);
		pnlPrincipal.getContentPane().setLayout(null);
		
		lblHome = new JLabel("Registrar Saída");
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
		
		lblNumeroPedido = new JLabel("N\u00FAmero Pedido:");
		lblNumeroPedido.setForeground(Color.BLACK);
		lblNumeroPedido.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNumeroPedido.setBounds(362, 150, 180, 23);
		pnlPrincipal.getContentPane().add(lblNumeroPedido);
		
		txtNumeroPedido = new JTextField();
		txtNumeroPedido.setFont(new Font("Arial", Font.PLAIN, 20));
		txtNumeroPedido.setEditable(true);
		txtNumeroPedido.setColumns(10);
		txtNumeroPedido.setBounds(537, 150, 222, 22);
		pnlPrincipal.getContentPane().add(txtNumeroPedido);
		
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setForeground(Color.black);
		btnBuscar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnBuscar.setBounds(1130, 150, 100, 23);
		pnlPrincipal.getContentPane().add(btnBuscar);

		modelo = new TabelaSaida();
		resultBusca = new JTable(modelo);
		resultBusca.addMouseListener(modelo);
		resultBusca.getColumnModel().getColumn(0).setPreferredWidth(100);
		resultBusca.getColumnModel().getColumn(1).setPreferredWidth(65);
		resultBusca.getColumnModel().getColumn(2).setPreferredWidth(65);
		resultBusca.getColumnModel().getColumn(3).setPreferredWidth(65);
		resultBusca.getColumnModel().getColumn(4).setPreferredWidth(65);
		resultBusca.getColumnModel().getColumn(5).setPreferredWidth(65);
		resultBusca.getColumnModel().getColumn(6).setPreferredWidth(55);
		resultBusca.getColumnModel().getColumn(7).setPreferredWidth(65);
		resultBusca.getColumnModel().getColumn(8).setPreferredWidth(65);
		resultBusca.getColumnModel().getColumn(9).setPreferredWidth(65);
		resultBusca.getColumnModel().getColumn(10).setPreferredWidth(80);
		resultBusca.getColumnModel().getColumn(11).setPreferredWidth(65);
		resultBusca.getColumnModel().getColumn(11).setPreferredWidth(95);
		
		
		
		
		scroll = new JScrollPane(resultBusca);
		scroll.setBounds(350, 200, 900, 300);
		pnlPrincipal.getContentPane().add(scroll);
		
		btnConfirmarSaida = new JButton("Confirmar Saída");
		btnConfirmarSaida.addActionListener(this);
		btnConfirmarSaida.setFont(new Font("Arial", Font.PLAIN, 20));
		btnConfirmarSaida.setBounds(980, 513, 270, 53);
		pnlPrincipal.getContentPane().add(btnConfirmarSaida);
		
		JLabel lblDataRecebimento = new JLabel("Data Saída: ");
		lblDataRecebimento.setForeground(Color.BLACK);
		lblDataRecebimento.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDataRecebimento.setBounds(362, 543, 180, 23);
		pnlPrincipal.getContentPane().add(lblDataRecebimento);
		
		txtDataSaida = new JTextField();
		txtDataSaida.setFont(new Font("Arial", Font.PLAIN, 20));
		txtDataSaida.setEditable(true);
		txtDataSaida.setColumns(10);
		txtDataSaida.setBounds(537, 544, 222, 22);
		
		data = new Date(System.currentTimeMillis());  
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy"); 
		String dat = formatarDate.format(data);
		txtDataSaida.setText(dat);
		txtDataSaida.setEditable(false);
		pnlPrincipal.getContentPane().add(txtDataSaida);
		
		btnRelatorio = new JButton("Emitir Relatórios");
		btnRelatorio.addActionListener(this);
		btnRelatorio.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnRelatorio.setBounds(50, 500, 250, 23);
		pnlPrincipal.getContentPane().add(btnRelatorio);
		
		

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
			JOptionPane.showMessageDialog(null, "Você já esta na tela de saída");
		} else
		
		if (e.getSource() == btnVoltar) {
			TelaMenu men =new TelaMenu();
			pnlPrincipal.dispose();
		} else
		if (e.getSource() == btnSair) {
			pnlPrincipal.dispose();
		}
		else if (e.getSource() == btnBuscar) {
			SaidaSession ss = new SaidaSession();
			Saida said = new Saida();
			List<Saida> le = new ArrayList<Saida>();
			List<Produto> lp = new ArrayList<Produto>();
			
			said=ss.obterPedVenda(Long.parseLong(txtNumeroPedido.getText()));
			lp = said.getListaProdutos();
			
			modelo.removeRow();
			if(said.getId()==0) {
				JOptionPane.showMessageDialog(null,"Numero da saida inválido!");
			}else {
				for (int i = 0; i < lp.size(); i++) {
					
						modelo.addRow(lp.get(i));	
					
				}
			}			
		}else if (e.getSource() == btnConfirmarSaida) {
			Saida said = new Saida();
			SaidaSession ss = new SaidaSession();
			List<Produto> lp = new ArrayList<Produto>();
			Produto pro = new Produto();
			ProdutoSession ps = new ProdutoSession();
			
			said = ss.obterPedVenda(Long.parseLong(txtNumeroPedido.getText()));			
			lp = said.getListaProdutos();
			
			System.out.println("lp qtd antes :"+lp.get(0).getQtde());
			
			said.setDataSaida(data);
			ss.atualizarSaida(said, lp);
			
			System.out.println("lp qtd depois :"+lp.get(0).getQtde());
			
			JOptionPane.showMessageDialog(null,"Pedido de venda efetuado com sucesso com sucesso!!");
			modelo.removeRow();
			
		}else if (e.getSource() == btnRelatorio) {
			TelaRelatorio tr = new TelaRelatorio();
			pnlPrincipal.dispose();
		}
	}
}

