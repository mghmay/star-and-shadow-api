package com.starAndShadow.may.sakila.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins="*")
@RestController  //handles GET, POST, DELETE, PUT requests
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	public CategoryController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@GetMapping
	public Iterable<Category>getAllCategory() { return categoryRepository.findAll();}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Category addCategory( @RequestBody Category category ) { // firstName, lastName
		LocalDateTime now = LocalDateTime.now();
		category.setLastUpdate(String.valueOf(now));
		return categoryRepository.save(category);
	}

	@GetMapping("/search")
	public Iterable<Category> searchByName(@RequestParam String name) { return categoryRepository.findByNameContainingIgnoreCase(name); }

	@GetMapping("{id}")
	public Optional<Category> searchById(@PathVariable Integer id) { return categoryRepository.findById(id); }

	@PutMapping("{id}")
	public @ResponseBody
	Category updateCategoryById(@PathVariable Integer id, @RequestBody Map<String, Object> changes) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No category exists with that id."));
		category.update(changes);
		return categoryRepository.save(category);
	}

	@DeleteMapping("{id}")
	public @ResponseBody void deleteCategoryById(@PathVariable Integer id){
		categoryRepository.deleteById(id);
	}
}

