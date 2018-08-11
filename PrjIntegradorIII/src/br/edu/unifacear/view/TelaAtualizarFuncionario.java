package br.edu.unifacear.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.unifacear.model.Cargo;
import br.edu.unifacear.model.Funcionario;
import br.edu.unifacear.session.CargoSession;
import br.edu.unifacear.session.FuncionarioSession;

public class TelaAtualizarFuncionario extends JFrame implements ActionListener {
	
	private JButton btnSair, btnVoltar, btnCadastrarFuncionario, btnConsultarFuncionario, 
					btnCadastrarProduto, btnConsultarProduto, btnEntradaProduto, btnSaidaProduto, 
					btnSalvar, btnNovoCargo, btnCancelar, btnRelatorio;
	private JLabel lblHome, lblFuncionario, lblEstoque, lblMatricula, lblNome, lblSenha, lblConfSenha, 
					lblCargo, lblCpf, lblCtps, lblPis, lblDataNasc, lblDataAdmissao, lblEndereco, 
					lblDataExemplo, lblDataExemplo2, lblStatus;
	private JFrame pnlPrincipal;
	private JTextField txtMatricula, txtNome, txtCpf, txtCtps, txtPis, txtDataNasc, txtDataAdmissao, txtRua, txtNum, txtCep, txtComplemento, txtBairro, txtCidade, txtUf;
	private JComboBox boxCargo, boxStatus;
	private JTextArea txtEndereco;
	private JPasswordField txtSenha, txtConfSenha;
	
	public TelaAtualizarFuncionario(Funcionario f) {
		super("Atualizar Funcionario");
		
		pnlPrincipal = new JFrame("Loja Lupo - Estoque - Atualizar Dados do Funcionário");
		pnlPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pnlPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pnlPrincipal.setLocationRelativeTo(null);
		pnlPrincipal.setResizable(true);
		pnlPrincipal.getContentPane().setLayout(null);
		
		lblHome = new JLabel("Atualizar Dados do Funcionário");
		lblHome.setForeground(Color.BLACK);
		lblHome.setFont(new Font("Arial", Font.BOLD, 36));
		lblHome.setBounds(425, 50, 550, 30);
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
		
		lblMatricula = new JLabel("Matrícula:");
		lblMatricula.setForeground(Color.black);
		lblMatricula.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblMatricula.setBounds(350, 150, 150, 23);
		pnlPrincipal.getContentPane().add(lblMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		txtMatricula.setBounds(510, 150, 200, 23);
		txtMatricula.setText(String.valueOf(f.getMatricula()));
		txtMatricula.setEditable(false);
		pnlPrincipal.getContentPane().add(txtMatricula);
		
		lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.black);
		lblNome.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblNome.setBounds(350, 180, 150, 23);
		pnlPrincipal.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		txtNome.setBounds(510, 180, 200, 23);
		txtNome.setText(f.getNome());
		txtNome.setEditable(true);
		pnlPrincipal.getContentPane().add(txtNome);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.black);
		lblSenha.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblSenha.setBounds(350, 210, 150, 23);
		pnlPrincipal.getContentPane().add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		txtSenha.setBounds(510, 210, 200, 23);
		txtSenha.setText(f.getSenha());
		txtSenha.setEditable(true);
		pnlPrincipal.getContentPane().add(txtSenha);
		
		lblConfSenha = new JLabel("Repita a senha:");
		lblConfSenha.setForeground(Color.black);
		lblConfSenha.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblConfSenha.setBounds(350, 240, 150, 23);
		pnlPrincipal.getContentPane().add(lblConfSenha);
		
		txtConfSenha = new JPasswordField();
		txtConfSenha.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		txtConfSenha.setBounds(510, 240, 200, 23);
		txtConfSenha.setText(f.getSenha());
		txtConfSenha.setEditable(true);
		pnlPrincipal.getContentPane().add(txtConfSenha);
		
		lblCargo = new JLabel("Cargo:");
		lblCargo.setForeground(Color.black);
		lblCargo.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblCargo.setBounds(350, 270, 150, 23);
		pnlPrincipal.getContentPane().add(lblCargo);
		
