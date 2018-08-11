package br.edu.unifacear.service;

import java.util.ArrayList;
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

import br.edu.unifacear.model.Entrada;
import br.edu.unifacear.session.EntradaSession;

@Path("/Entrada")
public class EntradaService {
	private EntradaSession esession;
	private Entrada en;
	
	
	public EntradaService () {
		esession = new EntradaSession();
		en = new Entrada();
	}
	
	@POST
	@Path("/inserir")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir (Entrada ent) {
		String result = "Entrada realizada com sucesso!";
		
		esession.inserirEntrada(ent);
		
		return Response.status(201).entity(result).build();
		
	}
	
	
	@PUT
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar (Entrada ent) {
		String result = "Entrada atualizada com sucesso!";
		
		esession.atualizarEntrada(ent);
		
		return Response.status(201).entity(result).build();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar () {
		List<Entrada> lista = new ArrayList<Entrada>();
		lista = esession.listarTodos();
		return Response.status(201).entity(lista).build();
	}
	
	
		
}
