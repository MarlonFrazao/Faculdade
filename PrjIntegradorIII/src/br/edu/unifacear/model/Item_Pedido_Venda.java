package br.edu.unifacear.model;

import java.util.List;

public class Item_Pedido_Venda {
	
	private int id_prod_compra;
	private List<Produto> listaVen;
	
	
	
	
	
	public Item_Pedido_Venda(int id_prod_compra, List<Produto> listaVen) {
		super();
		this.id_prod_compra = id_prod_compra;
		this.listaVen = listaVen;
	}

	public List<Produto> getListaVen() {
		return listaVen;
	}

	public void setListaVen(List<Produto> listaVen) {
		this.listaVen = listaVen;
	}

	
	
	public Item_Pedido_Venda() {
		
	}
	
	public int getId_prod_compra() {
		return id_prod_compra;
	}
	public void setId_prod_compra(int id_prod_compra) {
		this.id_prod_compra = id_prod_compra;
	}
	
	
	
}
