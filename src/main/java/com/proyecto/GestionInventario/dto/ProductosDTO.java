package com.proyecto.GestionInventario.dto;

import com.proyecto.GestionInventario.modelo.Categoria;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductosDTO {
	
	private int id;
	private String nombre;
	private String descripcion;
	private Categoria categoriaId;
	
	public ProductosDTO() {
		super();
	}

}
