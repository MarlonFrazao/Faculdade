package br.edu.unifacear.model;

import java.util.ArrayList;
import java.util.List;

public class Item_Pedido_Compra {
	
	private int id_prod_compra;
	
	private List<Produto> listaCom;
	

	
	public Item_Pedido_Compra(int id_prod_compra, List<Produto> listaCom) {
		super();
		this.id_prod_compra = id_prod_compra;
		this.listaCom = listaCom;
	}
	
	public Item_Pedido_Compra() {
		
	}
	public int getId_prod_compra() {
		return id_prod_compra;
	}
	public void setId_prod_compra(int id_prod_compra) {
		this.id_prod_compra = id_prod_compra;
	}
	

	public List<Produto> getListaCom() {
		return listaCom;
	}

	public void setListaCom(List<Produto> listaCom) {
		this.listaCom = listaCom;
	}
	
	

}
