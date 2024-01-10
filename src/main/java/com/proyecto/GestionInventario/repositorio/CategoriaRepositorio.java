package com.proyecto.GestionInventario.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.GestionInventario.modelo.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer>{

}
