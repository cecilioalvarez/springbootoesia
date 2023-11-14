//package es.oesia.springtesting1.basico;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.annotation.DirtiesContext.ClassMode;
//
//import es.oesia.springtesting1.Persona;
//import es.oesia.springtesting1.PersonaRepository;
//
//@SpringBootTest
//@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
//
//class SpringPersonaRepositoryTest {
//
//	
//	@Autowired
//	PersonaRepository repoPersona;
//	
//	
//	@Test
//
//	void getPersonasTest() {
//		
//		List<Persona> lista=repoPersona.getPersonas();
//		assertEquals(2,lista.size());
//	}
//	
//	@Test
//	void addPersonaTest() {
//		
//		repoPersona.add(new Persona("ana","perez",40));
//		List<Persona> lista=repoPersona.getPersonas();
//		assertTrue(lista.contains(new Persona("ana")));
//	}
//	
//	@Test
//	void removePersonaTest() {
//		
//		
//		repoPersona.remove(new Persona("pepe"));
//		List<Persona> lista2=repoPersona.getPersonas();
//		assertFalse(lista2.contains(new Persona("ana")));
//	}
//
//
//}
