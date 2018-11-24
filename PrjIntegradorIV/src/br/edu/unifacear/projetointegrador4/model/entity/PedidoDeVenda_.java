package br.edu.unifacear.projetointegrador4.model.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-11-24T18:02:56.719-0200")
@StaticMetamodel(PedidoDeVenda.class)
public class PedidoDeVenda_ {
	public static volatile SingularAttribute<PedidoDeVenda, Long> id;
	public static volatile SingularAttribute<PedidoDeVenda, Cliente> cliente;
	public static volatile SingularAttribute<PedidoDeVenda, Date> data;
	public static volatile SingularAttribute<PedidoDeVenda, StatusPV> statusPV;
	public static volatile SingularAttribute<PedidoDeVenda, Boolean> status;
	public static volatile ListAttribute<PedidoDeVenda, PecasDoPedido> pecaspdv;
	public static volatile SingularAttribute<PedidoDeVenda, Double> totalPedido;
}
