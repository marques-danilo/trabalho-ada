package usecase;

import infra.database.entity.Estoque;
import infra.database.entity.Produto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class EstoqueUseCase {

    public List<Estoque> listaEstoque() {
        return Estoque.listAll();
    }

    public Estoque buscaEstoque(String nomeProduto) {
        return (Estoque) Estoque.find("produto.nome", nomeProduto).firstResultOptional().orElse(null);
    }

    @Transactional
    public Estoque adicionarProdutoNoEstoque(Produto produto, int quantidade) throws Exception {
        if (quantidade < 0) {
            throw new Exception("Quantidade inválida!");
        }

        Estoque estoque = (Estoque) Estoque.find("produto", produto).singleResultOptional().orElse(null);
        if (estoque == null) {
            estoque = this.criarProdutoNoEstoque(produto);
        }

        estoque.setQuantidade(estoque.getQuantidade() + quantidade);

        estoque.persistAndFlush();
        return estoque;
    }

    @Transactional
    public Estoque removerProdutodoEstoque(Produto produto, int quantidade) throws Exception {
        if (quantidade < 0) {
            throw new Exception("Quantidade inválida!");
        }

        Estoque estoque = (Estoque) Estoque.find("produto", produto).singleResultOptional().orElse(null);
        if (estoque == null) {
            throw new Exception("produto não encontrado em estoque.");
        }

        if (estoque.getQuantidade() < quantidade) {
            throw new Exception("Quantidade insuficiente no estoque!");
        }

        estoque.setQuantidade(estoque.getQuantidade() - quantidade);
        estoque.persistAndFlush();
        return estoque;
    }

    private Estoque criarProdutoNoEstoque(Produto produto) {
        Estoque estoque = new Estoque();
        estoque.setProduto(produto);
        try {
            estoque.setQuantidade(0);
        } catch (Exception e) {
            // pass
        }
        estoque.persistAndFlush();
        return estoque;
    }
}
