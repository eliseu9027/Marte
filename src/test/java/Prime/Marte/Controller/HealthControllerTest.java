package Prime.Marte.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import Prime.Marte.controller.HealthController;

class HealthControllerTest {
	
	HealthController controller = new HealthController();

	@Test
	void testHealth() {
		assertEquals(new ResponseEntity<>(new Date(), HttpStatus.OK), controller.health());
	}

}
