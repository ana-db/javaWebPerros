package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.model.pojo.Perro;

public class ArrayPerroDAOTest {
	
	//objetos, ctes:
	private static ArrayPerroDAO dao;
	private static Perro mock = new Perro();//mock: objeto de prueba
	private static final int MOCK_ID = 1;
	private static final String MOCK_Nombre = "Pulgas Mock";
	private static final int MOCK_ID_INEXISTENTE = -1;
	private static int indice = MOCK_ID;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = ArrayPerroDAO.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	
	@Before
	public void setUp() throws Exception {
		mock = new Perro(indice, MOCK_Nombre);
		dao.create(mock);
		indice++;
	}

	@After
	public void tearDown() throws Exception {
		dao.delete(mock.getId());
		
		mock = null;
	}

	
	@Test
	public void testGetAll() throws Exception {
		assertEquals("Sólo debería haber 1 perro", 1, dao.getAll().size());
		
		//dao.delete(mock.getId());
		//assertEquals("No debería haber ningún perro", 0, dao.getAll().size()); //después de sacarlo del array, esperamos recibir un 0
	}

	@Test
	public void testGetById() {
		assertNull("Es imposible que exista este perro, id incorrecto", dao.getById(MOCK_ID_INEXISTENTE)); //veremos los mensajes, si falla el test
		
		Perro p = dao.getById(indice);
		assertSame("El perro debería existir", p, mock);
	}

	@Test
	public void testDelete() {
		try {
			//solucionar bug tearDown creando un perro para sacarlo:
			Perro nuevoPerro= new Perro(345, "Pulgas 345");
			dao.create(nuevoPerro);
			Perro p = dao.delete(nuevoPerro.getId()); //se saca de la lista
			assertSame(p, nuevoPerro); //comprobamos que se ha sacado ese perro
			//assertEquals("No debería haber ningún perro", 0, dao.getAll().size()); //comprobamos que no haya ningún perro en la lista
			
			dao.delete(MOCK_ID_INEXISTENTE);
			fail("Se debería haber lanzado una excepción");
		}
		catch (Exception e){
			assertTrue("Se ha lanzado la excepción correctamente al intentar sacar de la lista un perro que no estaba", true);
		}
	}

	@Test
	public void testUpdate() {
		//TODO testUpdate 
	}

	@Test
	public void testCreate() {
		//TODO testCreate 
		
	}

}
