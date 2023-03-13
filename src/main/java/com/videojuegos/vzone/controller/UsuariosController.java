package com.videojuegos.vzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.videojuegos.vzone.entity.Usuario;
import com.videojuegos.vzone.entity.Videojuego;
import com.videojuegos.vzone.service.IntUsuariosService;
import com.videojuegos.vzone.util.Utileria;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private IntUsuariosService serviceUsuarios;
	
	@GetMapping("/detalle")
	public String detalles(@RequestParam("id") int idUsuario, Model model) {
		model.addAttribute("usuario", serviceUsuarios.buscarPorId(idUsuario));
		return "usuarios/detalle";
	}
	
	/*@GetMapping("/consultar")
	public String buscar(@RequestParam("id") int idUsuario, Model model) {
		Usuario usuario = serviceUsuarios.buscarPorId(idUsuario);
		model.addAttribute("usuario", usuario);
		return "usuarios/formUsuario";
	}*/
	
	@PostMapping("/guardar")
	public String guardar(Usuario usuario, BindingResult result, MultipartFile multiPart, RedirectAttributes model) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
			}
			return "usuarios/formUsuario";
		}
		
		if(usuario.getId() == null)model.addFlashAttribute("msg", "Usuario agregado");
		else model.addFlashAttribute("msg", "Usuario modificado");
		
		serviceUsuarios.guardar(usuario);
		return "redirect:/usuarios/index";
	}
	
	/*@PostMapping("/guardar")
	public String guardar(Usuario usuario) {
		System.out.println(usuario);
		serviceUsuarios.guardar(usuario);
		return "redirect:/usuarios/index";
	}*/
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("id") int idUsuario, Model model) {
		model.addAttribute("usuario", serviceUsuarios.buscarPorId(idUsuario));
		//model.addAttribute("categorias", serviceCategorias.obtenerCategorias());
		return "usuarios/formUsuario";
	}
	
	@GetMapping("/nueva")
	public String nuevoUsuario(Usuario usuario) {
		return "usuarios/formUsuario";
	}
	
	@GetMapping("/eliminar")
	public String eliminarUsuario(@RequestParam("id") int idUsuario, RedirectAttributes model) {
		model.addFlashAttribute("msg1", "Usuario eliminado");
		serviceUsuarios.eliminar(idUsuario);
		return "redirect:/usuarios/index";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Usuario> usuarios = serviceUsuarios.obtenerUsuarios();
		model.addAttribute("usuarios", usuarios);
		//model.addAttribute("total", serviceUsuarios.numeroUsuarios());
		return "usuarios/listaUsuarios";
	}
	
}
