package com.dallase.api_rest.service;

import java.util.List;

import com.dallase.api_rest.dto.CustomerDto;
// import com.dallase.api_rest.model.Cliente;
import com.dallase.api_rest.model.Cliente;

public interface ICliente {
    // Cliente addCustomer(Cliente cliente);
    // Cliente customerFindById(Long id);
    // void deleteCustomer(Cliente cliente);
    // Cliente updatedCustomer(Cliente cliente, Long id);

    Cliente addCustomer(CustomerDto cliente);
    Cliente customerFindById(Long id);
    void deleteCustomer(Cliente cliente);
    boolean existsById(Long id);
    List<Cliente> getCustomerAll();
    // CustomerDto updatedCustomer(CustomerDto cliente, Long id);
}
