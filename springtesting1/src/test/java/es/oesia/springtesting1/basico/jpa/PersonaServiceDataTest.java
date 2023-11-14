package es.oesia.springtesting1.basico.jpa;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.oesia.springtesting1.Persona;
import es.oesia.springtesting1.PersonaServiceData;
@SpringBootTest
class PersonaServiceDataTest {

	@Autowired
	PersonaServiceData servicePersona;
	
	@Test
	@DisplayName("buscar todas las personas")
	void personaServiceBuscarTodos() {
		
		Persona pedro= new Persona("pedro");
		var listaPersonas=servicePersona.buscarTodos();
		assertThat(listaPersonas,hasItems(pedro));
		
	}

}
