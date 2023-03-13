package com.videojuegos.vzone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	private String nombre;
	private String apellidoP;
	private String apellidoM;
	private String correoElec;
	private String contra;
	private String confirmarContra;
	//******************************
	//private String detalles;
	
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
	
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	
	public String getApellidoM() {
		return apellidoM;
	}
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	
	public String getCorreoElec() {
		return correoElec;
	}
	public void setCorreoElec(String correoElec) {
		this.correoElec = correoElec;
	}
	
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	
	public String getConfirmarContra() {
		return confirmarContra;
	}
	public void setConfirmarContra(String confirmarContra) {
		this.confirmarContra = confirmarContra;
	}

	/*public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String  detalles) {
		this.detalles = detalles;
	}*/
	
	@Override
	public String toString() {
		return "Usuario [id="+id+", nombre="+nombre+", apellidoP="+apellidoP+", apellidoM="+apellidoM+", correoElec="+correoElec+", contra="+contra+", confirmarContra="+confirmarContra+"]";
	}
	
}
