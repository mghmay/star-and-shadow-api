package com.starAndShadow.may.sakila.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins="*")
@RestController  //handles GET, POST, DELETE, PUT requests
@RequestMapping("/sakila")
public class ActorController {

	@Autowired
	private ActorRepository actorRepository;

	public ActorController(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}

	@GetMapping("/all_actors")
	public @ResponseBody
	Iterable<Actor>getAllActors() { return actorRepository.findAll();}

	@GetMapping("/all_actors/search{id}")
	public @ResponseBody
	Optional<Actor> searchById(@RequestParam Integer id) {
		return actorRepository.findById(id);
	}

	@GetMapping("/all_actors/search_by_name{name}")
	public @ResponseBody
	Iterable<Actor>SearchActorsByName(@RequestParam String name) {
		return actorRepository.findByFullNameContainingIgnoreCase(name);
	}

	@PostMapping("/all_actors/add")
	public @ResponseBody
	Actor addActor(@RequestParam String first_name,
				   @RequestParam String last_name
				  ) {
		Actor newActor = new Actor(first_name, last_name);
		return actorRepository.save(newActor);
	}

//	@PutMapping("/all_actors/update{id}")
//	public @ResponseBody
//	Actor updateActor(@RequestParam Integer id,
//					  @RequestParam String attribute,
//					  @RequestParam String new_value
//					  ) {
//		Optional<Actor> actor = actorRepository.findById(id);
//
//	}

	@DeleteMapping("/all_actors/delete{id}")
	public @ResponseBody
	void deleteActorById(@RequestParam Integer id){
		actorRepository.deleteById(id);
	}
}
