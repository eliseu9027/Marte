package Prime.Marte.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import Prime.Marte.modelo.Planeta;

@Controller
public class AtributosController {
	
	public static final Double MASSA_MARTE = 6.39 * (Math.pow(10, 23));
	public static final Double GRAVIDADE = 3.721;
	
	Planeta planeta;
	
	
	@GetMapping("/massa")
	@ResponseBody
	public ResponseEntity<Double> massa() {
		return new ResponseEntity<>(MASSA_MARTE ,HttpStatus.OK);
	}
	
	@PostMapping("/pesoCorporal")
	public ResponseEntity<Object> pesoCorporal(@RequestBody String json) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			planeta = mapper.readValue(json, Planeta.class);
			Double pesoEmMarte = planeta.getPeso() * GRAVIDADE;		
			return new ResponseEntity<Object>(pesoEmMarte, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
			
	}
	
	
	@GetMapping(value = "/callKanye") 
	private ResponseEntity<String> getCallKanye(){
		String uri = "https://api.kanye.rest";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent", "Application");
		HttpEntity<String> entity = new HttpEntity<>(headers);	
		restTemplate.exchange(uri,HttpMethod.GET, entity, String.class);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.GET, entity, String.class);
		return result;
	}
	
	@GetMapping(value = "/callCockTail") 
	private ResponseEntity<String> getcallCockTail(){
		String uri = "https://www.thecocktaildb.com/api/json/v1/1/random.php";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("user-agent", "Application");
		HttpEntity<String> entity = new HttpEntity<>(headers);	
		restTemplate.exchange(uri,HttpMethod.GET, entity, String.class);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.GET, entity, String.class);
		return result;
	}	
}
