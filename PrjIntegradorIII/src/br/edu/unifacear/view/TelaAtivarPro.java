package br.edu.unifacear.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.edu.unifacear.model.Cor;
import br.edu.unifacear.model.Produto;
import br.edu.unifacear.session.CorSession;
import br.edu.unifacear.session.ProdutoSession;

public class TelaAtivarPro extends JFrame implements ActionListener{
	private JButton btnSalvar, btnCancelar;
	private JLabel lblTitulo, lblNome, lblSalario;
	private JTextField txtNome, txtSalario;
	private JFrame pnlPrincipal;
	private Produto prod;
	
	public TelaAtivarPro(Produto pro) {
		super("Ativar Produto");
		prod = new Produto();
		prod = pro;
		pnlPrincipal = new JFrame("Ativar Produto");
		pnlPrincipal.setResizable(true);
		pnlPrincipal.setBounds(200, 400, 400, 270);
		pnlPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pnlPrincipal.setLocationRelativeTo(null);
		pnlPrincipal.getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Ativar Produto");
		lblTitulo.setForeground(Color.black);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		lblTitulo.setBounds(120, 25, 200, 25);
		pnlPrincipal.getContentPane().add(lblTitulo);
		
		lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.black);
		lblNome.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		lblNome.setBounds(20, 70, 70, 20);
		//pnlPrincipal.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setForeground(Color.black);
		txtNome.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		txtNome.setText(pro.getNome()+" será ativado.");
		txtNome.setEditable(false);
		txtNome.setBounds(95, 70, 220, 20);
		pnlPrincipal.getContentPane().add(txtNome);
		
		
		btnSalvar = new JButton("Ativar");
		btnSalvar.setForeground(Color.black);
		btnSalvar.setFont(new Font("Aria", Font.BOLD, 16));
		btnSalvar.setBounds(90, 140, 120, 20);
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
			ProdutoSession ps = new ProdutoSession();
			if(prod.isStatus()==true) {
				JOptionPane.showMessageDialog(null, "O produto já está ativado!");
			}else {
				JOptionPane.showMessageDialog(null,"Produto ativado com sucesso!");
				prod.setStatus(true);
				ps.atualizarProduto(prod);
			pnlPrincipal.dispose();
			TelaAtualizarProduto.refresh();
			}
			
			
		} else
		
			if (e.getSource() == btnCancelar) {
				pnlPrincipal.dispose();
			}
		
	}

}
