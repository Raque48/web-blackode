package com.videojuegos.vzone.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.videojuegos.vzone.entity.Videojuego;
import com.videojuegos.vzone.repository.VideojuegosRepository;
import com.videojuegos.vzone.service.IntVideojuegosService;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Primary
public class VideojuegosServiceJpa implements IntVideojuegosService {
	
	@Autowired
	private VideojuegosRepository repoVideojuego;
	
	@Override
	public void guardar(Videojuego videojuego) {
		repoVideojuego.save(videojuego);
		
	}
	
	@Override
	public List<Videojuego> obtenerVideojuegos(){
		return repoVideojuego.findAll();
	}
	
	@Override
	public Videojuego buscarPorId(int idVideojuego) {
		Optional<Videojuego> optional = repoVideojuego.findById(idVideojuego);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@Override
	public void eliminar(int idVideojuego) {
		repoVideojuego.deleteById(idVideojuego);
	}

}
