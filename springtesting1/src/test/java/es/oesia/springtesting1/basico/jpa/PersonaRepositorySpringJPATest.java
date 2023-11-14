package es.oesia.springtesting1.basico.jpa;


import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import static org.hamcrest.MatcherAssert.assertThat;
import es.oesia.springtesting1.Persona;
import es.oesia.springtesting1.PersonaRepositoryJPA;

@SpringBootTest
@Sql({"/schemapersona.sql","/datospersona.sql"})
public class PersonaRepositorySpringJPATest {

	
	@Autowired
	PersonaRepositoryJPA repoPersona;
	
	@Test
	@DisplayName("buscar todas las personas")
	public void buscarTodos() {
		Persona pepe= new Persona("pedro");
		var listaPersonas= repoPersona.buscarTodos();
		assertThat (listaPersonas,hasItems(pepe));
		
		
	}
	@Test
	@DisplayName("borrar una persona")
	public void borrar() {
		var ana= new Persona("ana");
		
		repoPersona.borrar(ana);
		var listaPersonas= repoPersona.buscarTodos();
		
		assertThat (listaPersonas,not(hasItems(ana)));
		
		
	}
}
