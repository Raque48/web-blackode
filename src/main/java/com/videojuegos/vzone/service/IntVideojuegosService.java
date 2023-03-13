package com.videojuegos.vzone.service;

import java.util.List;

import com.videojuegos.vzone.entity.Videojuego;

public interface IntVideojuegosService {
	
	public List<Videojuego> obtenerVideojuegos();
	public void guardar(Videojuego videojuego);
	public void eliminar(int idVideojuego);
	public Videojuego buscarPorId(int idVideojuego);

}
