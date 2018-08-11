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

import br.edu.unifacear.model.Categoria;
import br.edu.unifacear.session.CategoriaSession;

@Path("/categoria")
public class CategoriaService {
	private CategoriaSession session;
	private Categoria cat;
	
	@POST
	@Path ("/inserir")
	@Consumes (MediaType.APPLICATION_JSON)
	public Response inserirCategoria(Categoria cat) {
		cat.setId(session.proximoId());
		
		session.inserirCategoria(cat);
		String result = ("Categoria Cadastrada com sucesso!");
		return Response.status(201).entity(result).build();
	}
	
	@PUT
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarCategoria(Categoria cat) {
		
		session.atualizarCategoria(cat);
		
		String result = "Categoria atualizada com sucesso!";
		return Response.status(201).entity(result).build();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		List<Categoria> lista = session.obter();
		
		if(lista == null || lista.size()==0) {
			return Response.status(204).entity("Não há categoria").build();
		}
		
		return Response.status(201).entity(lista).build();
	}
	
	@GET
	@Path("/obterPorId")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorId(@QueryParam("id")Long id) {
		return Response.status(201).entity(session.obter(id)).build();
		
	}
	
	@GET
	@Path("/obterPorNome")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorNome(@QueryParam("nome")String nome) {
		return Response.status(201).entity(session.obter(nome)).build();
	}
	
}
