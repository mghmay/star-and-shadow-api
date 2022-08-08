package com.starAndShadow.may.sakila.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins="*")
@RestController  //handles GET, POST, DELETE, PUT requests
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;

	public AddressController(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	@GetMapping
	public Iterable<Address>getAllAddress() { return addressRepository.findAll();}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Address addAddress(@RequestBody Address address ) { // firstName, lastName
		LocalDateTime now = LocalDateTime.now();
		address.setLastUpdate(String.valueOf(now));
		return addressRepository.save(address);
	}

	@GetMapping("/search")
	public Iterable<Address> searchByAddress(@RequestParam String name) { return addressRepository.findByAddressContainingIgnoreCase(name); }

	@GetMapping("{id}")
	public Optional<Address> searchById(@PathVariable Integer id) { return addressRepository.findById(id); }

	@PutMapping("{id}")
	public @ResponseBody
	Address updateAddressById(@PathVariable Integer id, @RequestBody Map<String, Object> changes) {
		Address address = addressRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No addresses exists with that id."));
		address.update(changes);
		return addressRepository.save(address);
	}

	@DeleteMapping("{id}")
	public @ResponseBody void deleteAddressById(@PathVariable Integer id){
		addressRepository.deleteById(id);
	}
}

