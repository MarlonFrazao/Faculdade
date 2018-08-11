package br.edu.unifacear.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.FileVisitResult;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.edu.unifacear.dao.FuncionarioDAO;
import br.edu.unifacear.model.Funcionario;
import br.edu.unifacear.session.FuncionarioSession;
import br.edu.unifacear.util.ModeloTabela;

public class TelaDesativarFuncionario extends JFrame implements ActionListener{
	
		private JButton btnSim,btnNao;
		private JFrame pnlPrincipal;
		private JLabel lblRegistro;
		private Funcionario func ;
		private FuncionarioSession funcSession;
		private ModeloTabela modelo;



	public TelaDesativarFuncionario(Funcionario func) {
		super("Desativar Funcionário");
		
		this.func = func;
		
		pnlPrincipal = new JFrame("Loja Lupo - Estoque - Consulta de Funcionario");
		pnlPrincipal.setBounds(0, 0, 560, 320);
		pnlPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pnlPrincipal.setLocationRelativeTo(null);
		pnlPrincipal.setResizable(false);
		pnlPrincipal.getContentPane().setLayout(null);
		
		btnSim = new JButton("Sim");
		btnSim.setBounds(160, 250, 100, 30);
		btnSim.addActionListener(this);
		btnSim.setVisible(true);
		pnlPrincipal.getContentPane().add(btnSim);
		
		btnNao = new JButton("Não");
		btnNao.setBounds(300, 250, 100, 30);
		btnNao.addActionListener(this);
		btnNao.setVisible(true);
		pnlPrincipal.getContentPane().add(btnNao);
		
		lblRegistro = new JLabel();
		lblRegistro.setText("Deseja desativar o cadastro de "+func.getNome()+" Matricula "+func.getMatricula()+"?");
		lblRegistro.setForeground(Color.BLACK);
		lblRegistro.setFont(new Font ("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 14));
		lblRegistro.setBounds(10,10,420,23);
		pnlPrincipal.getContentPane().add(lblRegistro);
		
		
		
		
		
		pnlPrincipal.setVisible(true);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		if(e.getSource()==btnSim) {
			if(func.isStatus()==true) {
			funcSession = new FuncionarioSession();	
			funcSession.excluirFuncionario(this.func);
			pnlPrincipal.dispose();
			TelaConsultarFuncionario.refreshTabela();
			}else if (func.isStatus()==false) {
				JOptionPane.showMessageDialog(null, "Funcionário já se encontra inativo!");
			}
			
			
		}
		if(e.getSource() == btnNao) {
			pnlPrincipal.dispose();
		}
		
	}

}
