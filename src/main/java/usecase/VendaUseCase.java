package usecase;

import infra.database.entity.Venda;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class VendaUseCase {

    public List<Venda> listarVendas() {
        return Venda.findAll().list();
    }

}
