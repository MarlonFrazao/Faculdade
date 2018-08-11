package br.edu.unifacear.view;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.TableUI;


import br.edu.unifacear.dao.EntradaDAO;
import br.edu.unifacear.model.Entrada;
import br.edu.unifacear.model.Historico;
import br.edu.unifacear.model.Produto;
import br.edu.unifacear.session.EntradaSession;
import br.edu.unifacear.session.HistoricoSession;
import br.edu.unifacear.util.Render;
import br.edu.unifacear.util.Render2;
import br.edu.unifacear.util.TabelaRelatorioEntrada;

public class TelaRelatorioEntrada extends JFrame implements ActionListener {
	
	private JFrame pnlPrincipal;
	private JButton btnBuscar, btnPDF, btnSair;
	private JLabel lblRelatorioEntrada, lblDataInicio, lblDataFim, lblExDI, lblExDF;
	private JTextField txtDataInicio, txtDataFim;
	private JTable tabela;
	private static TabelaRelatorioEntrada modelo;
	private JScrollPane scroll;
	private Render2 btnHistorico2;
	private Render btnHistorico;
	private static int verde=0, vermelho=0;
	
	public TelaRelatorioEntrada() {
		super("Relatório Entrada");
		
		pnlPrincipal = new JFrame("Loja Lupo - Estoque - Relatório de Entradas");
		pnlPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pnlPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pnlPrincipal.setLocationRelativeTo(null);
		pnlPrincipal.setResizable(true);
		pnlPrincipal.getContentPane().setLayout(null);
		
		lblRelatorioEntrada = new JLabel("Entradas");
		lblRelatorioEntrada.setForeground(Color.BLACK);
		lblRelatorioEntrada.setFont(new Font("Arial", Font.BOLD, 36));
		lblRelatorioEntrada.setBounds(600, 50, 480, 30);
		pnlPrincipal.getContentPane().add(lblRelatorioEntrada);
		
		lblDataInicio = new JLabel("Data Início:");
		lblDataInicio.setForeground(Color.BLACK);
		lblDataInicio.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblDataInicio.setBounds(250, 150, 120, 23);
		pnlPrincipal.getContentPane().add(lblDataInicio);
		
		lblDataFim = new JLabel("Data Fim:");
		lblDataFim.setForeground(Color.BLACK);
		lblDataFim.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		lblDataFim.setBounds(560, 150, 120, 23);
		pnlPrincipal.getContentPane().add(lblDataFim);
		
		lblExDI = new JLabel("dd/mm/aaaa");
		lblExDI.setForeground(Color.BLACK);
		lblExDI.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		lblExDI.setBounds(380, 125, 120, 23);
		pnlPrincipal.getContentPane().add(lblExDI);
		
		lblExDF = new JLabel("dd/mm/aaaa");
		lblExDF.setForeground(Color.BLACK);
		lblExDF.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		lblExDF.setBounds(680, 125, 120, 23);
		pnlPrincipal.getContentPane().add(lblExDF);
		
		txtDataInicio = new JTextField();
		txtDataInicio.setForeground(Color.BLACK);
		txtDataInicio.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		txtDataInicio.setBounds(380, 150, 150, 23);
		pnlPrincipal.getContentPane().add(txtDataInicio);
		
		txtDataFim = new JTextField();
		txtDataFim.setForeground(Color.BLACK);
		txtDataFim.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
		txtDataFim.setBounds(680, 150, 150, 23);
		pnlPrincipal.getContentPane().add(txtDataFim);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnBuscar.setBounds(860, 150, 150, 23);
		pnlPrincipal.getContentPane().add(btnBuscar);
		
		modelo = new TabelaRelatorioEntrada();
		tabela = new JTable(modelo);
		tabela.addMouseListener(modelo);
		
		EntradaSession eSession = new EntradaSession();
		HistoricoSession hs = new HistoricoSession();
		List<Historico> h = new ArrayList<Historico>();
		List<Entrada> lista = new ArrayList<Entrada>();
		lista = eSession.listarTodos();
		
		h = hs.listarTodos();
		
		//ALTERAR OS RENDERS
		
		btnHistorico2 = new Render2(tabela, 9,lista,h);
		//btnHistorico = new Render(tabela, 9);
		scroll = new JScrollPane(tabela);
		scroll.setBounds(50, 200, 1250, 400);
		pnlPrincipal.getContentPane().add(scroll);
		
		btnPDF = new JButton("PDF");
		btnPDF.addActionListener(this);
		btnPDF.setForeground(Color.BLACK);
		btnPDF.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnPDF.setBounds(600, 610, 100, 23);
		pnlPrincipal.getContentPane().add(btnPDF);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setForeground(Color.BLACK);
		btnSair.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		btnSair.setBounds(710, 610, 100, 23);
		pnlPrincipal.getContentPane().add(btnSair);
		
		pnlPrincipal.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			modelo.removeRow();
			if (txtDataInicio.getText().trim().equals("") && 
					txtDataFim.getText().trim().equals("")) {
				EntradaSession eSession = new EntradaSession();
				HistoricoSession hs = new HistoricoSession();
				List<Historico> h = new ArrayList<Historico>();
				List<Entrada> lista = new ArrayList<Entrada>();
				Historico hh = new Historico();
				
				List<Produto> lp = new ArrayList<Produto>();
				
				lista = eSession.listarTodos();
				
				h = hs.listarTodos();
				for (int i = 0; i < lista.size(); i++) {
					modelo.addRow(lista.get(i));
					for(int j = 0; j< lista.get(i).getListaProdutos().size();j++) {
						modelo.addRow2( lista.get(i).getListaProdutos().get(j));
					}
					//modelo.addRow(lista.get(i), lista.get(i).getListaProdutos().get(0));
				}
				
			} else if(!txtDataInicio.getText().trim().equals("") && 
						txtDataFim.getText().trim().equals("")) {
				EntradaSession eSession = new EntradaSession();
				
				List<Entrada> lista = new ArrayList<Entrada>();

				List<Produto> lp = new ArrayList<Produto>();
				
				try {
					lista = eSession.obterPorData(txtDataInicio.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				for (int i = 0; i < lista.size(); i++) {

					modelo.addRow(lista.get(i));
						for(int j = 0; j< lista.get(i).getListaProdutos().size();j++) {
							modelo.addRow2( lista.get(i).getListaProdutos().get(j));
						}

				}
			} else if(!txtDataInicio.getText().trim().equals("") &&
						!txtDataFim.getText().trim().equals("")) {
				EntradaSession eSession = new EntradaSession();
				
				List<Entrada> lista = new ArrayList<Entrada>();

				List<Produto> lp = new ArrayList<Produto>();
				
				try {
					lista = eSession.obterPorPeriodo(txtDataInicio.getText(), txtDataFim.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				for (int i = 0; i < lista.size(); i++) {
					modelo.addRow(lista.get(i));
					for(int j = 0; j< lista.get(i).getListaProdutos().size();j++) {
						modelo.addRow2( lista.get(i).getListaProdutos().get(j));
					}
					//modelo.addRow(lista.get(i), lista.get(i).getListaProdutos().get(0));

				}
			}
		} else if(e.getSource() == btnPDF) {
			
			MessageFormat titulo = new MessageFormat("Relatório de Entrada");
			MessageFormat rodape = new MessageFormat ("Meias Lupo");
			
				try {
					this.tabela.print(JTable.PrintMode.FIT_WIDTH,titulo,rodape);
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
		} else if(e.getSource() == btnSair) {
			pnlPrincipal.dispose();
		}

	}
	public static int vermelho() {
		return vermelho;
		
	}
	public static int verde() {
		return verde;
	}
	
}
