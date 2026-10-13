package infra.database.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Venda extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private LocalDateTime horarioCompra;
    private SituacaoVenda situacaoVenda;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public LocalDateTime getHorarioCompra() {
        return horarioCompra;
    }

    public void setHorarioCompra(LocalDateTime horarioCompra) {
        this.horarioCompra = horarioCompra;
    }

    public SituacaoVenda getSituacaoVenda() {
        return situacaoVenda;
    }

    public void setSituacaoVenda(SituacaoVenda situacaoVenda) {
        this.situacaoVenda = situacaoVenda;
    }
}
