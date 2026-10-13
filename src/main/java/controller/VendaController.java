package controller;

import dto.VendaDto;
import infra.database.entity.Estoque;
import infra.database.entity.Produto;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import usecase.EstoqueUseCase;
import usecase.ProdutoUseCase;

@Path("/venda")
public class VendaController {

    @Inject
    protected EstoqueUseCase estoqueUseCase;

    @Inject
    protected ProdutoUseCase produtoUseCase;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void venda(VendaDto vendaDto) throws Exception {

        Produto produto = produtoUseCase.buscarProduto(vendaDto.getProdutoDTO().getNome());

        this.estoqueUseCase.adicionarProdutoNoEstoque(produto, vendaDto.getQuantidade());
    }
}
