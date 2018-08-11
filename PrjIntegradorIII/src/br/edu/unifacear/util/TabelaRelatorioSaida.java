package br.edu.unifacear.util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import br.edu.unifacear.dao.SaidaDAO;
import br.edu.unifacear.model.Saida;
import br.edu.unifacear.model.Produto;
import br.edu.unifacear.session.SaidaSession;
import br.edu.unifacear.session.ProdutoSession;

public class TabelaRelatorioSaida extends AbstractTableModel implements MouseListener, TableColumnModel {
	private String[] colunas = { "Cod Saida", "Cod Pedido", "Cod Produto", "Desc Produto", "Qtde Produto", "Data",
			"Responsável", "Matrícula do Resp", "Cargo do Resposável" };
	private List<Saida> lista;
	private List<Produto> lista2;
	private JTable tabela;
	MouseEvent e;
	int coluna;
	int linha;
	private Saida saida;
	private SaidaDAO DAO;
	private Produto prod;
	private SaidaSession sessionSaida;
	private ProdutoSession prs;

	public TabelaRelatorioSaida() {
		lista = new ArrayList<Saida>();
		lista2 = new ArrayList<Produto>();
		tabela = new JTable();
		saida = new Saida();
		DAO = new SaidaDAO();
		sessionSaida = new SaidaSession();
		prs = new ProdutoSession();
		prod = new Produto();
	}

	public void removeRow() {
		this.lista.clear();
		this.fireTableDataChanged();
	}

	public void addRow(Saida s) {
		this.lista.add(s);
		
		this.fireTableDataChanged();
	}
	public void addRow2(Produto pro) {
		this.lista2.add(pro);
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
		switch (columnIndex) {
		case 0:
			return lista.get(rowIndex).getId();
		case 1:
			return lista.get(rowIndex).getPedidoVenda();
		case 2:

			return lista2.get(rowIndex).getId();

		case 3:
			return lista2.get(rowIndex).getNome();
		case 4:
			return lista2.get(rowIndex).getQtdeSaida();
		case 5:
			return lista.get(rowIndex).getDataSaida();
		case 6:
			return lista.get(rowIndex).getFuncionario().getNome();
		case 7:
			return lista.get(rowIndex).getFuncionario().getMatricula();
		case 8:
			return lista.get(rowIndex).getFuncionario().getCargo().getNome();
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
