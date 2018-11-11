package br.edu.unifacear.projetointegrador4.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.edu.unifacear.projetointegrador4.model.business.BusinessException;
import br.edu.unifacear.projetointegrador4.model.entity.Aplicacao;
import br.edu.unifacear.projetointegrador4.model.facade.FacadeAplicacao;
import io.swagger.annotations.Api;

@Path("/aplicacao")
@Api("/aplicacao")
public class AplicacaoRest {
	private FacadeAplicacao facade;
	
	public AplicacaoRest() {
		facade = new FacadeAplicacao();
	}
	
	
	@POST
	@Path("/inserir")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(Aplicacao a) {
		
		try {
			facade.inserir(a);
			
			return Response.status(201).entity("Aplicação inserida com sucesso!").build();
		} catch(BusinessException e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		
		try {
			return Response.status(201).entity(facade.listar(true)).build();
		} catch(BusinessException e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
	}
}
