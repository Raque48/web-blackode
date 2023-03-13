package com.videojuegos.vzone.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.videojuegos.vzone.entity.Usuario;

@Service
public class UsuariosServiceImp implements IntUsuariosService{
	
	private List<Usuario> usuarios;
	
	public UsuariosServiceImp() {
		usuarios = new LinkedList<Usuario>();
	
	try {
		Usuario u1 = new Usuario();
		u1.setId(1);
		u1.setNombre("");
		u1.setApellidoP("");
		u1.setApellidoM("");
		u1.setCorreoElec("");
		u1.setContra("");
		u1.setConfirmarContra("");
		
		Usuario u2 = new Usuario();
		u2.setId(2);
		u2.setNombre("");
		u2.setApellidoP("");
		u2.setApellidoM("");
		u2.setCorreoElec("");
		u2.setContra("");
		u2.setConfirmarContra("");
		
		usuarios.add(u1);
		usuarios.add(u2);
	}catch(DateTimeParseException ex) {
		System.out.println(ex.getMessage());
	}
	}
	
	@Override
	public void guardar(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	@Override
	public List<Usuario> obtenerUsuarios(){
		return usuarios;
	}
	
	@Override
	public Usuario buscarPorId(int idUsuario) {
		Usuario usuario = null;
		for(Usuario u: usuarios) {
			if(u.getId()==idUsuario) {
				usuario=u;
			}
		}
		return usuario;
	}
	
	@Override
	public void eliminar(int idUsuario) {
		usuarios.remove(buscarPorId(idUsuario));
	}
	
}
