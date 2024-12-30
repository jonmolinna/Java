package com.dallase.api_rest.controller;

import java.util.List;

// import java.util.HashMap;
// import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dallase.api_rest.dto.CustomerDto;
import com.dallase.api_rest.model.Cliente;
import com.dallase.api_rest.response.MessageResponse;
import com.dallase.api_rest.service.ICliente;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/v1")
public class ClienteControllers {
    @Autowired // Injection
    private ICliente customerService;

    @PostMapping("customer")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDto cliente) {
        try {
            Cliente clienteSave = customerService.addCustomer(cliente);
            
            CustomerDto customerSave = CustomerDto.builder()
            .id(clienteSave.getId())
            .name(clienteSave.getName())
            .surname(clienteSave.getSurname())
            .email(clienteSave.getEmail())
            .createdAt(clienteSave.getCreatedAt())
            .build();

            return new ResponseEntity<>(MessageResponse.builder().message("Customer add Success").object(customerSave).build(), HttpStatus.CREATED);
            
        } catch (Exception exception) {
            return new ResponseEntity<>(MessageResponse.builder().message(exception.getMessage()).object(null).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("customer/{id}")
    public ResponseEntity<?> updatedCustomer(@RequestBody CustomerDto cliente, @PathVariable Long id) {
        try {
            // Cliente clienteSave = customerService.addCustomer(cliente);

            if (customerService.existsById(id)) {
                cliente.setId(id);
                Cliente clienteSave = customerService.addCustomer(cliente);
            
                CustomerDto customerUpdated = CustomerDto.builder()
                .id(clienteSave.getId())
                .name(clienteSave.getName())
                .surname(clienteSave.getSurname())
                .email(clienteSave.getEmail())
                .createdAt(clienteSave.getCreatedAt())
                .build();

                return new ResponseEntity<>(MessageResponse.builder().message("Customer Updated Success").object(customerUpdated).build(), HttpStatus.OK);
            }

            return new ResponseEntity<>(MessageResponse.builder().message("Customer Not Found").object(null).build(), HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            return new ResponseEntity<>(MessageResponse.builder().message(exception.getMessage()).object(null).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("customer/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        // Map<String, Object> response = new HashMap<>(); 

        try {
            Cliente cliente = customerService.customerFindById(id);
            customerService.deleteCustomer(cliente);

            return new ResponseEntity<>(cliente, HttpStatus.NO_CONTENT);
            
        } catch (DataAccessException exception) {
            // response.put("message", exception.getMessage());
            // response.put("customer", null);
            // return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(MessageResponse.builder().message(exception.getMessage()).object(null).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        try {
            
            Cliente customer =  customerService.customerFindById(id);

            if (customer == null) {
                return new ResponseEntity<>(MessageResponse.builder().message("Customer Not Found").object(null).build(), HttpStatus.BAD_REQUEST);
            }
    
            CustomerDto cliente =  CustomerDto.builder()
            .id(customer.getId())
            .name(customer.getName())
            .surname(customer.getSurname())
            .email(customer.getEmail())
            .createdAt(customer.getCreatedAt())
            .build();

            return new ResponseEntity<>(MessageResponse.builder().message("Customer add Success").object(cliente).build(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(MessageResponse.builder().message(exception.getMessage()).object(null).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("customer")
    public ResponseEntity<?> getAllCustomer() {
        try {
            List<Cliente> customers = customerService.getCustomerAll();

            if (customers == null) {
                return new ResponseEntity<>(MessageResponse.builder().message("Customers Not Found").object(null).build(), HttpStatus.BAD_REQUEST);
            }
            
            return new ResponseEntity<>(MessageResponse.builder().message("Customers").object(customers).build(), HttpStatus.BAD_REQUEST);
        } catch (Exception exception) {
            return new ResponseEntity<>(MessageResponse.builder().message(exception.getMessage()).object(null).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
