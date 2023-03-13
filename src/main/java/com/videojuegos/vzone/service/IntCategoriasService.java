package com.videojuegos.vzone.service;

import java.util.List;

import com.videojuegos.vzone.entity.Categoria;

public interface IntCategoriasService {
	
	public void guardar(Categoria categoria);
	public List<Categoria> obtenerCategorias();
	public Categoria buscarPorId(Integer idCategoria);
	public void eliminar (Integer idCategoria);
	public int numeroCategorias();
	
	//public Double calcularPromedio();
	
}
