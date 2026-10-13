package usecase;

import infra.database.entity.Cliente;
import infra.database.entity.Produto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped

public class ProdutoUseCase {

    public List<Produto> listaProdutos() {
        return Produto.findAll().list();
    }

    public Produto buscarProduto(String nome) {
        return (Produto) Produto.find("nome", nome).firstResultOptional().orElse(null);
    }

    @Transactional
    public Produto criaProduto(String nome) {
        Produto p = new Produto();
        p.setNome(nome);
        p.persistAndFlush();
        return p;
    }


}
