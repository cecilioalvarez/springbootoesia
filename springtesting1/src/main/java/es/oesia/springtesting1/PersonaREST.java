package es.oesia.springtesting1;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
public class PersonaREST {
	
	public PersonaREST(PersonaService servicio) {
		super();
		this.servicio = servicio;
	}

	private PersonaService servicio;

	@GetMapping
	public List<Persona> getPersonas() {
		return servicio.getPersonas();
	}
	@PostMapping
	public void add(@RequestBody Persona persona) {
		servicio.add(persona);
	}
	@DeleteMapping("{nombre}")
	public void remove(@PathVariable String nombre) {
		servicio.remove(new Persona(nombre));
	}
	
	

}
