package com.starAndShadow.may.sakila.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins="*")
@RestController  //handles GET, POST, DELETE, PUT requests
@RequestMapping("/actors")
public class ActorController {

	@Autowired
	private ActorRepository actorRepository;

	public ActorController(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}

	@GetMapping
	public Iterable<Actor>getAllActors() { return actorRepository.findAll();}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Actor addActor( @RequestBody Actor actor ) { // firstName, lastName
		LocalDateTime now = LocalDateTime.now();
		actor.setLastUpdate(String.valueOf(now));
		return actorRepository.save(actor);
	}

	@GetMapping("/search")
	public Iterable<Actor> searchByName(@RequestParam String name) { return actorRepository.findByFullNameContainingIgnoreCase(name); }

	@GetMapping("{id}")
	public Optional<Actor> searchById(@PathVariable Integer id) { return actorRepository.findById(id); }

	@PutMapping("{id}")
	public @ResponseBody
	Actor updateActorById(@PathVariable Integer id, @RequestBody Map<String, Object> changes) {
		Actor actor = actorRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No actor exists with that id."));
		changes.forEach(
			(change, value) -> {
				switch (change) {
					case "firstName":
						actor.setFirstName((String) value);
						break;
					case "lastName":
						actor.setLastName((String) value);
						break;
				}
			}
		);
		LocalDateTime now = LocalDateTime.now();
		actor.setLastUpdate(String.valueOf(now));
		return actorRepository.save(actor);
	}

	@DeleteMapping("{id}")
	public @ResponseBody void deleteActorById(@PathVariable Integer id){
		actorRepository.deleteById(id);
	}
}

