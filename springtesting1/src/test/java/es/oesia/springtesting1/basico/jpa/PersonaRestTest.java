package es.oesia.springtesting1.basico.jpa;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.oesia.springtesting1.Persona;
import es.oesia.springtesting1.PersonaServiceData;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonaRestTest {
	
	//@Autowired
	//private PersonaREST servicioRest;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper mapeador;
	
	@MockBean
	private PersonaServiceData servicioPersona;
	
	
	@Test
	public void holaTest() throws Exception {
		
		mockMvc.perform(get("/hola")).andDo(print()).andExpect(status().isOk());
		
	}
	
	@Test
	@DisplayName("buscar todas las personas via REST")
	public void buscarTodasLasPersonas() throws Exception {
		
		Persona pedro= new Persona("pedro","gomez",20);
		when(servicioPersona.buscarTodos()).thenReturn(List.of(pedro));
		mockMvc
		.perform(get("/personas"))
		.andExpect(status().isOk())
		.andExpect(content()
				.json("[{nombre:'pedro',apellidos:'gomez',edad:20}]"));
	
	}
	
	
	@Test
	@DisplayName("buscar una persona")
	public void buscarUnaPersona() throws Exception {
		
	
		when(servicioPersona.buscarUno("pedro")).thenReturn(new Persona("pedro","gomez",20));
		mockMvc
		.perform(get("/personas/pedro"))
		.andExpect(status().isOk());
		//.andExpect(content()
		//		.json("{nombre:'pedro',apellidos:'gomez',edad:20}"));
	
	}
	
	@Test
	@DisplayName("insertar Persona via REST")
	public void insertarPersona() throws Exception {
		
		Persona persona= new Persona("gema","blanco",40);
		String textoPersona= mapeador.writeValueAsString(persona);
		
		mockMvc
		.perform(post("/personas")
		.contentType("application/json")
		.content(textoPersona))
		.andExpect(status().isOk());
			
				
	}
	
	
	@Test
	@DisplayName("borrar Persona via REST")
	public void borrarPersona() throws Exception {
		String nombre="gema";
		mockMvc
		.perform(delete("/personas/"+nombre))
		.andExpect(status().isOk());
		
		verify(servicioPersona).borrar(new Persona(nombre));
			
				
	}
	
	
	
	
	
	
	
	

}
