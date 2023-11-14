package es.oesia.springtesting1.basico.jpa;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import es.oesia.springtesting1.Persona;
import es.oesia.springtesting1.PersonaRepositoryJPA;
import es.oesia.springtesting1.PersonaServiceData;
@SpringBootTest
class PersonaServiceDataTest {

	@Autowired
	PersonaServiceData servicePersona;

	@MockBean
	PersonaRepositoryJPA repoPersonaMock;
	
	@Test
	@DisplayName("buscar todas las personas")
	void personaServiceBuscarTodos() {
		var pPedro= new Persona("pedro");
		when(repoPersonaMock.buscarTodos()).thenReturn(List.of(pPedro));
		
		var listaPersonas=servicePersona.buscarTodos();
		
		assertThat(listaPersonas,hasItems(pPedro));
		
	}
	
	@Test
	@DisplayName("buscar una persona por nombre")
	public void buscarPorNombre() {
		var pPedro= new Persona("pedro");
		when(repoPersonaMock.buscarUno(anyString())).thenReturn(pPedro);
		
		var personaPedro= servicePersona.buscarUno("pedro");
		
		assertEquals(personaPedro.getNombre(),"pedro");
		
		
	}
	
	
	@Test
	@DisplayName("insertar una persona")
	public void insertar() {
		
		var persona= new Persona("pedro");
		servicePersona.insertar(persona);
		verify(repoPersonaMock).insertar(persona);
	}
	
	
	
	
	public void actualizar() {
		
		
		var persona= new Persona("pedro");
		servicePersona.actualizar(persona);
		verify(repoPersonaMock).actualizar(persona);
		
		
	}
	
}
