package es.oesia.springtesting1.basico.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql({"/schemapersona.sql","/datospersona.sql"})
public class PersonaRepositorySpringJPATest {

	
	@Test
	public void test() {
		
	}
}
