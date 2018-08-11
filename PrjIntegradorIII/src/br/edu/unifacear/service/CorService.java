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

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.edu.unifacear.model.Cor;
import br.edu.unifacear.session.CorSession;

@Path("/cor")
public class CorService {
	private CorSession corsession;
	private Cor c;
	private Gson gson;
	
	public CorService() {
		corsession = new CorSession();
	}
	
	@POST
	@Path("/inserir")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirCor(Cor c) {
		
		c.setId(corsession.proximoId());
		
		corsession.inserirCor(c);
		
		String result = "Cor cadastrada com sucesso!";
		return Response.status(201).entity(result).build();
	}
	
	@PUT
	@Path("/atualizar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarCor(Cor cor) {
		
		corsession.atualizarCor(cor);
		
		
		
		String result = "Cor atualizada com sucesso!";
		return Response.status(201).entity(result).build();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		List<Cor> lista = corsession.obter();
		if(lista == null || lista.size()==0) {
			return Response.status(204).entity("Não há cores").build();
		}
		return Response.status(200).entity(lista).build();
	}
	@GET
	@Path("/obterporid")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorId(@QueryParam("id")Long id) {
				
		
		return Response.status(201).entity(corsession.obter(id)).build();
	}
	
	@GET
	@Path("/obterpornome")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obetrPorNome(@QueryParam("nome")String nome) {
		return Response.status(201).entity(corsession.obterPorNome(nome)).build();
	}
	
	
}
