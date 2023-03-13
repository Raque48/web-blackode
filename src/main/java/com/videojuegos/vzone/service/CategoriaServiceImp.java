package com.videojuegos.vzone.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.videojuegos.vzone.entity.Categoria;

@Service
public class CategoriaServiceImp implements IntCategoriasService {
	
	private List<Categoria> categorias;
	
	public CategoriaServiceImp() {
		categorias = new LinkedList<>();
		
		Categoria c1 = new Categoria();
		c1.setId(1);
		c1.setNombre("Terror");
		c1.setDescripcion("hdewpifwpfb");
		
		Categoria c2 = new Categoria();
		c2.setId(2);
		c2.setNombre("Acción");
		c2.setDescripcion("widweqjq");
		
		categorias.add(c1);
		categorias.add(c2);
	}
	
	@Override
	public void guardar(Categoria categoria) {
		categorias.add(categoria);
	}
	
	@Override
	public List<Categoria> obtenerCategorias(){
		return categorias;
	}
	
	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for(Categoria c: categorias) {
			if(c.getId().compareTo(idCategoria) == 0) {
				return c;
			}
		}
		return null;
	}
	
	@Override
	public void eliminar(Integer idCategoria) {
		categorias.remove(buscarPorId(idCategoria));
	}
	
	@Override
	public int numeroCategorias() {
		return categorias.size();
	}
	
}
