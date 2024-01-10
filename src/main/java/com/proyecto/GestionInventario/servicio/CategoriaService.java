package com.proyecto.GestionInventario.servicio;

import org.springframework.http.ResponseEntity;

import com.proyecto.GestionInventario.modelo.Categoria;

public interface CategoriaService {
	
	public ResponseEntity<String> crearCategoria(Categoria categoria);
	
	public ResponseEntity<?> obtenerCategoria();
	
	public ResponseEntity<?> buscarCategoria(int id);
	
	public ResponseEntity<?> editarCategoria(int id, String categoria);
	
	public ResponseEntity<?> eliminarCategoria(int id);
	

}
