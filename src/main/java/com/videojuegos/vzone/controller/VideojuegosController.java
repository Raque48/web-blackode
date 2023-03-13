package com.videojuegos.vzone.controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.videojuegos.vzone.entity.Categoria;
import com.videojuegos.vzone.entity.Videojuego;
import com.videojuegos.vzone.service.IntCategoriasService;
import com.videojuegos.vzone.service.IntVideojuegosService;
import com.videojuegos.vzone.util.Utileria;

@Controller
@RequestMapping("/videojuegos")
public class VideojuegosController {
	@Autowired
	private IntCategoriasService serviceCategorias;
	
	@Autowired
	private IntVideojuegosService serviceVideojuegos;
	
	@GetMapping("/detalle")
	public String detalles(@RequestParam("id") int idVideojuego, Model model) {
		model.addAttribute("videojuego", serviceVideojuegos.buscarPorId(idVideojuego));
		return "videojuegos/detalle";
	}
	
	@PostMapping("/guardar")
	public String guardar(Videojuego videojuego, BindingResult result, @RequestParam("archivoImagen") MultipartFile multiPart, RedirectAttributes model) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
			}
			return "videojuegos/formVideojuego";
		}
		if(!multiPart.isEmpty()) {
			String ruta = "c:/videojuegos/img-videojuegos/";
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if(nombreImagen != null) {
				videojuego.setImagen(nombreImagen);
			}
		}
		if(videojuego.getId() == null)model.addFlashAttribute("msg", "Videojuego agregado");
		else model.addFlashAttribute("msg", "Videojuego modificado");
		
		serviceVideojuegos.guardar(videojuego);
		return "redirect:/videojuegos/index";
	}
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("id") int idVideojuego, Model model) {
		model.addAttribute("videojuego", serviceVideojuegos.buscarPorId(idVideojuego));
		model.addAttribute("categorias", serviceCategorias.obtenerCategorias());
		return "videojuegos/formVideojuego";
	}
	
	@GetMapping("/nueva")
	public String nueva(Videojuego videojuego, Model model) {
		model.addAttribute("categorias", serviceCategorias.obtenerCategorias());
		return "videojuegos/formVideojuego";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam("id") int idVideojuego, RedirectAttributes model) {
		model.addFlashAttribute("msg", "Videojuego eliminado");
		serviceVideojuegos.eliminar(idVideojuego);
		return "redirect:/videojuegos/index";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		model.addAttribute("videojuegos", serviceVideojuegos.obtenerVideojuegos());
		return "videojuegos/listaVideojuegos";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException{
				setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			}
			@Override
			public String getAsText() throws IllegalArgumentException{
				return DateTimeFormatter.ofPattern("dd-MM-yyyy").format((LocalDate) getValue());
			}
		});
	}
	
}
