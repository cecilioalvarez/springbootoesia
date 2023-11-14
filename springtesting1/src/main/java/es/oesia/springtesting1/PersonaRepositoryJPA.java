package es.oesia.springtesting1;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PersonaRepositoryJPA {

	@PersistenceContext
	EntityManager em;

	public List<Persona> buscarTodos() {

		return em.createQuery("select p from Persona p", Persona.class).getResultList();
	}
	
	
	public Persona buscarUno(String nombre) {

		return em.find(Persona.class, nombre);
	}

	@Transactional
	public void borrar(Persona persona) {
		
		em.remove(em.merge(persona));
	}
	
	@Transactional
	public void insertar(Persona persona) {
		
		em.persist(persona);
	}
	
	@Transactional
	public void actualizar(Persona persona) {
		
		Persona personaActulizar= em.find(Persona.class, persona.getNombre());
		personaActulizar.setApellidos(persona.getApellidos());
		personaActulizar.setEdad(persona.getEdad());
	}
}
