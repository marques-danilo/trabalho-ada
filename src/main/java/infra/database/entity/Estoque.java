package infra.database.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Estoque extends PanacheEntity {

    @OneToOne(optional = false)
    @JoinColumn(name = "produto_id")
    private Produto produto;


    private int quantidade;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws Exception {
        if (quantidade < 0) {
            throw new Exception("Produtos insuficientes no estoque.");
        }
        this.quantidade = quantidade;
    }
}
