package usecase;

import infra.database.entity.Cliente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ClienteUsecase {

    public List<Cliente> listaClientes() {
        return Cliente.findAll().list();
    }

    @Transactional
    public Cliente criaCliente(String nome, String cpf) {
        Cliente c = new Cliente();
        c.setNome(nome);
        c.setCpf(cpf);
        c.persistAndFlush();
        return c;
    }

}
