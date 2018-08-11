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

import br.edu.unifacear.model.Colecao;
import br.edu.unifacear.session.ColecaoSession;

@Path("/colecao")
public class ColecaoService {
	private ColecaoSession session;
	
	public ColecaoService() {
		session = new ColecaoSession();
	}
	
	@POST
	@Path("/inserir")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirColecao(Colecao col) {
		col.setId(session.proximoId());
		
		session.inserirColecao(col);
		String result = "Coleção cadastrada com sucesso!";
		return Response.status(201).entity(result).build();
	}
	
	@PUT
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarColecao(Colecao col) {
		session.atualizarColecao(col);
		
		String result = "Coleção atualizada com sucesso!";
		
		return Response.status(201).entity(result).build();
		
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		List<Colecao> lista = session.obter();
		
		if(lista == null|| lista.size()==0) {
			return Response.status(204).entity("Não há coleçoes!").build();
		}
		
		return Response.status(201).entity(lista).build();
		
	}
	
	@GET
	@Path("/obterporid")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorId(@QueryParam("id")Long id) {
				
		
		return Response.status(201).entity(session.obter(id)).build();
	}
	
	@GET
	@Path("/obterpornome")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obetrPorNome(@QueryParam("nome")String nome) {
		return Response.status(201).entity(session.obterPorNome(nome)).build();
	}	
	
}
