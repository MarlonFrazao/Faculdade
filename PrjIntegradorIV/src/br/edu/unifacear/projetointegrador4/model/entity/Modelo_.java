package br.edu.unifacear.projetointegrador4.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-10-08T16:18:39.838-0300")
@StaticMetamodel(Modelo.class)
public class Modelo_ {
	public static volatile SingularAttribute<Modelo, Long> id;
	public static volatile SingularAttribute<Modelo, String> descricao;
	public static volatile SingularAttribute<Modelo, Montadora> montadora;
	public static volatile SingularAttribute<Modelo, LinhaDeVeiculo> linha;
	public static volatile SingularAttribute<Modelo, Integer> ano;
	public static volatile SingularAttribute<Modelo, Boolean> status;
	public static volatile ListAttribute<Modelo, Peca_Modelo> peca_modelo;
}
