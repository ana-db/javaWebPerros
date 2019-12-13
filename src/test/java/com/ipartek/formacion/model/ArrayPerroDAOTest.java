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
		mock = new Perro(MOCK_ID, MOCK_Nombre);
		dao.create(mock);
	}

	@After
	public void tearDown() throws Exception {
		mock = null;
	}

	
	@Test
	public void testGetAll() throws Exception {
		assertEquals("Sólo debería haber 1 perro", 1, dao.getAll().size());
		
		dao.delete(mock.getId());
		assertEquals("No debería haber ningún perro", 0, dao.getAll().size()); //después de sacarlo del array, esperamos recibir un 0
	}

	@Test
	public void testGetById() {
		assertNull("Es imposible que exista este perro, id incorrecto", dao.getById(MOCK_ID_INEXISTENTE)); //veremos los mensajes, si falla el test
		
		Perro p = dao.getById(MOCK_ID);
		assertSame("El perro debería existir", p, mock);
	}

	@Test
	public void testDelete() {
		try {
			Perro p = dao.delete(MOCK_ID); //se saca de la lista
			assertSame(p, mock); //comprobamos que se ha sacado ese perro
			assertEquals("No hay ningún perro", 0, dao.getAll().size()); //comprobamos que no haya ningún perro en la lista
			
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
