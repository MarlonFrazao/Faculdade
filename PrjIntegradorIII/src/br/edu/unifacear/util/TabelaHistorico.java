package br.edu.unifacear.util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import br.edu.unifacear.model.Historico;
import br.edu.unifacear.session.HistoricoSession;

public class TabelaHistorico extends AbstractTableModel implements MouseListener, TableColumnModel{
	private String[] colunas = {"Cod Entrada", "Data e Hora", "Descrição"};
	private List<Historico> lista;
	private JTable tabela;
	int coluna;
	int linha;
	private Historico historico;
	private HistoricoSession hs;
	
	public TabelaHistorico() {
		lista = new ArrayList<Historico>();
		tabela = new JTable();
		historico = new Historico();
		hs = new HistoricoSession();
	}
	
	public void removeRow () {
		this.lista.clear();
		this.fireTableDataChanged();
	}
	
	public void addRow(Historico h) {
		this.lista.add(h);
		this.fireTableDataChanged();
	}
	
	public String getColumnName(int num) {
		return this.colunas[num];
	}
	
	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0:
			return lista.get(rowIndex).getIdEntrada();
		case 1:
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			return formato.format(lista.get(rowIndex).getData());
		case 2:
			return lista.get(rowIndex).getDescricao();
		default:
			return null;
		}
		
	}

	@Override
	public void addColumn(TableColumn aColumn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeColumn(TableColumn column) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveColumn(int columnIndex, int newIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColumnMargin(int newMargin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Enumeration<TableColumn> getColumns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnIndex(Object columnIdentifier) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TableColumn getColumn(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColumnMargin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnIndexAtX(int xPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalColumnWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setColumnSelectionAllowed(boolean flag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getColumnSelectionAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] getSelectedColumns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSelectedColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSelectionModel(ListSelectionModel newModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListSelectionModel getSelectionModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addColumnModelListener(TableColumnModelListener x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeColumnModelListener(TableColumnModelListener x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
