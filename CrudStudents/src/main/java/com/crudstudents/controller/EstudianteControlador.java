package com.crudstudents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crudstudents.entity.Estudiante;
import com.crudstudents.service.EstudianteServicio;

@Controller
public class EstudianteControlador {

	@Autowired
	private EstudianteServicio estudianteServicio;

	@GetMapping({ "/estudiantes", "/" })
	public String listarEstudiantes(Model model) {
		model.addAttribute("estudiantes", estudianteServicio.listarAll());
		return "estudiantes";
	}

	@GetMapping("/estudiantes/nuevo")
	public String nuevoEstudianteFormulario(Model model) {
		Estudiante estudiante = new Estudiante();
		model.addAttribute("estudiante", estudiante);
		return "nuevo_estudiante";
	}

	@PostMapping("/estudiantes")
	public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
		estudianteServicio.guardarEstudiante(estudiante);
		return "redirect:/estudiantes";
	}

	@GetMapping("/estudiantes/editar/{id}")
	public String editarEstudianteFormulario(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("estudiante", estudianteServicio.obtenerEstudianteId(id));
		return "editar_estudiante";
	}

	@PostMapping("/estudiantes/{id}")
	public String guardarEstudiante(@PathVariable("id") Integer id, Model model,
			@ModelAttribute("estudiante") Estudiante estudiante) {
		Estudiante estudianteExist = estudianteServicio.obtenerEstudianteId(id);
		estudianteExist.setId(id);
		estudianteExist.setNombre(estudiante.getNombre());
		estudianteExist.setApellidos(estudiante.getApellidos());
		estudianteExist.setEmail(estudiante.getEmail());
		estudianteServicio.actualizarEstudiante(estudianteExist);
		return "redirect:/estudiantes";
	}

	@GetMapping("/estudiantes/{id}")
	public String eliminarEstudiante(@PathVariable("id") Integer id) {
		estudianteServicio.eliminarEstudianteId(id);
		return "redirect:/estudiantes";
	}
}
