package controller;

import dto.CriaClienteDTO;
import dto.ProdutoDTO;
import infra.database.entity.Cliente;
import infra.database.entity.Produto;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import usecase.ProdutoUseCase;

import java.util.List;

@Path("/produto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoController {

    @Inject
    protected ProdutoUseCase produtoUseCase;

    @GET
    public List<Produto> listaProdutos() {
        return produtoUseCase.listaProdutos();
    }

    @POST
    public Produto criarProduto(ProdutoDTO produtoDTO) {
        return produtoUseCase.criaProduto(produtoDTO.getNome());
    }
}
