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

	public Persona buscarUno(String nombre) {
		return repoPersona.buscarUno(nombre);
	}

	public void insertar(Persona persona) {
		repoPersona.insertar(persona);
	}

	public void actualizar(Persona persona) {
		repoPersona.actualizar(persona);
	}
	
	
}
