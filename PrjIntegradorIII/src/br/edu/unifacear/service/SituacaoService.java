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


import br.edu.unifacear.model.Situacao;
import br.edu.unifacear.session.SituacaoSession;

@Path("/situacao")
public class SituacaoService {
	private SituacaoSession session;
	
	public SituacaoService () {
		session = new SituacaoSession();
		
	}
	
	@POST
	@Path("/inserir")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirSituacao(Situacao sit) {
		sit.setId(session.proximoId());
		
		session.inserirSituacao(sit);
		String result = "Situação cadastrada com sucesso!";
		return Response.status(201).entity(result).build();
	}
	
	@PUT
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarSituacao(Situacao sit) {
		session.atualizarSituacao(sit);
		
		String result = "Situação atualizada com sucesso!";
		
		return Response.status(201).entity(result).build();
		
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		List<Situacao> lista = session.obter();
		
		if(lista == null|| lista.size()==0) {
			return Response.status(204).entity("Não há situação!").build();
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
		return Response.status(201).entity(session.obter(nome)).build();
	}	
}
