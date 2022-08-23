package com.starAndShadow.may.sakila.service;

import com.starAndShadow.may.sakila.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
}
