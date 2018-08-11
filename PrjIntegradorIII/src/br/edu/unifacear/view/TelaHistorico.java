package br.edu.unifacear.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import br.edu.unifacear.model.Entrada;
import br.edu.unifacear.model.Historico;
import br.edu.unifacear.session.HistoricoSession;

public class TelaHistorico extends JFrame implements ActionListener {

	private JButton btnConfirmar, btnSair;
	private JLabel lblTitulo, lblDescricao;
	private JTextArea txtDescricao;
	private Date data;
	private JFrame pnlPrincipal;
	private Long idEntrada;
	
	public TelaHistorico(Entrada entrada) {
		super("Historico");
		
		idEntrada = entrada.getId();
		
		pnlPrincipal = new JFrame("Loja Lupo - Estoque - Historico");
		pnlPrincipal.setBounds(200, 400, 400, 320);
		pnlPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pnlPrincipal.setResizable(true);
		pnlPrincipal.setLocationRelativeTo(null);
		pnlPrincipal.getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Histórico");
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		lblTitulo.setBounds(130, 15, 200, 25);
		pnlPrincipal.getContentPane().add(lblTitulo);
		
		lblDescricao = new JLabel("Motivo da Rejeição");
		lblDescricao.setForeground(Color.BLACK);
		lblDescricao.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		lblDescricao.setBounds(50, 50, 200, 20);
		pnlPrincipal.getContentPane().add(lblDescricao);
		
		txtDescricao = new JTextArea();
		txtDescricao.setLineWrap(true);
		txtDescricao.setForeground(Color.BLACK);
		txtDescricao.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		txtDescricao.setBounds(50, 75, 300, 140);
		pnlPrincipal.getContentPane().add(txtDescricao);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(this);
		btnConfirmar.setForeground(Color.BLACK);
		btnConfirmar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		btnConfirmar.setBounds(50, 235, 150, 20);
		pnlPrincipal.getContentPane().add(btnConfirmar);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setForeground(Color.BLACK);
		btnSair.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		btnSair.setBounds(210, 235, 150, 20);
		pnlPrincipal.getContentPane().add(btnSair);
		
		pnlPrincipal.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConfirmar) {
			data = new Date(System.currentTimeMillis());
			HistoricoSession hs = new HistoricoSession();
			
			hs.inserirHistorico(new Historico(idEntrada, data, txtDescricao.getText()));
			
			pnlPrincipal.dispose();
		} else if(e.getSource() == btnSair) {
			pnlPrincipal.dispose();
		}
		
	}

}
