package controller;

import dto.EstoqueDTO;
import dto.ProdutoDTO;
import infra.database.entity.Estoque;
import infra.database.entity.Produto;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import usecase.EstoqueUseCase;
import usecase.ProdutoUseCase;

import java.util.List;

@Path("/estoque")
public class EstoqueController {

    @Inject
    protected EstoqueUseCase estoqueUseCase;

    @Inject
    protected ProdutoUseCase produtoUseCase;

    @GET
    public List<Estoque> consultaEstoque() {
        return estoqueUseCase.listaEstoque();
    }

    @Path("/{produto}")
    @GET
    public List<Estoque> consultaEstoque(@PathParam(value = "produto") String nomeProduto) {
        return estoqueUseCase.listaEstoque();
    }

    @Path("/remover")
    @POST
    public Estoque removerEstoque(EstoqueDTO estoqueDTO) throws Exception {
        Produto produto = produtoUseCase.buscarProduto(estoqueDTO.getProdutoDTO().getNome());
        return estoqueUseCase.removerProdutodoEstoque(produto, estoqueDTO.getQuantidade());
    }

    @Path("/adicionar")
    @POST
    public Estoque adicionarEstoque(EstoqueDTO estoqueDTO) throws Exception {
        Produto produto = produtoUseCase.buscarProduto(estoqueDTO.getProdutoDTO().getNome());
        return estoqueUseCase.adicionarProdutoNoEstoque(produto, estoqueDTO.getQuantidade());
    }
}
