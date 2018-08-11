package br.edu.unifacear.util;

import java.awt.Button;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.plaf.ButtonUI;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import br.edu.unifacear.dao.FuncionarioDAO;
import br.edu.unifacear.model.Funcionario;
import br.edu.unifacear.session.FuncionarioSession;
import br.edu.unifacear.view.TelaAtualizarFuncionario;
import br.edu.unifacear.view.TelaConsultarFuncionario;
import br.edu.unifacear.view.TelaDesativarFuncionario;
import br.edu.unifacear.view.TelaVisualizarFuncionario;

public class ModeloTabela extends AbstractTableModel implements MouseListener, TableColumnModel {
	private String[] colunas = {"Matrícula", "Nome", "Cargo", "Status","Visualizar","Alterar","Excluir"};
	private List<Funcionario> lista;
	private JTable tb1;
	MouseEvent e;
	int column;
	int row;
	private Funcionario func;
	private FuncionarioDAO funcDAO;
	
	
	public ModeloTabela () {
		lista = new ArrayList<Funcionario>();
		tb1 = new JTable();
		func = new Funcionario();
		funcDAO = new FuncionarioDAO();
		
	}
	

	public void removeRow () {
		this.lista.clear();
		this.fireTableDataChanged();
	}
	
	public void addRow(Funcionario f) {
		this.lista.add(f);
		this.fireTableDataChanged();
	}
	
	public String getColumnName(int num) {
		return this.colunas[num];
	}
	

	@Override
	public int getColumnCount() {
		
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		
		return lista.size();
	}
	
	

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch(coluna) {
			case 0 :
				return lista.get(linha).getMatricula();
				
			case 1 :
				return lista.get(linha).getNome();
				
			case 2 :
				return lista.get(linha).getCargo().getNome();
				
			case 3 : 
				if (lista.get(linha).isStatus() == true) {
					return "Ativo";
				} else {
					return "Inativo";
				}
			
			case 4 :
				if(lista.get(linha) != null ) {
					return "Visualizar";
				}
			case 5:
				if (lista.get(linha)!= null) {
					//mouseClicked(e);
					
					return "Alterar";
				}
			case 6 :
				if (lista.get(linha)!= null) {
					//mouseClicked(e);
					
					return "Excluir";
				}
			default :
				return null;
				
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
				
			
		
			column = getColumnIndexAtX(e.getX());
			row = e.getY() / tb1.getRowHeight();
			
		
		if(column == 4 ) {
			
			func = lista.get(row);
			TelaVisualizarFuncionario vis = new TelaVisualizarFuncionario(func);
			TelaConsultarFuncionario.fechar();
		}
		if (column == 5) {
			func = lista.get(row);
			
			TelaAtualizarFuncionario a = new TelaAtualizarFuncionario(func);
			//TelaConsultarFuncionario.fechar();
			
		}
		if (column == 6) {
			func = lista.get(row);
			TelaDesativarFuncionario desativa = new TelaDesativarFuncionario(func);
		}
		
				
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addColumn(TableColumn aColumn) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addColumnModelListener(TableColumnModelListener x) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public TableColumn getColumn(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getColumnIndex(Object columnIdentifier) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getColumnIndexAtX(int xPosition) {
		if(xPosition >= 456 && xPosition <= 568) {
			return 4;
		}
		else if (xPosition >= 571 && xPosition <= 682) {
			return 5;
		} else if (xPosition >= 684 && xPosition <= 795) {
			return 6;
		}
		return 0;
	}


	@Override
	public int getColumnMargin() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean getColumnSelectionAllowed() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Enumeration<TableColumn> getColumns() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getSelectedColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int[] getSelectedColumns() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ListSelectionModel getSelectionModel() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getTotalColumnWidth() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void moveColumn(int columnIndex, int newIndex) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeColumn(TableColumn column) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeColumnModelListener(TableColumnModelListener x) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setColumnMargin(int newMargin) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setColumnSelectionAllowed(boolean flag) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setSelectionModel(ListSelectionModel newModel) {
		// TODO Auto-generated method stub
		
	}
	
	

}
