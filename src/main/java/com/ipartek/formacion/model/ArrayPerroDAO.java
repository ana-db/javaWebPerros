package com.ipartek.formacion.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.model.pojo.Perro;

public class ArrayPerroDAO implements IDAO<Perro>{
	
	private ArrayList<Perro> registros;
	private static int indice = 0; //por seguridad se suele indicar que empiece por cualquier núm excpeto el 1
	
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
		Perro resul = null; 
		
		for (int i = 0; i < registros.size(); i++) {
			if (id == registros.get(i).getId()) { //registros.get(i) nos devuelve un objeto perro completo
				registros.remove(i);
				registros.add(pojo);
				break;
			}
		}
		
		if (resul == null) {
			throw new Exception("El perro no se ha encontrado" + id);
		}
		
		return resul;
	}

	@Override
	public Perro create(Perro pojo) throws Exception {
		Perro resul = pojo; 
		
		//TODO comprobar campos del pojo
		
		if (pojo != null) {
			pojo.setId(++indice);
			registros.add(pojo);
		}
		else {
			throw new Exception("No se ha podido crear: Perro NULL sin datos");
		}
		
		return resul;
	}
	
}
