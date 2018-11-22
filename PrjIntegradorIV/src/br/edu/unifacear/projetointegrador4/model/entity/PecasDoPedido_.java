package br.edu.unifacear.projetointegrador4.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-11-22T20:01:41.505-0200")
@StaticMetamodel(PecasDoPedido.class)
public class PecasDoPedido_ {
	public static volatile SingularAttribute<PecasDoPedido, Long> id;
	public static volatile SingularAttribute<PecasDoPedido, Peca> id_peca;
	public static volatile SingularAttribute<PecasDoPedido, PedidoDeVenda> id_pdv;
}
