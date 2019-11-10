package com.higashi.graphqlexample.queries;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.higashi.graphqlexample.entity.Cliente;
import com.higashi.graphqlexample.services.ClienteService;

@Component
public class ClienteQuery implements GraphQLQueryResolver {
	
    @Autowired
    private ClienteService clienteService;
    
    public List<Cliente> getClientes(final int count) {
        return this.clienteService.getAllClientes(count);
    }
    public Optional<Cliente> getCliente(final int id) {
        return this.clienteService.getCliente(id);
    }
}