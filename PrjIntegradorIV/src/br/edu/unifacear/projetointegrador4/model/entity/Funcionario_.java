package br.edu.unifacear.projetointegrador4.model.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-10-18T13:54:28.519-0300")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ {
	public static volatile SingularAttribute<Funcionario, Long> id;
	public static volatile SingularAttribute<Funcionario, String> nome;
	public static volatile SingularAttribute<Funcionario, String> cpf;
	public static volatile ListAttribute<Funcionario, Telefone> telefone;
	public static volatile SingularAttribute<Funcionario, Cargo> cargo;
	public static volatile SingularAttribute<Funcionario, Long> senha;
	public static volatile SingularAttribute<Funcionario, Boolean> status;
}
