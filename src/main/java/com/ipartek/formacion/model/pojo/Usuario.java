package com.ipartek.formacion.model.pojo;

public class Usuario {
	
	//variables:
	private int id;
	private String nombre;
	private String password; 
	private String urlGithub; 
	private String urlFoto;
	
	//constructores:
	public Usuario(int id, String nombre, String password, String urlGithub, String urlFoto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.urlGithub = urlGithub;
		this.urlFoto = urlFoto;
	} 
	
	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.password = "";
		this.urlGithub = "";
		this.urlFoto = "";
	}

	//getters y setters:
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrlGithub() {
		return urlGithub;
	}

	public void setUrlGithub(String urlGithub) {
		this.urlGithub = urlGithub;
	}

	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	} 
	
	
	
	
	

}
