package com.starAndShadow.may.sakila.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins="*")
@RestController  //handles GET, POST, DELETE, PUT requests
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private StaffRepository staffRepository;

	public StaffController(StaffRepository staffRepository) {
		this.staffRepository = staffRepository;
	}

	@GetMapping
	public Iterable<Staff>getAllStaff() { return staffRepository.findAll();}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Staff addStaff(@RequestBody Staff staff) { // firstName, lastName
		LocalDateTime now = LocalDateTime.now();
		staff.setLastUpdate(String.valueOf(now));
		return staffRepository.save(staff);
	}

	@GetMapping("/search")
	public Iterable<Staff> searchByName(@RequestParam String name) { return staffRepository.findByFullNameContainingIgnoreCase(name); }

	@GetMapping("{id}")
	public Optional<Staff> searchById(@PathVariable Integer id) { return staffRepository.findById(id); }

	@PutMapping("{id}")
	public @ResponseBody
	Staff updateStaffById(@PathVariable Integer id, @RequestBody Map<String, Object> changes) {
		Staff staff = staffRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No staff member exists with that id."));
		staff.update(changes);
		return staffRepository.save(staff);
	}

	@DeleteMapping("{id}")
	public @ResponseBody void deleteStaffById(@PathVariable Integer id){
		staffRepository.deleteById(id);
	}
}

