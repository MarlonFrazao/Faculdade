package br.edu.unifacear.WebService;



import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.edu.unifacear.model.Entrada;

public class EntradaWebService {
	
	public void inserirEntrada(Entrada ent) {
		Gson gson = new Gson();
		
		String json = gson.toJson(ent);
		
		Client client = Client.create();
		
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/entrada/inserir");
		
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);
		
		if(response.getStatus()!=201) {
			throw new RuntimeException ("Filed : HTTP error code: "+response.getStatus());
		}
	}
	
	public void atualizar(Entrada ent) {
		Gson gson = new Gson();
		
		String json = gson.toJson(ent);
		
		Client client = Client.create();
		
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/entrada/atualizar");
		ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);
		
		if(response.getStatus()!=201) {
			throw new RuntimeException("Failed : HTTP error code: "+response.getStatus());
		}
	}
	
	public List<Entrada> listarTodos(){
		Gson gson = new Gson();
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador/rest/entrada/listar");
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		
		if(response.getStatus()!=200) {
			String json = response.getEntity(String.class);
			List<Entrada> lista = gson.fromJson(json, new TypeToken<List<Entrada>>() {}.getType());
			return lista;
		}
		
		return null;
		
	}
	

}
