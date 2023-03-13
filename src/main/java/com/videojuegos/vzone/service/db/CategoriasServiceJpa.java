package com.videojuegos.vzone.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.videojuegos.vzone.entity.Categoria;
import com.videojuegos.vzone.repository.CategoriasRepository;
import com.videojuegos.vzone.service.IntCategoriasService;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Primary
public class CategoriasServiceJpa implements IntCategoriasService {

	@Autowired
	private CategoriasRepository repoCategoria;
	
	@Override
	public void guardar(Categoria categoria) {
		repoCategoria.save(categoria);
	}
	
	@Override
	public List<Categoria> obtenerCategorias(){
		return repoCategoria.findAll();
	}
	
	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		Optional<Categoria> optional = repoCategoria.findById(idCategoria);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@Override
	public void eliminar(Integer idCategoria) {
		repoCategoria.deleteById(idCategoria);
	}
	
	@Override
	public int numeroCategorias() {
		return (int) repoCategoria.count();
	}
	
}
