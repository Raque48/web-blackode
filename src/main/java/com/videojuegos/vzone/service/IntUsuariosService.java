package com.videojuegos.vzone.service;

import java.util.List;

import com.videojuegos.vzone.entity.Usuario;

public interface IntUsuariosService {
	
	public List<Usuario> obtenerUsuarios();
	public void guardar(Usuario usuario);
	public void eliminar(int idUsuario);
	public Usuario buscarPorId(int idUsuario);

}
