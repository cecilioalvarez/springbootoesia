package es.oesia.springtesting1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaREST {

	@RequestMapping("/hola")
	public String hola() {
		
		return "hola mundo";
	}
}
