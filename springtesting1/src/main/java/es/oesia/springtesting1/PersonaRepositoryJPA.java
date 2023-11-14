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

	@Transactional
	public void borrar(Persona persona) {
		
		em.remove(em.merge(persona));
	}
	
	@Transactional
	public void insertar(Persona persona) {
		
		em.persist(persona);
	}
}
