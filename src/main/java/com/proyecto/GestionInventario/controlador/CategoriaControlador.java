package com.proyecto.GestionInventario.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.GestionInventario.modelo.Categoria;
import com.proyecto.GestionInventario.servicio.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaControlador {
	
	private CategoriaService categoriaService;
	
	@Autowired
	public CategoriaControlador(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@PostMapping("/crear")
	public ResponseEntity<String> crearCategoria(@RequestBody @Valid Categoria categoria){
		return categoriaService.crearCategoria(categoria);
	}
	
	@GetMapping("/obtener")
	public ResponseEntity<?> obtenerCategoria(){
		return categoriaService.obtenerCategoria();
	}
	
	@PatchMapping("/editar/{id}") 
	public ResponseEntity<?> editarCategoria(
				@PathVariable int id, 
				@RequestParam String categoria){
		return categoriaService.editarCategoria(id, categoria);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarCategoria(@PathVariable int id){
		
		return categoriaService.eliminarCategoria(id);
	}

}
