package com.higashi.graphql.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.higashi.graphql.entity.Cliente;
import com.higashi.graphql.entity.Telefone;
import com.higashi.graphql.services.ClienteService;
@Component

public class ClienteMutation implements GraphQLMutationResolver {
	
    @Autowired
    private ClienteService clienteService;
    
    public Cliente criarCliente(String nome, String cpf, String nomeMae, String dataNascimento, Telefone[] telefones) {
        return this.clienteService.criarCliente(nome, cpf, nomeMae, dataNascimento, telefones);
    }
}