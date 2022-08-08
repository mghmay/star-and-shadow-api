package com.starAndShadow.may.sakila.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins="*")
@RestController  //handles GET, POST, DELETE, PUT requests
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@GetMapping
	public Iterable<Customer>getAllCustomers() { return customerRepository.findAll();}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Customer addCustomer(@RequestBody Customer customer) { // firstName, lastName
		LocalDateTime now = LocalDateTime.now();
		customer.setLastUpdate(String.valueOf(now));
		return customerRepository.save(customer);
	}

	@GetMapping("/search")
	public Iterable<Customer> searchByName(@RequestParam String name) { return customerRepository.findByFullNameContainingIgnoreCase(name); }

	@GetMapping("{id}")
	public Optional<Customer> searchById(@PathVariable Integer id) { return customerRepository.findById(id); }

	@PutMapping("{id}")
	public @ResponseBody
	Customer updateCustomerById(@PathVariable Integer id, @RequestBody Map<String, Object> changes) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No customer exists with that id."));
		customer.update(changes);
		return customerRepository.save(customer);
	}

	@DeleteMapping("{id}")
	public @ResponseBody void deleteCustomerById(@PathVariable Integer id){
		customerRepository.deleteById(id);
	}
}

