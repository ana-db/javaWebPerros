package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.pojo.Perro;

public class ArrayPerroDAO implements IDAO<Perro>{
	
	private ArrayList<Perro> registros;
	private static int indice = 1; //por seguridad se suele indicar que empiece por cualquier núm excpeto el 1
	
	private static ArrayPerroDAO INSTANCE = null;
	
	//capar para que no se pueda hacer new de esta clase
	private ArrayPerroDAO() {
		super();
		registros = new ArrayList<Perro>();
	}
	
	//singleton --> https://es.wikipedia.org/wiki/Singleton --> sólo va a tener 1 único objeto en toda la clase, 1 objeto de tipo ArrayPerroDAO
	public synchronized static ArrayPerroDAO getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ArrayPerroDAO();
		}
		
		return INSTANCE;
	}

	
	@Override
	public List<Perro> getAll() {
		return registros;
	}

	@Override
	public Perro getById(int id) { 
		Perro resul = null; 
		
		for(Perro perro : registros) {
			if (id == perro.getId()) {
				resul = perro;
				break;
			}
		}
		
		return resul; //los métodos sólo devuelven 1 resultado
	}

	@Override
	public Perro delete(int id) throws Exception {
		
		Perro resul = null; 
		
		for(Perro perro : registros) {
			if (id == perro.getId()) {
				resul = perro;
				registros.remove(perro);
				break;
			}
		}
		
		if (resul == null) {
			throw new Exception("Perro no encontrado por su id " + id);
		}
		
		return resul;
	}

	@Override
	public Perro update(Perro pojo, int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Perro create(Perro pojo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
