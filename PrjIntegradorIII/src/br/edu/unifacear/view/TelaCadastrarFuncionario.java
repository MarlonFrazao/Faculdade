package br.edu.unifacear.view;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.edu.unifacear.model.Cargo;
import br.edu.unifacear.model.Funcionario;
import br.edu.unifacear.session.CargoSession;
import br.edu.unifacear.session.FuncionarioSession;

public class TelaCadastrarFuncionario extends JFrame implements ActionListener {
	private JButton btnSair, btnVoltar, btnCadastrarFuncionario, btnConsultarFuncionario, 
			btnCadastrarProduto, btnConsultarProduto, btnEntradaProduto, btnSaidaProduto, 
			btnSalvar, btnNovoCargo, btnCancelar, btnRelatorio;
	private JLabel lblHome, lblFuncionario, lblEstoque, lblMatricula, lblNome, lblSenha, lblConfSenha, lblCargo, lblCpf, lblCtps, lblPis, lblDataNasc, lblDataAdmissao, lblEndereco, lblRua, lblNum, lblCep, lblComplemento, lblBairro, lblCidade, lblUf, lblDataExemplo, lblDataExemplo2;
	private JFrame pnlPrincipal;
	private JTextField txtMatricula, txtNome, txtCpf, txtCtps, txtPis, txtDataNasc, txtDataAdmissao, txtRua, txtNum, txtCep, txtComplemento, txtBairro, txtCidade, txtUf;
	private JPasswordField  txtSenha, txtConfSenha;
	private JComboBox boxCargo;
	
	
	
	public TelaCadastrarFuncionario() {
		super("Cadastro de Funcionario");

		pnlPrincipal = new JFrame("Loja Lupo - Estoque - Cadastro de Funcionario");
		pnlPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pnlPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pnlPrincipal.setLocationRelativeTo(null);
		pnlPrincipal.setResizable(true);
		pnlPrincipal.getContentPane().setLayout(null);
		
		lblHome = new JLabel("Cadastro de Funcionários");
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
		
		lblMatricula = new JLabel("Matrícula:");
		lblMatricula.setForeground(Color.black);
		lblMatricula.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblMatricula.setBounds(350, 150, 150, 23);
		pnlPrincipal.getContentPane().add(lblMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		txtMatricula.setBounds(510, 150, 200, 23);
		FuncionarioSession fs = new FuncionarioSession();
		txtMatricula.setText(String.valueOf(fs.proximaMat()));
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
		pnlPrincipal.getContentPane().add(txtNome);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.black);
		lblSenha.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblSenha.setBounds(350, 210, 150, 23);
		pnlPrincipal.getContentPane().add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		txtSenha.setBounds(510, 210, 200, 23);
		pnlPrincipal.getContentPane().add(txtSenha);
		
		lblConfSenha = new JLabel("Repita a senha:");
		lblConfSenha.setForeground(Color.black);
		lblConfSenha.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblConfSenha.setBounds(350, 240, 150, 23);
		pnlPrincipal.getContentPane().add(lblConfSenha);
		
		txtConfSenha = new JPasswordField();
		txtConfSenha.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		txtConfSenha.setBounds(510, 240, 200, 23);
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
		pnlPrincipal.getContentPane().add(txtPis);
		
		lblDataNasc = new JLabel("Nascimento:");
		lblDataNasc.setForeground(Color.black);
		lblDataNasc.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblDataNasc.setBounds(750, 240, 150, 23);
		pnlPrincipal.getContentPane().add(lblDataNasc);
		
		txtDataNasc = new JTextField();
		txtDataNasc.setForeground(Color.black);
		txtDataNasc.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		txtDataNasc.setBounds(910, 240, 150,23);
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
		pnlPrincipal.getContentPane().add(txtDataAdmissao);
		
		lblDataExemplo2 = new JLabel("dd/mm/aaaa");
		lblDataExemplo2.setForeground(Color.black);
		lblDataExemplo2.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblDataExemplo2.setBounds(1065, 270, 150, 23);
		pnlPrincipal.getContentPane().add(lblDataExemplo2);
		
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
		
		lblRua = new JLabel("Rua:");
		lblRua.setForeground(Color.black);
		lblRua.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblRua.setBounds(350, 360, 50, 23);
		pnlPrincipal.getContentPane().add(lblRua);
		
		txtRua = new JTextField();
		txtRua.setForeground(Color.black);
		txtRua.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		txtRua.setBounds(405, 360, 200, 23);
		pnlPrincipal.getContentPane().add(txtRua);
		
		lblNum = new JLabel("Número:");
		lblNum.setForeground(Color.black);
		lblNum.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblNum.setBounds(620, 360, 80, 23);
		pnlPrincipal.getContentPane().add(lblNum);
		
		txtNum = new JTextField();
		txtNum.setForeground(Color.black);
		txtNum.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		txtNum.setBounds(705, 360, 60, 23);
		pnlPrincipal.getContentPane().add(txtNum);
		
		lblCep = new JLabel("CEP:");
		lblCep.setForeground(Color.black);
		lblCep.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblCep.setBounds(775, 360, 50, 23);
		pnlPrincipal.getContentPane().add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setForeground(Color.black);
		txtCep.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		txtCep.setBounds(830, 360, 100, 23);
		pnlPrincipal.getContentPane().add(txtCep);
		
		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setForeground(Color.black);
		lblComplemento.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblComplemento.setBounds(940, 360, 130, 23);
		pnlPrincipal.getContentPane().add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setForeground(Color.black);
		txtComplemento.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		txtComplemento.setBounds(1075, 360, 150, 23);
		pnlPrincipal.getContentPane().add(txtComplemento);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setForeground(Color.black);
		lblBairro.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblBairro.setBounds(350, 390, 65, 23);
		pnlPrincipal.getContentPane().add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setForeground(Color.black);
		txtBairro.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		txtBairro.setBounds(420, 390, 150, 23);
		pnlPrincipal.getContentPane().add(txtBairro);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setForeground(Color.black);
		lblCidade.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblCidade.setBounds(580, 390, 100, 23);
		pnlPrincipal.getContentPane().add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setForeground(Color.black);
		txtCidade.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		txtCidade.setBounds(655, 390, 300, 23);
		pnlPrincipal.getContentPane().add(txtCidade);
		
		lblUf = new JLabel("UF:");
		lblUf.setForeground(Color.black);
		lblUf.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblUf.setBounds(965, 390, 35, 23);
		pnlPrincipal.getContentPane().add(lblUf);
		
		txtUf = new JTextField();
		txtUf.setForeground(Color.black);
		txtUf.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		txtUf.setBounds(1005, 390, 50, 23);
		pnlPrincipal.getContentPane().add(txtUf);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.black);
		btnSalvar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnSalvar.setBounds(600, 450, 90, 23);
		btnSalvar.addActionListener(this);
		pnlPrincipal.getContentPane().add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setForeground(Color.black);
		btnCancelar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnCancelar.setBounds(700, 450, 120, 23);
		pnlPrincipal.getContentPane().add(btnCancelar);
		

