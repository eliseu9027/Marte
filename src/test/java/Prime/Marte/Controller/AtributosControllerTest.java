package Prime.Marte.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import Prime.Marte.controller.AtributosController;
import Prime.Marte.modelo.Planeta;

class AtributosControllerTest {
	
	AtributosController controller = new AtributosController();
	
	Planeta planeta = new Planeta();
	
	@Test
	void massaTest(){
		assertEquals(new ResponseEntity<>(6.39 * (Math.pow(10, 23)), HttpStatus.OK), controller.massa());	
	}
	
	@Test
	void testPesoCorporalCasoDeCerto() {
		String json = "{\"peso\":\"100\"}";
		planeta.setPesoEmMarte(372.1);
		assertEquals(new ResponseEntity<>(planeta.getPesoEmMarte(), HttpStatus.OK), controller.pesoCorporal(json));		
	}
	
	@Test
	void testPesoCorporalCasoDeErrado() {
		String json = "";
		String message = "JSON Invalido";
		assertEquals(new ResponseEntity<>(message, HttpStatus.BAD_REQUEST), controller.pesoCorporal(json));	
	}
	
	@Test
	void testCallKanye() {
		assertNotNull(controller.getCallKanye());
	}
	
	@Test
	void testCallCockyTail() {
		assertNotNull(controller.getcallCockTail());
	}
}
