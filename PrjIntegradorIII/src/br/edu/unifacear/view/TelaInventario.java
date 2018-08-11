package br.edu.unifacear.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.edu.unifacear.model.Produto;
import br.edu.unifacear.session.ProdutoSession;
import br.edu.unifacear.util.TabelaConsulta;

public class TelaInventario extends JFrame implements ActionListener {
	
	private JFrame pnlPrincipal;
	private JButton btnSair, btnGerar, btnPDF;
	private JLabel lblInventario;
	private static TabelaConsulta modelo;
	private JScrollPane scroll;
	private JTable tabela;
	
	public TelaInventario() {
		super("Inventário");
		
		pnlPrincipal = new JFrame("Loja Lupo - Estoque - Inventário");
		pnlPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pnlPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pnlPrincipal.setLocationRelativeTo(null);
		pnlPrincipal.setResizable(true);
		pnlPrincipal.getContentPane().setLayout(null);
		
		lblInventario = new JLabel("Inventário");
		lblInventario.setForeground(Color.BLACK);
		lblInventario.setFont(new Font("Arial", Font.BOLD, 36));
		lblInventario.setBounds(600, 50, 480, 30);
		pnlPrincipal.getContentPane().add(lblInventario);
		
		btnGerar = new JButton("Gerar Invetário");
		btnGerar.setForeground(Color.BLACK);
		btnGerar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnGerar.setBounds(550, 650, 250, 23);
		btnGerar.addActionListener(this);
		pnlPrincipal.getContentPane().add(btnGerar);
		
		btnPDF = new JButton("PDF");
		btnPDF.setForeground(Color.BLACK);
		btnPDF.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnPDF.setBounds(810, 650, 150, 23);
		btnPDF.addActionListener(this);
		pnlPrincipal.getContentPane().add(btnPDF);
		
		btnSair = new JButton("Sair");
		btnSair.setForeground(Color.BLACK);
		btnSair.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnSair.setBounds(970, 650, 150, 23);
		btnSair.addActionListener(this);
		pnlPrincipal.getContentPane().add(btnSair);
		
		modelo = new TabelaConsulta();
		tabela = new JTable(modelo);
		tabela.addMouseListener(modelo);
		
		
		scroll = new JScrollPane(tabela);
		scroll.setBounds(150, 100, 1070, 500);
		pnlPrincipal.getContentPane().add(scroll);
		
		pnlPrincipal.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnGerar) {
			ProdutoSession ps = new ProdutoSession();
			List<Produto> lp = ps.obter();
			
			modelo.removeRow();
			
			for(int i = 0; i < lp.size(); i++) {
				modelo.addRow(lp.get(i));
			}
		} else if (e.getSource() == btnSair) {
			pnlPrincipal.dispose();
		} else if(e.getSource() == btnPDF) {
			MessageFormat titulo = new MessageFormat("Inventário");
			MessageFormat rodape = new MessageFormat ("Meias Lupo");
			
				try {
					this.tabela.print(JTable.PrintMode.FIT_WIDTH,titulo,rodape);
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		
	}
	
}