		pnlPrincipal.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnCadastrarFuncionario) {
			JOptionPane.showMessageDialog(null, "Você já está no Cadastro de Funcionário");
		} else
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
			
		if(e.getSource() == btnRelatorio) {
			TelaRelatorio tr = new TelaRelatorio();
			pnlPrincipal.dispose();
		} else
		
		if (e.getSource() == btnVoltar) {
			TelaMenu tm = new TelaMenu();
			pnlPrincipal.dispose();
		} else
		if (e.getSource() == btnSair) {
			pnlPrincipal.dispose();
		} else
		if(e.getSource() == btnCancelar) {
			TelaCadastrarFuncionario tcf = new TelaCadastrarFuncionario();
			pnlPrincipal.dispose();
		} else
		if(e.getSource() == btnSalvar) {
			if(txtSenha.getText().equals(txtConfSenha.getText())) {
				Cargo c = new Cargo();
				CargoSession cs = new CargoSession();
				
				c = cs.obterNome(String.valueOf(boxCargo.getSelectedItem()));
				
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				try {
					System.out.println(txtDataNasc.getText());
					Date dataNasc = new Date(formato.parse(txtDataNasc.getText()).getTime());
					Date dataAdmissao = new Date(formato.parse(txtDataAdmissao.getText()).getTime()); 
					Funcionario f = new Funcionario(Long.parseLong(txtMatricula.getText()), txtSenha.getText(), txtNome.getText(), c, Long.parseLong(txtCpf.getText()), Long.parseLong(txtCtps.getText()), Long.parseLong(txtPis.getText()), dataNasc, dataAdmissao, "Rua: "+ txtRua.getText()+ " Nº: "+ txtNum.getText()+ " CEP: " + txtCep.getText()+ " Complemento: " + txtComplemento.getText()+ " Bairro: " + txtBairro.getText() + " Cidade: "+ txtCidade.getText() + " UF: " +txtUf.getText(), true);
					FuncionarioSession fs = new FuncionarioSession();
					fs.inserirFuncionario(f);
					
					TelaCadastrarFuncionario tcf = new TelaCadastrarFuncionario();
					pnlPrincipal.dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Senhas não conferem!");
			}
			
		} else 
		if (e.getSource() == btnNovoCargo) {
			TelaCadastroCargo tcg = new TelaCadastroCargo();
		} 
		
	}

}
