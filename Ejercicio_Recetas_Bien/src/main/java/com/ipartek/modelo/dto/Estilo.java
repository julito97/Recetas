package com.ipartek.modelo.dto;

public class Estilo { //Campos: id, estilo
	
	private int id;
	private String estilo;
	
	public Estilo() {
		id = 0;
		estilo = "";
	}
	
	public Estilo (int id, String estilo) {
		this.id = id;
		this.estilo = estilo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	@Override
	public String toString() {
		return "Estilo [id=" + id + ", estilo=" + estilo + "]";
	}

}
