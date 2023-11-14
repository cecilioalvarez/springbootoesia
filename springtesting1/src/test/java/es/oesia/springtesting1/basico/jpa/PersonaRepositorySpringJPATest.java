package es.oesia.springtesting1.basico.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import es.oesia.springtesting1.PersonaRepositoryJPA;

@SpringBootTest
@Sql({"/schemapersona.sql","/datospersona.sql"})
public class PersonaRepositorySpringJPATest {

	
	@Autowired
	PersonaRepositoryJPA repoPersona;
	
	@Test
	public void test() {
		
		var listaPersonas= repoPersona.buscarTodos();
		assertEquals(1,listaPersonas.size());
		
		
	}
}
