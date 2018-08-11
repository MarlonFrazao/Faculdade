package br.edu.unifacear.WebService;

import java.net.CacheResponse;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.edu.unifacear.model.Saida;

public class SaidaWebService {
	
	public void inserirSaida(Saida saida) {
		Gson gson = new Gson();
		String json = gson.toJson(saida);
		Client client = Client.create();
		
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/saida/inserir");
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,json);
		
		
		if(response.getStatus()!=201) {
			throw new RuntimeException("Failed : HTTP error code: "+response.getStatus());
		}
	}
	
	public void atualizar (Saida saida) {
		Gson gson = new Gson();
		
		String json = gson.toJson(saida);
		
		Client client = Client.create();
		
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/saida/atualizar");
		ClientResponse response = webResource.type("application/json").put(ClientResponse.class,json);
		
		if(response.getStatus()!=201) {
			throw new RuntimeException("Failed : HTTP error code: "+response.getStatus());
		}
	}
	
	public List<Saida> listarTodos(){
		Gson gson = new Gson();
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/saida/listar");
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		
		if(response.getStatus()!=200) {
			String json = response.getEntity(String.class);
			List<Saida> lista = gson.fromJson(json, new TypeToken<List<Saida>>() {}.getType());
			return lista;
		}
		return null;
	}

}
