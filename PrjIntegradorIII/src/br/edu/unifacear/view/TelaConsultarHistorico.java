package br.edu.unifacear.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.edu.unifacear.model.Entrada;
import br.edu.unifacear.session.HistoricoSession;
import br.edu.unifacear.util.TabelaHistorico;

public class TelaConsultarHistorico extends JFrame implements ActionListener {
	private JLabel lblTitulo, lblPedido;
	private JButton btnSair, btnPDF;
	private JFrame pnlPrincipal;
	private TabelaHistorico modelo;
	private JScrollPane scroll;
	private JTable tabela;
	
	public TelaConsultarHistorico(Entrada entrada) {
		super("Consultar Histórico");
		
		pnlPrincipal = new JFrame("Loja Lupo - Estoque - Histórico da Entrada");
		pnlPrincipal.setBounds(100, 100, 1000, 600);
		pnlPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pnlPrincipal.setLocationRelativeTo(null);
		pnlPrincipal.setResizable(true);
		pnlPrincipal.getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Histórico");
		lblTitulo.setForeground(Color.black);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitulo.setBounds(425, 20, 150, 32);
		pnlPrincipal.getContentPane().add(lblTitulo);
		
		lblPedido = new JLabel("Nº do Pedido: " + entrada.getPedidoCompra());
		lblPedido.setForeground(Color.black);
		lblPedido.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblPedido.setBounds(70, 50, 150, 23);
		pnlPrincipal.getContentPane().add(lblPedido);
		
		modelo = new TabelaHistorico();
		
		HistoricoSession hs = new HistoricoSession();
		
		for(int i = 0; i < hs.obterPorId(entrada.getId()).size(); i++) {
			modelo.addRow(hs.obterPorId(entrada.getId()).get(i));
		}
		tabela = new JTable(modelo);
		tabela.getColumnModel().getColumn(0).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(600);
		
		
		scroll = new JScrollPane(tabela);
		scroll.setBounds(50, 100, 900, 400);
		pnlPrincipal.getContentPane().add(scroll);
		
		pnlPrincipal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
