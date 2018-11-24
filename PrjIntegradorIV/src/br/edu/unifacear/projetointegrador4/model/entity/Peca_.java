package br.edu.unifacear.projetointegrador4.model.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-11-24T17:24:09.944-0200")
@StaticMetamodel(Peca.class)
public class Peca_ {
	public static volatile SingularAttribute<Peca, Long> id;
	public static volatile SingularAttribute<Peca, String> descricao;
	public static volatile ListAttribute<Peca, PecasDoPedido> pecasPdv;
	public static volatile ListAttribute<Peca, Peca_Modelo> peca_modelo;
	public static volatile SingularAttribute<Peca, Aplicacao> aplicacao;
	public static volatile SingularAttribute<Peca, Long> qtdeTotal;
	public static volatile SingularAttribute<Peca, String> adicional;
	public static volatile SingularAttribute<Peca, Date> dataCadastro;
	public static volatile SingularAttribute<Peca, Long> totalAvaliacao;
	public static volatile SingularAttribute<Peca, Float> mediaAvaliacao;
	public static volatile SingularAttribute<Peca, Long> numVisualizacao;
	public static volatile SingularAttribute<Peca, String> foto;
	public static volatile SingularAttribute<Peca, Boolean> status;
	public static volatile SingularAttribute<Peca, Double> valorPeca;
}
