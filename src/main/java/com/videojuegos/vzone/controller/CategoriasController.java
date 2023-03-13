package com.videojuegos.vzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.videojuegos.vzone.entity.Categoria;
import com.videojuegos.vzone.service.IntCategoriasService;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private IntCategoriasService serviceCategorias;
	
	
	@GetMapping("/consultar")
	public String buscar(@RequestParam("id") int idCategoria, Model model) {
		Categoria categoria = serviceCategorias.buscarPorId(idCategoria);
		model.addAttribute("categoria", categoria);
		return "categorias/formCategoria";
	}
	
	@PostMapping("/guardar")
	public String guardar(Categoria categoria) {
		System.out.println(categoria);
		serviceCategorias.guardar(categoria);
		return "redirect:/categorias/index";
	}
	
	@GetMapping("/nueva")
	public String nuevaCategoria(Categoria categoria) {
		return "categorias/formCategoria";
	}
	
	@GetMapping("/eliminar")
	public String eliminarCategoria(@RequestParam("id") int idCategoria, RedirectAttributes model) {
		model.addFlashAttribute("msg1", "Categoria eliminada");
		serviceCategorias.eliminar(idCategoria);
		return "redirect:/categorias/index";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria> categorias = serviceCategorias.obtenerCategorias();
		model.addAttribute("categorias", categorias);
		model.addAttribute("total", serviceCategorias.numeroCategorias());
		return "categorias/listaCategorias";
	}
	
}
