package com.proyecto.GestionInventario.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.GestionInventario.modelo.Productos;

public interface ProductosRepositorio extends JpaRepository<Productos, Integer>{

}
