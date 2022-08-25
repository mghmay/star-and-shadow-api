package com.starAndShadow.may.sakila.service.impl;

import com.starAndShadow.may.sakila.dto.CustomerDTO;
import com.starAndShadow.may.sakila.model.Customer;
import com.starAndShadow.may.sakila.repository.CustomerRepository;
import com.starAndShadow.may.sakila.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .toList();
    }


    private CustomerDTO convertEntityToDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setStoreId(customer.getStoreId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setFullName(customer.getFullName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setAddressId(customer.getAddressId());
        return customerDTO;
    }
}
