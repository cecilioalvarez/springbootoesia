package es.oesia.springtesting1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class SpringPersonaServiceTest {

	
	@Autowired
	PersonaService repoPersonaService;
	
	
	@Test

	void getPersonasTest() {
		
		List<Persona> lista=repoPersonaService.getPersonas();
		assertEquals(2,lista.size());
	}
	
	@Test
	void addPersonaTest() {
		
		repoPersonaService.add(new Persona("ana","perez",40));
		List<Persona> lista=repoPersonaService.getPersonas();
		assertTrue(lista.contains(new Persona("ana")));
	}
	
	@Test
	void removePersonaTest() {
		
		
		repoPersonaService.remove(new Persona("pepe"));
		List<Persona> lista2=repoPersonaService.getPersonas();
		assertFalse(lista2.contains(new Persona("ana")));
	}


}
