package com.videojuegos.vzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.videojuegos.vzone.entity.Videojuego;

public interface VideojuegosRepository extends JpaRepository<Videojuego, Integer>{

}
