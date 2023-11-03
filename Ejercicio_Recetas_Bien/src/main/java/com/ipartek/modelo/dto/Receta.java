package com.ipartek.modelo.dto;

public class Receta { //Campos: id, nombre, FK_dificultad, FK_estilo
	
	private int id;
	private String nombre;
	private int fk_dificultad;
	private int fk_estilo;
	
	public Receta() {
		super();
		this.id = 0;
		this.nombre = "";
		this.fk_dificultad = 0;
		this.fk_estilo = 0;
	}
	
	public Receta(int id, String nombre, int fk_dificultad, int fk_estilo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fk_dificultad = fk_dificultad;
		this.fk_estilo = fk_estilo;
	}

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

	public int getFk_dificultad() {
		return fk_dificultad;
	}

	public void setFk_dificultad(int fk_dificultad) {
		this.fk_dificultad = fk_dificultad;
	}

	public int getFk_estilo() {
		return fk_estilo;
	}

	public void setFk_estilo(int fk_estilo) {
		this.fk_estilo = fk_estilo;
	}

	@Override
	public String toString() {
		return "Receta [id=" + id + ", nombre=" + nombre + ", fk_dificultad=" + fk_dificultad + ", fk_estilo="
				+ fk_estilo + "]";
	}
}
