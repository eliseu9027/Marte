package Prime.Marte.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthController {

	@GetMapping("/health")
	@ResponseBody
	public ResponseEntity<Date> health() {
		return new ResponseEntity<>(new Date(),HttpStatus.OK);
	}
		
}
