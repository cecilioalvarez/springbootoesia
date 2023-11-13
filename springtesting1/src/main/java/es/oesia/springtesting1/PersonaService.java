package es.oesia.springtesting1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository repo;

	public List<Persona> getPersonas() {
		return repo.getPersonas();
	}

	public void add(Persona persona) {
		repo.add(persona);
	}

	public void remove(Persona persona) {
		repo.remove(persona);
	}
	
	
	
}
