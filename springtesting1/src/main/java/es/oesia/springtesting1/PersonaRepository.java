package es.oesia.springtesting1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class PersonaRepository {

	private  List<Persona> personas= new ArrayList<>();
	
	public PersonaRepository() {
		super();
		personas.add(new Persona ("pepe","perez",20));
		personas.add(new Persona ("juan","gomez",30));
	}
	
	public List<Persona> getPersonas() {
		
		return personas;
	}
	
	public void add(Persona persona) {
		
		personas.add(persona);
	}
	
	
}