		boxCargo = new JComboBox();
		boxCargo.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		boxCargo.setBounds(510, 270, 200, 23);
		
		
		CargoSession cs = new CargoSession();
		List<Cargo> listaCargo = cs.listarTodos();
		boxCargo.addItem("");
		for(Cargo c : listaCargo) {
			if(c.isStatus() == true) {
				boxCargo.addItem(c.getNome());
			}
		}
		boxCargo.setSelectedIndex((int)f.getCargo().getId());
		
		pnlPrincipal.getContentPane().add(boxCargo);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.black);
		lblCpf.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblCpf.setBounds(750, 150, 150, 23);
		pnlPrincipal.getContentPane().add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setForeground(Color.black);
		txtCpf.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		txtCpf.setBounds(910, 150, 150,23);
		txtCpf.setText(String.valueOf(f.getCpf()));
		txtCpf.setEditable(true);
		pnlPrincipal.getContentPane().add(txtCpf);
		
		lblCtps = new JLabel("CTPS:");
		lblCtps.setForeground(Color.black);
		lblCtps.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblCtps.setBounds(750, 180, 150, 23);
		pnlPrincipal.getContentPane().add(lblCtps);
		
		txtCtps = new JTextField();
		txtCtps.setForeground(Color.black);
		txtCtps.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		txtCtps.setBounds(910, 180, 150,23);
		txtCtps.setText(String.valueOf(f.getCtps()));
		txtCtps.setEditable(true);
		pnlPrincipal.getContentPane().add(txtCtps);
		
		lblPis = new JLabel("PIS:");
		lblPis.setForeground(Color.black);
		lblPis.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblPis.setBounds(750, 210, 150, 23);
		pnlPrincipal.getContentPane().add(lblPis);
		
		txtPis = new JTextField();
		txtPis.setForeground(Color.black);
		txtPis.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		txtPis.setBounds(910, 210, 150,23);
		txtPis.setText(String.valueOf(f.getPis()));
		txtPis.setEditable(true);
		pnlPrincipal.getContentPane().add(txtPis);
		
		lblDataNasc = new JLabel("Nascimento:");
		lblDataNasc.setForeground(Color.black);
		lblDataNasc.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblDataNasc.setBounds(750, 240, 150, 23);
		pnlPrincipal.getContentPane().add(lblDataNasc);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		txtDataNasc = new JTextField();
		txtDataNasc.setForeground(Color.black);
		txtDataNasc.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		txtDataNasc.setBounds(910, 240, 150,23);
		txtDataNasc.setText(String.valueOf(formato.format(f.getDataNasc())));
		txtDataNasc.setEditable(true);
		pnlPrincipal.getContentPane().add(txtDataNasc);
		
		lblDataExemplo = new JLabel("dd/mm/aaaa");
		lblDataExemplo.setForeground(Color.black);
		lblDataExemplo.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblDataExemplo.setBounds(1065, 240, 150, 23);
		pnlPrincipal.getContentPane().add(lblDataExemplo);
		
		lblDataAdmissao = new JLabel("Admissao:");
		lblDataAdmissao.setForeground(Color.black);
		lblDataAdmissao.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblDataAdmissao.setBounds(750, 270, 150, 23);
		pnlPrincipal.getContentPane().add(lblDataAdmissao);
		
		txtDataAdmissao = new JTextField();
		txtDataAdmissao.setForeground(Color.black);
		txtDataAdmissao.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		txtDataAdmissao.setBounds(910, 270, 150,23);
		txtDataAdmissao.setText(String.valueOf(formato.format(f.getDataAdmissao())));
		txtDataAdmissao.setEditable(true);
		pnlPrincipal.getContentPane().add(txtDataAdmissao);
		
		lblDataExemplo2 = new JLabel("dd/mm/aaaa");
		lblDataExemplo2.setForeground(Color.black);
		lblDataExemplo2.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblDataExemplo2.setBounds(1065, 270, 150, 23);
		pnlPrincipal.getContentPane().add(lblDataExemplo2);
		
		lblStatus = new JLabel("Status:");
		lblStatus.setForeground(Color.black);
		lblStatus.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblStatus.setBounds(750, 300, 150, 23);
		pnlPrincipal.getContentPane().add(lblStatus);
		
		boxStatus = new JComboBox();
		boxStatus.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		boxStatus.setBounds(910, 300, 150, 23);
		boxStatus.addItem("Ativo");
		boxStatus.addItem("Inativo");
		
		if(f.isStatus() == true) {
			boxStatus.setSelectedIndex(0);
		} else {
			boxStatus.setSelectedIndex(1);
		}
		
		pnlPrincipal.getContentPane().add(boxStatus);
		
		btnNovoCargo = new JButton("Novo Cargo");
		btnNovoCargo.setForeground(Color.black);
		btnNovoCargo.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		btnNovoCargo.setBounds(590, 300, 120, 23);
		btnNovoCargo.addActionListener(this);
		pnlPrincipal.getContentPane().add(btnNovoCargo);
		
		lblEndereco = new JLabel("Endereço:");
		lblEndereco.setForeground(Color.black);
		lblEndereco.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblEndereco.setBounds(350, 330, 150, 23);
		pnlPrincipal.getContentPane().add(lblEndereco);
		
		txtEndereco = new JTextArea();
		txtEndereco.setForeground(Color.black);
		txtEndereco.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		txtEndereco.setBounds(510, 330, 600, 200 );
		txtEndereco.setText(f.getEndereco());
		txtEndereco.setEditable(true);
		txtEndereco.setLineWrap(true);
		pnlPrincipal.getContentPane().add(txtEndereco);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.black);
		btnSalvar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnSalvar.setBounds(600, 540, 90, 23);
		btnSalvar.addActionListener(this);
		pnlPrincipal.getContentPane().add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.black);
		btnCancelar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnCancelar.setBounds(700, 540, 120, 23);
		pnlPrincipal.getContentPane().add(btnCancelar);

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
			TelaRegistrarEntrada tre= new TelaRegistrarEntrada();
			pnlPrincipal.dispose();
		} else
		
		if(e.getSource() == btnSaidaProduto) {
			TelaRegistrarSaida trs = new TelaRegistrarSaida();
			pnlPrincipal.dispose();
		} else
			
		if(e.getSource() == btnRelatorio) {
			TelaRelatorio tr = new TelaRelatorio();
			pnlPrincipal.dispose();
		} else
		
		if (e.getSource() == btnVoltar) {
			TelaConsultarFuncionario l = new TelaConsultarFuncionario();
			pnlPrincipal.dispose();
		} else
		if (e.getSource() == btnSair) {
			pnlPrincipal.dispose();
		} else
		
		if(e.getSource() == btnSalvar) {
			FuncionarioSession fs = new FuncionarioSession();
			CargoSession cs = new CargoSession();
			Cargo c = new Cargo();
			c = cs.obterNome(String.valueOf(boxCargo.getSelectedItem()));
			
			try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			Date dataNasc = new Date(formato.parse(txtDataNasc.getText()).getTime());
			Date dataAdmissao = new Date(formato.parse(txtDataAdmissao.getText()).getTime());
			boolean aux = false;
			if (String.valueOf(boxStatus.getSelectedItem()).equals("Ativo")) {
				aux = true;
			} else if (String.valueOf(boxStatus.getSelectedItem()).equals("Inativo")) {
				aux = false;
			}
			Funcionario f = new Funcionario(Long.parseLong(txtMatricula.getText()),
					txtSenha.getText(), txtNome.getText(), c, Long.parseLong(txtCpf.getText()),
					Long.parseLong(txtCtps.getText()), Long.parseLong(txtPis.getText()), dataNasc, dataAdmissao, 
							txtEndereco.getText(), aux);
			
			fs.atualizarFuncionario(f);
			
			JOptionPane.showMessageDialog(null, "Alterado com sucesso!!");
			TelaConsultarFuncionario.refreshTabela();
			pnlPrincipal.dispose();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			
			
			
		} else
			
			if (e.getSource() == btnCancelar) {
				TelaConsultarFuncionario tela = new TelaConsultarFuncionario();
				pnlPrincipal.dispose();
			}
		
	}

}
