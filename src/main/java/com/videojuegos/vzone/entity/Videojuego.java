package com.videojuegos.vzone.entity;

import java.time.LocalDate;

import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="videojuegos")

public class Videojuego {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private String nombre;
	private String caracteristicas;
	private LocalDate fecha = LocalDate.now();
	private Double precio;
	//******************************
	private String estatus;
	private int destacado;
	private String detalles;
	//******************************
	private String imagen="error.png";
	
	@OneToOne
	@JoinColumn(name="idCategoria")
	private Categoria categoria;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String  estatus) {
		this.estatus = estatus;
	}
	
	public int getDestacado() {
		return destacado;
	}
	public void setDestacado(int  destacado) {
		this.destacado = destacado;
	}
	
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String  detalles) {
		this.detalles = detalles;
	}
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "Videojuego [id="+id+", nombre="+nombre+", caracteristicas="+caracteristicas+", fecha="+fecha+", precio="+precio+", estatus="+estatus+", destacado="+destacado+", detalles="+detalles+", imagen="+imagen+",categoria=" + categoria + "]";
	}
}
