package com.proyecto.GestionInventario.servicio;

import org.springframework.http.ResponseEntity;

import com.proyecto.GestionInventario.modelo.Productos;

public interface ProductosService {
	
	public ResponseEntity<String> crearProducto(Productos productos);
	
	public ResponseEntity<?> obtenerProductos();
	
	public ResponseEntity<?> buscarProducto(int id);
	
	public ResponseEntity<?> restarCantidad(int id, int cantidad);
	
	public ResponseEntity<?> agregarCantidad(int id, int cantidad);
	
	public ResponseEntity<?> modificiarProducto(int id, Productos productos);
	
	

}
