package Prime.Marte.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlanetaTest {
	
	Planeta planeta = new Planeta();

	@Test
	void testPesoGetESet() {
		Double peso = 100.5;
		planeta.setPeso(peso);
		assertEquals(peso, planeta.getPeso());	
	}
	
	@Test
	void testPesoEmMarteGetESet() {
		Double peso = 100.5;
		planeta.setPesoEmMarte(peso);
		assertEquals(peso, planeta.getPesoEmMarte());	
	}

}
