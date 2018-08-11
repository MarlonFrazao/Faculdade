package br.edu.unifacear.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.edu.unifacear.session.FuncionarioSession;

public class TelaLogin extends JFrame implements ActionListener {
	
	private JButton btnLogin, btnSair;
	private JLabel lblLogin, lblSenha, lblLOGIN;
	private JTextField cmpLogin;
	private JPasswordField cmpSenha;
	private JFrame pnlPrincipal;
	private String senhatxt;
	
	public TelaLogin() {
		super("Login");
		
		pnlPrincipal = new JFrame("Loja Lupo - Estoque - Login");
		pnlPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pnlPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pnlPrincipal.setLocationRelativeTo(null);
		pnlPrincipal.setResizable(true);
		pnlPrincipal.getContentPane().setLayout(null);
		
		
		lblLOGIN = new JLabel("LOGIN");
		lblLOGIN.setForeground(Color.BLACK);
		lblLOGIN.setFont(new Font("Arial", Font.BOLD,36));
		lblLOGIN.setBounds(600, 100, 480, 30);
		pnlPrincipal.getContentPane().add(lblLOGIN);
		
		lblLogin = new JLabel("Matrícula:");
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Arial", Font.BOLD, 20));
		lblLogin.setBounds(400, 200, 100, 23);
		pnlPrincipal.getContentPane().add(lblLogin);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.BLACK);
		lblSenha.setFont(new Font("Arial", Font.BOLD,20));
		lblSenha.setBounds(400, 250, 70, 23);
		pnlPrincipal.getContentPane().add(lblSenha);
		
		cmpLogin = new JTextField(100);
		cmpLogin.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		cmpLogin.setColumns(100);
		cmpLogin.setBounds(510, 200, 400, 23);
		pnlPrincipal.getContentPane().add(cmpLogin);
		
		cmpSenha = new JPasswordField(100);
		cmpSenha.replaceSelection(senhatxt);
		cmpSenha.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		cmpSenha.setBounds(510, 250, 400, 23);
		pnlPrincipal.getContentPane().add(cmpSenha);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
		btnLogin.setBounds(480, 300, 100, 23);
		pnlPrincipal.getContentPane().add(btnLogin);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setFont(new Font("Arial", Font.BOLD, 20));
		btnSair.setBounds(650, 300, 100, 23);
		pnlPrincipal.getContentPane().add(btnSair);
		
		pnlPrincipal.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			
			FuncionarioSession fs = new FuncionarioSession();
			boolean acesso;
		
			acesso = fs.Login(Integer.parseInt(cmpLogin.getText()), cmpSenha.getText());
			
			if (acesso == true) {
				TelaMenu menu = new TelaMenu();
				
				pnlPrincipal.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Login ou senha inválido, ou usuário inativo");
			}
		}
		
		if (e.getSource() == btnSair) {
			pnlPrincipal.dispose();
		}
		
	}
	
	

}
