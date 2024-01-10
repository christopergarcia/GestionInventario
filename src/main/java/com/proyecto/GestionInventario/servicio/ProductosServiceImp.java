package com.proyecto.GestionInventario.servicio;

import java.util.List;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyecto.GestionInventario.modelo.Productos;
import com.proyecto.GestionInventario.repositorio.ProductosRepositorio;

@Service
public class ProductosServiceImp implements ProductosService{
	
	@Autowired
	private ProductosRepositorio productosRepositorio;

	@Override
	public ResponseEntity<String> crearProducto(Productos productos) {
		if(productos != null) {
			productosRepositorio.save(productos);
			return new ResponseEntity<String>("Registro Completo", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Error en el registro", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> obtenerProductos() {
		List<Productos> productos = productosRepositorio.findAll();
		
		HttpStatus status = productos.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		
		return new ResponseEntity<>(productos, status);
	}

	@Override
	public ResponseEntity<?> buscarProducto(int id) {
		productosRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El producto no existe: " + id));
		
		return new ResponseEntity<>(productosRepositorio.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> restarCantidad(int id, int cantidad) {
		Productos productos = productosRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El producto no existe: " + id));
		
		int cantidadTotal = productos.getCantidad();
			
		if(cantidadTotal >= cantidad) {
				
			productos.setCantidad(cantidadTotal -= cantidad);
			
			productosRepositorio.save(productos);
				
			return new ResponseEntity<>("Cantidad actualizada " + (productos.getCantidad()), HttpStatus.OK);
		}
			
		return new ResponseEntity<>("La cantidad no puede ser mayor a la existencia", HttpStatus.NOT_ACCEPTABLE);
			
	}

	@Override
	public ResponseEntity<?> agregarCantidad(int id, int cantidad) {
		
		Productos productos = productosRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El producto no existe: " + id));
		
		productos.setCantidad(productos.getCantidad() + cantidad);
		productosRepositorio.save(productos);
		
		return ResponseEntity.ok("Cantidad total: " + productos.getCantidad());
	}

	@Override
	public ResponseEntity<?> modificiarProducto(int id, Productos productosDetalle) {
		Productos productos = productosRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El producto no existe: " + id));
		
		productos.setNombre(productosDetalle.getNombre());
		productos.setDescripcion(productosDetalle.getDescripcion());
		productos.setCategoriaId(productosDetalle.getCategoriaId());
		
		productosRepositorio.save(productos);
		
		return new ResponseEntity<>(productos, HttpStatus.OK);
	}

}
