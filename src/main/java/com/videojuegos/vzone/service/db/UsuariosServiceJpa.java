package com.videojuegos.vzone.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.videojuegos.vzone.entity.Usuario;
import com.videojuegos.vzone.repository.UsuariosRepository;
import com.videojuegos.vzone.service.IntUsuariosService;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Primary
public class UsuariosServiceJpa implements IntUsuariosService{

	@Autowired
	private UsuariosRepository repoUsuario;
	
	@Override
	public void guardar(Usuario usuario) {
		repoUsuario.save(usuario);
		
	}
	
	@Override
	public List<Usuario> obtenerUsuarios(){
		return repoUsuario.findAll();
	}
	
	@Override
	public Usuario buscarPorId(int idUsuario) {
		Optional<Usuario> optional = repoUsuario.findById(idUsuario);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@Override
	public void eliminar(int idUsuario) {
		repoUsuario.deleteById(idUsuario);
	}
	
}
