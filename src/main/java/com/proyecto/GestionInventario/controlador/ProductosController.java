package com.proyecto.GestionInventario.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.GestionInventario.modelo.Productos;
import com.proyecto.GestionInventario.servicio.ProductosServiceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/productos")
public class ProductosController {
	
	private ProductosServiceImp productosServiceImp;
	
	@Autowired
	public ProductosController(ProductosServiceImp productosServiceImp) {
		this.productosServiceImp = productosServiceImp;
	}
	
	@PostMapping("/crearProducto")
	public ResponseEntity<String> crearProducto(@RequestBody @Valid Productos productos){
		return productosServiceImp.crearProducto(productos);
	}
	
	@GetMapping("/obtenerProductos")
	public ResponseEntity<?> obtenerProductos(){
		return productosServiceImp.obtenerProductos();
	}
	
	@PatchMapping("/restarCantidad/{id}")
	public ResponseEntity<?> restarProductos(
			@PathVariable int id,
			@RequestParam int cantidad){
		return productosServiceImp.restarCantidad(id, cantidad);
	}
	
	@PatchMapping("/agregarCantidad/{id}")
	public ResponseEntity<?> agregarCantidad(
			@PathVariable int id, 
			@RequestParam int cantidad){
		return productosServiceImp.agregarCantidad(id, cantidad);
	}
	
	@PutMapping("/modificarProducto/{id}")
	public ResponseEntity<?> modificarProducto(
			@PathVariable int id,
			@RequestBody Productos productoDetalle){
		return productosServiceImp.modificiarProducto(id, productoDetalle);
	}

}
