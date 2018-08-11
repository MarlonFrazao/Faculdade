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

import br.edu.unifacear.model.Cargo;
import br.edu.unifacear.session.CargoSession;

@Path("/cargo")
public class CargoService {
	private CargoSession session;
	
	public CargoService() {
		session = new CargoSession();
	}
	
	@POST
	@Path("/inserir")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirCargo(Cargo car) {
		
		car.setId(session.proximoId());
		
		session.inserirCargo(car);
		
		String result = "Cargo cadastrado com sucesso!";
		return Response.status(201).entity(result).build();
	}
	
	@PUT
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarCargo(Cargo car) {
		session.atualizarCargo(car);
		
		String result = "Cargo Atualizado com sucesso!";
		return Response.status(201).entity(result).build();
	}
	
	@GET
	@Path("/listar")
	@Produces (MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		List <Cargo> lista = session.listarTodos();
		if(lista == null || lista.size()==0) {
			return Response.status(204).entity("Não há Cargos").build();
		}
		
		return Response.status(201).entity(lista).build();
	}
	
	@GET
	@Path("/obetrPorId")
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
