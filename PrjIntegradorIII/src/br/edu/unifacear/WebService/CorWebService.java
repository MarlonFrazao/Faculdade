package br.edu.unifacear.WebService;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.edu.unifacear.model.Cor;

public class CorWebService {
	
	public void inserirCor(Cor cor) {
		Gson gson = new Gson();
		
		String json = gson.toJson(cor);
		
		Client client = Client.create();
		
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/cor/inserir");
		
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json );
		
		
		if(response.getStatus()!=201) {
			throw new RuntimeException("Failed : HTTP error code: "+response.getStatus());
		}
		
	}
	
	public void atualizar(Cor cor) {
		Gson gson = new Gson();
		
		String json = gson.toJson(cor);
		
		Client client = Client.create();
		
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/cor/atualizar");
		ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);
		
		if(response.getStatus()!=201) {
			throw new RuntimeException("Failed : HTTP error code: "+response.getStatus());
			
		}
		
	}
	
	public List<Cor> listarTodos(){
		Gson gson = new Gson();
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/cor/listar");
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		
		if(response.getStatus()!=200) {
			String json = response.getEntity(String.class);
			List<Cor> lista = gson.fromJson(json, new TypeToken<List<Cor>>() {}.getType());
			return lista;
		}
		
		return null;
	}
	

}
