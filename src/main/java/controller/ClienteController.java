package controller;

import dto.CriaClienteDTO;
import infra.database.entity.Cliente;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import usecase.ClienteUsecase;

import java.util.List;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteController {

    @Inject
    protected ClienteUsecase clienteUsecase;

    @GET
    public List<Cliente> listaClientes() {
        return clienteUsecase.listaClientes();
    }

    @POST
    public Cliente criarCliente(CriaClienteDTO criaClienteDTO) {
        return clienteUsecase.criaCliente(criaClienteDTO.getNome(), criaClienteDTO.getCpf());
    }
}
