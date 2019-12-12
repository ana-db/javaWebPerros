package com.ipartek;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class SetTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		//assertTrue(true);
		assertTrue(4 > 2);
		assertTrue(2 == 2); //compara 2 valores
		assertEquals(2, 2); //compara 2 valores
		assertNull(null);
		
		
		//creamos lista de países que no se repitan:
		HashSet<String> paises = new HashSet<String>();
		assertNotNull(paises);
		
		//rellenamos:
		paises.add("eh");
		paises.add("ct");
		paises.add("es");
		paises.add("fr");
		
		//hacemos test:
		//assertEquals("Mensaje personalizado por si falla", 5, paises.size()); //comprobamos si el tamaño de la lista de países es 5

		//metemos los mismos 4 países otra vez:
		paises.add("eh");
		paises.add("ct");
		paises.add("es");
		paises.add("fr");
		
		//hacemos test:
		assertEquals("Si ha fallado es porque permite duplicidades y contaría 8", 4, paises.size());

	}
	
}
