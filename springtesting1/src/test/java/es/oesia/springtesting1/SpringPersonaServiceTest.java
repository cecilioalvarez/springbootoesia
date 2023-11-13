package es.oesia.springtesting1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class SpringPersonaServiceTest {

	@Autowired
	PersonaService personaService;
	@MockBean
	PersonaRepository repoPersonaMock;

	@Test

	void getPersonasTest() {

		var ana = new Persona("ana");
		var juan = new Persona("juan");
		when(repoPersonaMock.getPersonas()).thenReturn(List.of(ana, juan));
		
		var lista = personaService.getPersonas();
		
		assertThat(lista, hasItems(ana, juan));

	}

	@Test
	void addPersonaTest() {

		var ana=new Persona("ana", "perez", 40);
		personaService.add(ana);
		verify(repoPersonaMock).add(ana);
	}

	@Test
	void removePersonaTest() {

		personaService.remove(new Persona("pepe"));
		List<Persona> lista2 = personaService.getPersonas();
		assertFalse(lista2.contains(new Persona("ana")));
	}

}
