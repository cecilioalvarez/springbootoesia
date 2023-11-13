package es.oesia.springtesting1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class SpringRepositoryTest {

	
	@Autowired
	PersonaRepository repoPersona;
	
	
	@Test

	void getPersonasTest() {
		
		List<Persona> lista=repoPersona.getPersonas();
		assertEquals(2,lista.size());
	}
	
	@Test
	void addPersonaTest() {
		
		repoPersona.add(new Persona("ana","perez",40));
		List<Persona> lista=repoPersona.getPersonas();
		assertEquals(3,lista.size());
	}

}
