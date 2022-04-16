package com.crudstudents.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crudstudents.entity.Estudiante;

@Service
public interface EstudianteServicio {

	public List<Estudiante> listarAll();
	
	public Estudiante guardarEstudiante(Estudiante estudiante);
	
	public Estudiante obtenerEstudianteId(Integer id);
	
	public Estudiante actualizarEstudiante(Estudiante estudiante);
	
	public void eliminarEstudianteId(Integer id);
}
