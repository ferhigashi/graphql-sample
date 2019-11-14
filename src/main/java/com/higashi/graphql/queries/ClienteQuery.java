package com.higashi.graphql.queries;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.higashi.graphql.entity.Cliente;
import com.higashi.graphql.services.ClienteService;

@Component
public class ClienteQuery implements GraphQLQueryResolver {
	
    @Autowired
    private ClienteService clienteService;
    
    public List<Cliente> getClientes(int count) {
        return this.clienteService.getAllClientes(count);
    }
    public Optional<Cliente> getCliente(int id) {
        return this.clienteService.getCliente(id);
    }
}