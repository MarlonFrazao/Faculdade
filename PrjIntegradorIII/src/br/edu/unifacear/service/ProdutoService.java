package br.edu.unifacear.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.edu.unifacear.model.Categoria;
import br.edu.unifacear.model.Colecao;
import br.edu.unifacear.model.Cor;
import br.edu.unifacear.model.Genero;
import br.edu.unifacear.model.Produto;
import br.edu.unifacear.model.Situacao;
import br.edu.unifacear.model.Tamanho;
import br.edu.unifacear.session.CategoriaSession;
import br.edu.unifacear.session.ColecaoSession;
import br.edu.unifacear.session.CorSession;
import br.edu.unifacear.session.GeneroSession;
import br.edu.unifacear.session.ProdutoSession;
import br.edu.unifacear.session.SituacaoSession;
import br.edu.unifacear.session.TamanhoSession;

@Path("/produto")
public class ProdutoService {
	private ProdutoSession session;
	
	public ProdutoService() {
		session = new ProdutoSession();
	}
	
	@POST
	@Path("/inserir")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirProduto(Produto p) {
		if (p != null && session.validar(p) == true) {
			session.inserirProduto(p);

			String result = "Produto inserido com sucesso!";
			return Response.status(201).entity(result).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@PUT
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarProduto(Produto p) {
		if (p != null) {
			session.atualizarProduto(p);

			String result = "Produto atualizado com sucesso!";
			return Response.status(201).entity(result).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodos() {
		List<Produto> lista = session.obter();
		
		if(lista != null && lista.size() > 0) {
			return Response.status(201).entity(lista).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/obterativo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obter(@QueryParam("status") Boolean ativo) {
		List<Produto> lista = session.obter(ativo);
		
		if(lista != null && lista.size() > 0) {
			return Response.status(201).entity(lista).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/obterid")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorId(@QueryParam("id") Long id) {
		Produto p = session.obter(id);
		if(p != null) {
			return Response.status(201).entity(p).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/obternome")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorNome(@QueryParam("nome") String nome) {
		List<Produto> lista = session.obter(nome);
		
		if(lista != null && lista.size() > 0) {
			return Response.status(201).entity(lista).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/obternomeativo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorNome(@QueryParam("nome") String nome, @QueryParam("status") Boolean ativo) {
		List<Produto> lista = session.obter(nome, ativo);
		
		if(lista != null && lista.size() > 0) {
			return Response.status(201).entity(lista).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/obtercat")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorCat(@QueryParam("categoria") Long idCat) {
		CategoriaSession cs = new CategoriaSession();
		Categoria c = cs.obter(idCat);
		
		List<Produto> lista = session.obterPorCat(c);
		
		if(lista != null && lista.size() > 0) {
			return Response.status(201).entity(lista).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/obtercatativo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorCat(@QueryParam("categoria") Long idCat, @QueryParam("ativo") Boolean ativo) {
		CategoriaSession cs = new CategoriaSession();
		Categoria c = cs.obter(idCat);
		
		List<Produto> lista = session.obterPorCat(c, ativo);
		
		if(lista != null && lista.size() > 0) {
			return Response.status(201).entity(lista).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/obtercor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorCor(@QueryParam("cor") Long idCor) {
		CorSession cs = new CorSession();
		Cor c = cs.obter(idCor);
		
		List<Produto> lista = session.obterPorCor(c);
		
		if(lista != null && lista.size() > 0) {
			return Response.status(201).entity(lista).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/obtercorativo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorCor(@QueryParam("cor") Long idCor, @QueryParam("ativo") Boolean ativo) {
		CorSession cs = new CorSession();
		Cor c = cs.obter(idCor);
		
		List<Produto> lista = session.obterPorCor(c, ativo);
		
		if(lista != null && lista.size() > 0) {
			return Response.status(201).entity(lista).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/obtergen")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorGen(@QueryParam("genero") Long idGen) {
		GeneroSession gs = new GeneroSession();
		Genero g = gs.obter(idGen);
		
		List<Produto> lista = session.obterPorGen(g);
		
		if(lista != null && lista.size() > 0) {
			return Response.status(201).entity(lista).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/obtergenativo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorGen(@QueryParam("genero") Long idGen, @QueryParam("ativo") Boolean ativo) {
		GeneroSession gs = new GeneroSession();
		Genero g = gs.obter(idGen);
		
		List<Produto> lista = session.obterPorGen(g, ativo);
		
		if(lista != null && lista.size() > 0) {
			return Response.status(201).entity(lista).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/buscacruzada")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscaCruzada(@QueryParam("nome") String nome,
									@QueryParam("categoria") Long idCat,
									@QueryParam("cor") Long idCor,
									@QueryParam("genero") Long idGen,
									@QueryParam("tamanho") Long idTam,
									@QueryParam("colecao") Long idCol,
									@QueryParam("situacao") Long idSit,
									@QueryParam("ativo") Boolean ativo) {
		CategoriaSession cats = new CategoriaSession();
		Categoria cat = new Categoria();
		if(idCat > 0) {
			cat = cats.obter(idCat);
		} else {
			cat = null;
		}
		
		CorSession cors = new CorSession();
		Cor cor = new Cor();
		if(idCor > 0) {
			cor = cors.obter(idCor);
		} else {
			cor = null;
		}
		
		GeneroSession gs = new GeneroSession();
		Genero g = new Genero();
		if(idGen > 0) {
			g = gs.obter(idGen);
		} else {
			g = null;
		}
		
		TamanhoSession ts = new TamanhoSession();
		Tamanho t = new Tamanho();
		if(idTam > 0) {
			t = ts.obter(idTam);
		} else {
			t = null;
		}
		
		ColecaoSession cols = new ColecaoSession();
		Colecao col = new Colecao();
		if(idCol > 0) {
			col = cols.obter(idCol);
		} else {
			col = null;
		}
		
		SituacaoSession ss = new SituacaoSession();
		Situacao s = new Situacao();
		if(idSit > 0) {
			s = ss.obter(idSit); 
		} else {
			s = null;
		}
		
		List<Produto> lista = session.buscaCruzada(nome, cat, cor, g, t, col, s, ativo);
		
		if(lista != null && lista.size() > 0) {
			return Response.status(201).entity(lista).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/obtertam")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorTam(@QueryParam("tamanho") Long idTam) {
		TamanhoSession ts = new TamanhoSession();
		
		List<Produto> lista = session.obterPorTam(ts.obter(idTam));
		
		if(lista != null && lista.size() > 0) {
			return Response.status(201).entity(lista).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/obtertamativo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorTam(@QueryParam("tamanho") Long idTam, @QueryParam("ativo") Boolean ativo) {
		TamanhoSession ts = new TamanhoSession();
		
		List<Produto> lista = session.obterPorTam(ts.obter(idTam), ativo);
		
		if(lista != null && lista.size() > 0) {
			return Response.status(201).entity(lista).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/obtercol")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorCol(@QueryParam("colecao") Long idCol) {
		ColecaoSession cs = new ColecaoSession();
		
		List<Produto> lista = session.obterPorCol(cs.obter(idCol));
		
		if(lista != null && lista.size() > 0) {
			return Response.status(201).entity(lista).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/obtercolativo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorCol(@QueryParam("colecao") Long idCol, @QueryParam("ativo") Boolean ativo) {
		ColecaoSession cs = new ColecaoSession();
		
		List<Produto> lista = session.obterPorCol(cs.obter(idCol), ativo);
		
		if(lista != null && lista.size() > 0) {
			return Response.status(201).entity(lista).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/obtersit")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorSit(@QueryParam("situacao") Long idSit) {
		SituacaoSession ss = new SituacaoSession();
		
		List<Produto> lista = session.obterPorSit(ss.obter(idSit));
		
		if(lista != null && lista.size() > 0) {
			return Response.status(201).entity(lista).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@GET
	@Path("/obtersit")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPorSit(@QueryParam("situacao") Long idSit, @QueryParam("ativo") Boolean ativo) {
		SituacaoSession ss = new SituacaoSession();
		
		List<Produto> lista = session.obterPorSit(ss.obter(idSit), ativo);
		
		if(lista != null && lista.size() > 0) {
			return Response.status(201).entity(lista).build();
		} else {
			return Response.status(202).build();
		}
	}
	
	@DELETE
	@Path("/excluir")
	public Response excluirProduto(@QueryParam("produto") Long id) {
		Produto p = session.obter(id);
		
		if(p != null) {
			return Response.status(201).entity("Produto excluído com sucesso").build();
		} else {
			return Response.status(202).build();
		}
	}
}
