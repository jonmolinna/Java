package com.dallase.api_rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dallase.api_rest.dto.CustomerDto;
import com.dallase.api_rest.model.Cliente;
import com.dallase.api_rest.repository.ClienteRepository;

@Service
public class ClienteService implements ICliente {
    @Autowired // Inject
    private ClienteRepository clienteRepository;

    @Transactional
    @Override
    public Cliente addCustomer(CustomerDto cliente) {
        Cliente customer = Cliente.builder()
                               .id(cliente.getId())
                               .name(cliente.getName())
                               .surname(cliente.getSurname())
                               .email(cliente.getEmail())
                               .createdAt(cliente.getCreatedAt())
                               .build();
        return clienteRepository.save(customer);
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente customerFindById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void deleteCustomer(Cliente customer) {
        clienteRepository.delete(customer);
    }

    @Override
    public boolean existsById(Long id) {
        return clienteRepository.existsById(id);
    }

    @Override
    public List<Cliente> getCustomerAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    // @Override
    // public Cliente updatedCustomer(CustomerDto cliente, Long id) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'updatedCustomer'");
    // }

}