package com.videojuegos.vzone.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.videojuegos.vzone.entity.Videojuego;

@Service
public class VideojuegosServiceImp implements IntVideojuegosService{
	
	private List<Videojuego> videojuegos;
	
	public VideojuegosServiceImp() {
		videojuegos = new LinkedList<Videojuego>();
		DateTimeFormatter formato =DateTimeFormatter.ofPattern("dd-mm-yyyy");
		
		try {
			Videojuego v1 = new Videojuego();
			v1.setId(1);
			v1.setNombre("");
			v1.setCaracteristicas("");
			v1.setFecha(LocalDate.parse("12-12-2022",formato));
			v1.setPrecio(2050.0);
			v1.setEstatus("Creada");
			v1.setDestacado(1);
			v1.setDetalles("<h2><strong>Requisitos</strong></h2>");
			
			Videojuego v2 = new Videojuego();
			v2.setId(2);
			v2.setNombre("");
			v2.setCaracteristicas("");
			v1.setFecha(LocalDate.parse("12-12-2022",formato));
			v2.setPrecio(1050.0);
			v1.setEstatus("Creada");
			v1.setDestacado(0);
			v1.setDetalles("<h2><strong>Requisitos</strong></h2>");
			
			videojuegos.add(v1);
			videojuegos.add(v2);
			
		}catch(DateTimeParseException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	@Override
	public void guardar(Videojuego videojuego) {
		videojuegos.add(videojuego);
	}
	
	@Override
	public List<Videojuego> obtenerVideojuegos(){
		return videojuegos;
	}
	
	@Override
	public Videojuego buscarPorId(int idVideojuego) {
		Videojuego videojuego = null;
		for(Videojuego v: videojuegos) {
			if(v.getId()==idVideojuego) {
				videojuego=v;
			}
		}
		return videojuego;
	}
	
	@Override
	public void eliminar(int idVideojuego) {
		videojuegos.remove(buscarPorId(idVideojuego));
	}

}
