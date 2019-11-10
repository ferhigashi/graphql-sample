package com.higashi.graphqlexample.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.higashi.graphqlexample.entity.Cliente;
import com.higashi.graphqlexample.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
    private ClienteRepository clienteRepository;
    
    @Transactional
    public Cliente criarCliente(final String nome,final String cpf, final String nomeMae, final String dataNascimento) {
        final Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setNomeMae(nomeMae);
        cliente.setDataNascimento(LocalDate.parse(dataNascimento));
        return this.clienteRepository.save(cliente);
    }
    
    @Transactional(readOnly = true)
    public List<Cliente> getAllClientes(final int count) {
        return this.clienteRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }
    
    @Transactional(readOnly = true)
    public Optional<Cliente> getCliente(final int id) {
        return this.clienteRepository.findById(id);
    }


}
