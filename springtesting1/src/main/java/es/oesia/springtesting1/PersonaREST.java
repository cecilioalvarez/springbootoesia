package es.oesia.springtesting1;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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

	public void add(Persona persona) {
		servicio.add(persona);
	}

	public void remove(Persona persona) {
		servicio.remove(persona);
	}
	
	

}
