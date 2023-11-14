package es.oesia.springtesting1.basico.jpa;


import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
	@DisplayName("buscar una persona por nombre")
	public void buscarPorNombre() {
		
		var personaPedro= repoPersona.buscarUno("pedro");
		assertEquals(personaPedro.getNombre(),"pedro");
		
		
	}
	
	
	@Test
	@DisplayName("borrar una persona")
	public void borrar() {
		var ana= new Persona("ana");
		
		repoPersona.borrar(ana);
		var listaPersonas= repoPersona.buscarTodos();
		
		assertThat (listaPersonas,not(hasItems(ana)));
		
		
	}
	
	@Test
	@DisplayName("insertar una persona")
	public void insertar() {
		var marta= new Persona("marta","gomez",40);
		repoPersona.insertar(marta);
		var listaPersonas= repoPersona.buscarTodos();
		
		assertThat (listaPersonas,hasItems(marta));
		
		
	}
	
	@Test
	@DisplayName("actualizar una persona")
	public void actualizar() {
		var ana= new Persona("ana","blanco",50);
		repoPersona.actualizar(ana);
		var personaActualizada= repoPersona.buscarUno(ana.getNombre());
		
		assertEquals(personaActualizada.getNombre(),"ana");
		assertEquals(personaActualizada.getApellidos(),"blanco");
		assertEquals(personaActualizada.getEdad(),50);
		
		
		
	}
}
