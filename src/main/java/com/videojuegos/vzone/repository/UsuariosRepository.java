package com.videojuegos.vzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.videojuegos.vzone.entity.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer>{

}
