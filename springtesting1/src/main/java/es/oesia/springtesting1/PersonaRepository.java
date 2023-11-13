package es.oesia.springtesting1;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository {

	private static List<Persona> personas= new ArrayList<>();
	
	static {
		
		
		personas.add(new Persona ("pepe","perez",20));
		personas.add(new Persona ("juan","gomez",30));
		
		
	}
	
	public List<Persona> getPersonas() {
		
		return personas;
	}
	
	
}
