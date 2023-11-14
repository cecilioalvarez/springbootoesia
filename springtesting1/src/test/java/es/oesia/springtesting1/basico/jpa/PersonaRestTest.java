package es.oesia.springtesting1.basico.jpa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonaRestTest {
	
	//@Autowired
	//private PersonaREST servicioRest;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void holaTest() throws Exception {
		
		mockMvc.perform(get("/hola")).andDo(print()).andExpect(status().isOk());
		
	}
	
	@Test
	@DisplayName("buscar todas las personas via REST")
	public void buscarTodasLasPersonas() throws Exception {
		
		mockMvc
		.perform(get("/personas"))
		.andExpect(status().isOk())
		.andExpect(content()
				.json("[{nombre:'pepe',apellidos:'perez',edad:20},{nombre:'juan',apellidos:'gomez',edad:30}]"));
		
				
			

		
	}
	
	
	
	
	

}
