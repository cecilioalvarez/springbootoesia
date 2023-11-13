package es.oesia.springtesting1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springtesting1ApplicationTests {

	
	@Autowired
	ComponenteHola componente;
	
	
	@Test
	void duplicarValorTest() {
		
		double resultado=componente.duplicar(2);
		assertEquals(4,resultado);
	}

}
