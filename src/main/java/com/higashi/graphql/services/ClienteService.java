package com.higashi.graphql.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.higashi.graphql.entity.Cliente;
import com.higashi.graphql.entity.Telefone;
import com.higashi.graphql.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
    private ClienteRepository clienteRepository;
    
    @Transactional
    public Cliente criarCliente(String nome,String cpf, String nomeMae, String dataNascimento, Telefone[] telefones) {
        final Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setNomeMae(nomeMae);
        cliente.setDataNascimento(LocalDate.parse(dataNascimento));
        
        for (Telefone telefone : telefones) {
        	telefone.setCliente(cliente);
        	cliente.addTelefone(telefone);
		}
        
        return this.clienteRepository.save(cliente);
    }
    
    @Transactional(readOnly = true)
    public List<Cliente> getAllClientes(int count) {
        return this.clienteRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }
    
    @Transactional(readOnly = true)
    public Optional<Cliente> getCliente(int id) {
        return this.clienteRepository.findById(id);
    }


}
