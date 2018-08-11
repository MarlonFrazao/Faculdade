package br.edu.unifacear.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.edu.unifacear.model.Funcionario;
import br.edu.unifacear.session.FuncionarioSession;
import br.edu.unifacear.session.Login;

@Path("/funcionario")
public class FuncionarioService {
	private FuncionarioSession session;
	
	public FuncionarioService() {
		session = new FuncionarioSession();
	}
	
	@POST
	@Path("/inserir")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirFuncionario(Funcionario f) {
		session.inserirFuncionario(f);
		
		String result = "Funcionário inserido com sucesso!";
		return Response.status(201).entity(result).build();
	}
	
	@PUT
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarFuncionario(Funcionario f) {
		session.atualizarFuncionario(f);
		
		String result = "Funcionário atualizado com sucesso!";
		return Response.status(201).entity(result).build();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		List<Funcionario> lista = session.listarTodos();
		
		return Response.status(201).entity(lista).build();
	}
	
	@GET
	@Path("/listarqualificado")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos(@QueryParam("status") Boolean ativo) {
		return Response.status(201).entity(session.listarTodos(ativo)).build();
	}
	
	@GET
	@Path("/obterpormat")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorMat(@QueryParam("matricula") Long mat) {
		return Response.status(201).entity(session.obterPorMat(mat)).build();
	}
	
	@GET
	@Path("/obterpormatqualificado")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorMat(@QueryParam("matricula") Long mat, @QueryParam("status") Boolean ativo) {
		return Response.status(201).entity(session.obterPorMat(mat, ativo)).build();
	}
	
	@GET
	@Path("/obterpornome") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorNome(@QueryParam("nome") String nome) {
		return Response.status(201).entity(session.obterPorNome(nome)).build();
	}
	
	@GET
	@Path("/obterpornomequalificado") 
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorNome(@QueryParam("nome") String nome, @QueryParam("status") Boolean ativo) {
		return Response.status(201).entity(session.obterPorNome(nome, ativo)).build();
	}
	
	@GET
	@Path("/obterporidcargo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorCargo(@QueryParam("idcargo") Long idCargo) {
		return Response.status(201).entity(session.obterPorCargo(idCargo)).build();
	}
	
	@GET
	@Path("/obterporidcargoqualificado")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorCargo(@QueryParam("idcargo") Long idCargo, @QueryParam("status") Boolean ativo) {
		return Response.status(201).entity(session.obterPorCargo(idCargo, ativo)).build();
	}
	
	@GET
	@Path("/obterpornomecargo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorCargo(@QueryParam("nomecargo") String nomeCargo) {
		return Response.status(201).entity(session.obterPorCargo(nomeCargo)).build();
	}
	
	@GET
	@Path("/obterpornomecargoqualificado")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorCargo(@QueryParam("nomecargo") String nomeCargo, @QueryParam("status") Boolean ativo) {
		return Response.status(201).entity(session.obterPorCargo(nomeCargo, ativo)).build();
	}
	
	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@QueryParam("matricula") Long mat, @QueryParam("senha") String senha) {
		
		
		return Response.status(201).entity(session.Login(mat, senha)).build();
	}
}
