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

import br.edu.unifacear.model.Saida;
import br.edu.unifacear.session.SaidaSession;

@Path("/Saida")
public class SaidaService {
	private SaidaSession session;
	private Saida saida;
	

	
	public SaidaService() {
		session = new SaidaSession();
		saida = new Saida();
	}
	
	@POST
	@Path("/inserir")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir (Saida sai) {
		String result = "Saida realizada com sucesso!";
		
		session.inserirSaida(sai);
		
		return Response.status(201).entity(result).build();
	}
	
	@PUT
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar (Saida sai) {
		String result = "Saida atualizada com sucesso!";
		
		session.atualizarSaida(sai);
		
		return Response.status(201).entity(result).build();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar () {
		List<Saida> lista = new ArrayList<Saida>();
		lista = session.listarTodos();
		
		return Response.status(201).entity(lista).build();
	}
	
	
}
