package es.oesia.springtesting1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springtesting1ApplicationTests {

	
	@Autowired
	PersonaRepository repoPersona;
	
	
	@Test
	void getPersonasTest() {
		
		List<Persona> lista=repoPersona.getPersonas();
		assertEquals(2,lista.size());
	}

}
