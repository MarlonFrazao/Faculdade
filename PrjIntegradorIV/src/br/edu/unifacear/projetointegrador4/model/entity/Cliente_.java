package br.edu.unifacear.projetointegrador4.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-11-05T10:35:25.500-0200")
@StaticMetamodel(Cliente.class)
public class Cliente_ {
	public static volatile SingularAttribute<Cliente, Long> id;
	public static volatile SingularAttribute<Cliente, String> cpf;
	public static volatile SingularAttribute<Cliente, String> nome;
	public static volatile SingularAttribute<Cliente, String> endereco;
	public static volatile SingularAttribute<Cliente, String> email;
	public static volatile ListAttribute<Cliente, Telefone> telefone;
	public static volatile SingularAttribute<Cliente, TipoCliente> tipo;
	public static volatile SingularAttribute<Cliente, Long> senha;
	public static volatile SingularAttribute<Cliente, Boolean> status;
}
