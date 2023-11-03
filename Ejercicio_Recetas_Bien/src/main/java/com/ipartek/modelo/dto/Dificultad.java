package com.ipartek.modelo.dto;

public class Dificultad { //Campos: id, dificultad
	
	private int id;
	private String dificultad;

	public Dificultad(){
		id = 0;
		dificultad = "";
	}
	
	public Dificultad(int id, String dificultad) {
		this.id = id;
		this.dificultad = dificultad;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDificultad() {
		return dificultad;
	}
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	@Override
	public String toString() {
		return "Dificultad [id=" + id + ", dificultad=" + dificultad + "]";
	}

}
