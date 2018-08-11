package br.edu.unifacear.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.edu.unifacear.model.Tamanho;
import br.edu.unifacear.model.Unidade;
import br.edu.unifacear.session.TamanhoSession;
import br.edu.unifacear.session.UnidadeSession;

public class TelaCadastrarUnidade extends JFrame implements ActionListener{

	private JButton btnSalvar, btnCancelar;
	private JLabel lblTitulo, lblNome, lblSalario;
	private JTextField txtNome, txtSalario;
	private JFrame pnlPrincipal;
	
	public TelaCadastrarUnidade() {
		super("Nova Unidade");
		
		pnlPrincipal = new JFrame("Nova Unidade");
		pnlPrincipal.setResizable(true);
		pnlPrincipal.setBounds(200, 400, 400, 270);
		pnlPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pnlPrincipal.setLocationRelativeTo(null);
		pnlPrincipal.getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Nova Unidade");
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
			Unidade uni = new Unidade();
			UnidadeSession unid = new UnidadeSession();
			
			uni = new Unidade(unid.proximoId(), txtNome.getText(), true);
			
			unid.inserirUnidade(uni);
			
			pnlPrincipal.dispose();
			if(TelaCadastrarProduto.qualTela()==true) {
				TelaCadastrarProduto.refreshComboUni();
				}else if (TelaAtualizarProduto.qualTela()==true) {	
				TelaAtualizarProduto.refreshComboUni();
				}
		} else
		
			if (e.getSource() == btnCancelar) {
				pnlPrincipal.dispose();
			}
		
	}

}
