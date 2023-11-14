package es.oesia.springtesting1;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class PersonaServiceData {

	private PersonaRepositoryJPA repoPersona;

	public PersonaServiceData(PersonaRepositoryJPA repoPersona) {
		super();
		this.repoPersona = repoPersona;
	}

	public List<Persona> buscarTodos() {
		return repoPersona.buscarTodos();
	}
	
	
}
