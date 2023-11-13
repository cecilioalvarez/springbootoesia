package es.oesia.springtesting1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;

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
	PersonaService repoPersonaService;
	@MockBean
	PersonaRepository repoPersonaMock;
	
	
	@Test

	void getPersonasTest() {
		
		//when(repoPersonaMock.getPersonas()).thenReturn(List.of(new Persona("ana"),new Persona("juan")));
		
		
		List<Persona> lista= repoPersonaService.getPersonas();
		assertEquals(2,lista.size());
	}
	
	@Test
	void addPersonaTest() {
		
		//persona service add
		//porque es un metodo delegado
		// al ser un metodo delegado no hace nada
		// entonces verificar aqui que hemos añadido una persona
		// con las listas no tiene sentido
		//porque eso lo hace el repo
		
		repoPersonaService.add(new Persona("ana","perez",40));
	    Mockito.verify(repoPersonaMock).add(new Persona("ana","perez",40));
	}
	
	@Test
	void removePersonaTest() {
		
		
		repoPersonaService.remove(new Persona("pepe"));
		List<Persona> lista2=repoPersonaService.getPersonas();
		assertFalse(lista2.contains(new Persona("ana")));
	}


}
