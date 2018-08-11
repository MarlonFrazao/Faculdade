package br.edu.unifacear.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.CellEditorListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.w3c.dom.views.AbstractView;

import br.edu.unifacear.model.Entrada;
import br.edu.unifacear.model.Historico;
import br.edu.unifacear.view.TelaRelatorioEntrada;

public class Render2 extends AbstractCellEditor
		implements TableCellRenderer, TableCellEditor, ActionListener, MouseListener {

	JTable tbl;
	JButton renderButton;
	JButton editButton;
	String text;
	Boolean clica;
	MouseEvent e, evento;
	int column, row ;
	List<Entrada> entrada;
	static List<Historico> historico;
	boolean aux;
	static int i=0;
	Long x;
	
	public Render2(JTable tbl, int column,List<Entrada> ent, List<Historico> hist) {
		super();

		this.tbl = tbl;
		renderButton = new JButton();
		clica = true;
		editButton = new JButton();
		editButton.setFocusPainted(true);
		editButton.addActionListener(this);
		entrada = new ArrayList<Entrada>();
		historico = new ArrayList<Historico>();
		
		entrada = ent;
		historico = hist;
		//contaI();
		System.out.println("ninguém me ouve");
		//System.out.println("construtor i: "+i);
		
		
		
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(column).setCellRenderer(this);
		columnModel.getColumn(column).setCellEditor(this);
		
		//mouseClicked(e);
		//mouseReleased(e);
	}
		
	
	@Override
	public Object getCellEditorValue() {

		return null;
	}

	@Override
	public void addCellEditorListener(CellEditorListener arg0) {

		super.addCellEditorListener(arg0);
	}

	@Override
	public boolean isCellEditable(EventObject arg0) {
		// TODO Auto-generated method stub
		return super.isCellEditable(arg0);
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 9) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean shouldSelectCell(EventObject arg0) {
		// TODO Auto-generated method stub
		return super.shouldSelectCell(arg0);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		text = (value == null) ? "" : value.toString();
		editButton.setText(text);
		
		return editButton;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
			if (hasFocus) {
				renderButton.setForeground(table.getForeground());
				renderButton.setBackground((Color) UIManager.getColor("Button.background"));
				
			} else if (isSelected) {
				renderButton.setForeground(table.getSelectionForeground());
				renderButton.setBackground(table.getSelectionBackground());
				
			} else {
				renderButton.setForeground(table.getForeground());
				renderButton.setBackground(UIManager.getColor("Button.background"));
				
			}
			
			List<Historico> lh = new ArrayList<Historico>();
			for(int i = 0; i < historico.size(); i++) {
				if (historico.get(i).getIdEntrada() == entrada.get(row).getId()) {
					
					
					lh.add(historico.get(i));
				}
			}
			
			if(lh.get(lh.size() - 1).getDescricao().equals("Entrada OK")) {
				renderButton.setForeground(table.getForeground());
				renderButton.setBackground(Color.GREEN);
			} else {
				renderButton.setForeground(table.getForeground());
				renderButton.setBackground(Color.red);
			}
			
		renderButton.setText((value == null) ? "" : value.toString());
		return renderButton;
		}
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		

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
		JOptionPane.showMessageDialog(null, "Clicou");

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
		

	}
	

}
