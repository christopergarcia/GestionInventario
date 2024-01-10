package com.proyecto.GestionInventario.servicio;

import java.util.List;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyecto.GestionInventario.modelo.Categoria;
import com.proyecto.GestionInventario.repositorio.CategoriaRepositorio;

@Service
public class CategoriaServiceImp implements CategoriaService{
	
	private CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	public CategoriaServiceImp(CategoriaRepositorio categoriaRepositorio) {
		this.categoriaRepositorio = categoriaRepositorio;
	}

	@Override
	public ResponseEntity<String> crearCategoria(Categoria categoria) {
		if(categoria != null) {
			categoriaRepositorio.save(categoria);
			return new ResponseEntity<String>("Registro Completo", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Error en el registro", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> obtenerCategoria() {
		List<Categoria> categoria = categoriaRepositorio.findAll();
		
		HttpStatus status = categoria.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		
		return new ResponseEntity<>(categoria, status);
	}

	@Override
	public ResponseEntity<?> buscarCategoria(int id) {
		categoriaRepositorio.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("La categoria no existe: " + id));

return new ResponseEntity<>(categoriaRepositorio.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> editarCategoria(int id, String categoriaDetalles) {
		Categoria categoria = categoriaRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El producto no existe: " + id));
		
		categoria.setNombre(categoriaDetalles);
		categoriaRepositorio.save(categoria);
		
		return new ResponseEntity<>(categoriaDetalles, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> eliminarCategoria(int id) {
		Categoria categoria = categoriaRepositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El producto no existe: " + id));
		categoriaRepositorio.deleteById(id);
		
		return new ResponseEntity<>("Categoria eliminada: " + categoria.getNombre(), HttpStatus.OK);
	}

}
