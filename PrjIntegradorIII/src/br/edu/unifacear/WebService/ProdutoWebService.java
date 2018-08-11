package br.edu.unifacear.WebService;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.edu.unifacear.model.Categoria;
import br.edu.unifacear.model.Cor;
import br.edu.unifacear.model.Genero;
import br.edu.unifacear.model.Produto;
import br.edu.unifacear.session.ProdutoSession;

public class ProdutoWebService {
	private Produto produto;
	private ProdutoSession session;
	
	
	public void inserirProduto(Produto produto) {
		Gson gson = new Gson();
		
		String json = gson.toJson(produto);
		
		Client client = Client.create();
		
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/produto/inserir");
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,json);
		
		if(response.getStatus()!=201) {
			throw new RuntimeException("Failed : HTTP error code: "+response.getStatus());
		}
	}
	
	public void atualizar (Produto pro) {
		Gson gson = new Gson();
		String json = gson.toJson(pro);
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/produtoatualizar");
		ClientResponse response = webResource.type("application/json").put(ClientResponse.class,json);
		if(response.getStatus()!=201) {
			throw new RuntimeException("Failed : HTTP error code: "+response.getStatus());
		}
	}
	
	public List<Produto> listarTodos(){
		Gson gson = new Gson();
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/produto/listar");
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		
		if(response.getStatus()!=200) {
			String json = response.getEntity(String.class);
			List<Produto> lista = gson.fromJson(json, new TypeToken<List<Produto>>() {}.getType());
			return lista;
		}
		
		return null;
	}
	
	public List<Produto> obterAtivo(Boolean ativo){
		Gson gson = new Gson();
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/produto/obterativo?ativo="+ativo);
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		
		if(response.getStatus()!=200) {
			throw new RuntimeException("Failed : HTTP error code: "+response.getStatus());
		}
		
		String json = response.getEntity(String.class);
		List<Produto> lista = (List<Produto>) gson.fromJson(json, Produto.class);
		
		return lista;
	}
	
	public Produto obterPorId(Long id){

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/produto/obterid?id=" + id);

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}

		String json = response.getEntity(String.class);

		Gson gson = new Gson();
		Produto pro = gson.fromJson(json, Produto.class);
		
		
		return pro;
		
	}
	public Produto obterPorNome(String nome){

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/produto/obternome?nome=" + nome);

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}

		String json = response.getEntity(String.class);

		Gson gson = new Gson();
		Produto pro = gson.fromJson(json, Produto.class);
		
		
		return pro;
	}
	
	public Produto obterPorNomeAtivo(String nome, boolean ativo){

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/produto/obternomeativo?nome= +"+nome+"?ativo="+ativo);

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}

		String json = response.getEntity(String.class);

		Gson gson = new Gson();
		Produto pro = gson.fromJson(json, Produto.class);
		
		
		return pro;
	}
	
	public List<Produto> obterPorCat(Categoria cat){

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/produto/obtercat?categoria="+cat);

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}

		String json = response.getEntity(String.class);

		Gson gson = new Gson();
		Produto pro = gson.fromJson(json, Produto.class);
		List<Produto> lista = (List<Produto>) gson.fromJson(json, Produto.class);
		
		return lista;
	}
	
	public List<Produto> obterPorCatAtivo(Categoria cat, boolean ativo){

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/produto/obtercatativo?categoria="+cat+"ativo="+ativo);

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}

		String json = response.getEntity(String.class);

		Gson gson = new Gson();
		List<Produto> lista = (List<Produto>) gson.fromJson(json, Produto.class);
		
		
		return lista;
	}
	
	public List<Produto> obterPorCor(Cor cor){

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/produto/obtercor?cor="+cor);

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}

		String json = response.getEntity(String.class);

		Gson gson = new Gson();
		List<Produto> lista = (List<Produto>) gson.fromJson(json, Produto.class);
		
		
		return lista;
	}
	
	public List<Produto> obterPorCorAtivo(Cor cor, boolean ativo){

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/produto/obtercorativo?cor="+cor+"ativo="+ativo);

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}

		String json = response.getEntity(String.class);

		Gson gson = new Gson();
		List<Produto> lista = (List<Produto>) gson.fromJson(json, Produto.class);
		
		
		return lista;
	}
	
	public List<Produto> obterPorGen(Genero gen){

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/produto/obtergen?genero="+gen);

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}

		String json = response.getEntity(String.class);

		Gson gson = new Gson();
		List<Produto> lista = (List<Produto>) gson.fromJson(json, Produto.class);
		
		
		return lista;
	}
	
	public List<Produto> obterPorGenAtivo(Genero gen, boolean ativo){

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/PrjIntegrador3/rest/produto/obtergenativo?genero="+gen+"ativo="+ativo);

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}

		String json = response.getEntity(String.class);

		Gson gson = new Gson();
		List<Produto> lista = (List<Produto>) gson.fromJson(json, Produto.class);
		
		
		return lista;
	}

}
