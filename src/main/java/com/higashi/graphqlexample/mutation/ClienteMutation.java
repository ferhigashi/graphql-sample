package com.higashi.graphqlexample.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.higashi.graphqlexample.entity.Cliente;
import com.higashi.graphqlexample.services.ClienteService;
@Component
public class ClienteMutation implements GraphQLMutationResolver {
	
    @Autowired
    private ClienteService clienteService;
    
    public Cliente criarCliente(final String nome, final String cpf, final String nomeMae, final String dataNascimento) {
        return this.clienteService.criarCliente(nome, cpf, nomeMae, dataNascimento);
    }
}