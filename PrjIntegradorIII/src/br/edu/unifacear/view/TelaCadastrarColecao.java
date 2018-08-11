package br.edu.unifacear.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.edu.unifacear.model.Colecao;
import br.edu.unifacear.model.Tamanho;
import br.edu.unifacear.session.ColecaoSession;
import br.edu.unifacear.session.TamanhoSession;

public class TelaCadastrarColecao extends JFrame implements ActionListener {

	private JButton btnSalvar, btnCancelar;
	private JLabel lblTitulo, lblNome, lblSalario;
	private JTextField txtNome, txtSalario;
	private JFrame pnlPrincipal;
	
	public TelaCadastrarColecao() {
		super("Nova Cole��o");
		
		pnlPrincipal = new JFrame("Nova Cole��o");
		pnlPrincipal.setResizable(true);
		pnlPrincipal.setBounds(200, 400, 400, 270);
		pnlPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pnlPrincipal.setLocationRelativeTo(null);
		pnlPrincipal.getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Nova Cole��o");
		lblTitulo.setForeground(Color.black);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		lblTitulo.setBounds(120, 25, 200, 25);
		pnlPrincipal.getContentPane().add(lblTitulo);
		
		lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.black);
		lblNome.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		lblNome.setBounds(20, 70, 70, 20);
		pnlPrincipal.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setForeground(Color.black);
		txtNome.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		txtNome.setBounds(95, 70, 220, 20);
		pnlPrincipal.getContentPane().add(txtNome);
		
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.black);
		btnSalvar.setFont(new Font("Aria", Font.BOLD, 16));
		btnSalvar.setBounds(100, 140, 100, 20);
		btnSalvar.addActionListener(this);
		pnlPrincipal.getContentPane().add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.black);
		btnCancelar.setFont(new Font("Aria", Font.BOLD, 16));
		btnCancelar.setBounds(210, 140, 120, 20);
		btnCancelar.addActionListener(this);
		pnlPrincipal.getContentPane().add(btnCancelar);
		
		pnlPrincipal.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalvar) {
			Colecao col = new Colecao();
			ColecaoSession cole = new ColecaoSession();
			
			col = new Colecao(cole.proximoId(), txtNome.getText(), true);
			
			cole.inserirColecao(col);
			
			pnlPrincipal.dispose();
			
			if(TelaCadastrarProduto.qualTela()==true) {
				TelaCadastrarProduto.refreshComboCol();
				}else if (TelaAtualizarProduto.qualTela()==true) {	
				TelaAtualizarProduto.refreshComboCol();
				}
		} else
		
			if (e.getSource() == btnCancelar) {
				pnlPrincipal.dispose();
			}
		
	}

}
