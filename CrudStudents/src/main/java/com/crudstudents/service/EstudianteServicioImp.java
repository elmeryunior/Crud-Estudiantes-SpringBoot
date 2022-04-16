package com.crudstudents.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudstudents.entity.Estudiante;
import com.crudstudents.repository.EstudianteRepository;

@Service
public class EstudianteServicioImp implements EstudianteServicio {

	@Autowired
	private EstudianteRepository repository;

	@Override
	public List<Estudiante> listarAll() {
		return repository.findAll();
	}

	@Override
	public Estudiante guardarEstudiante(Estudiante estudiante) {
		return repository.save(estudiante);
	}

	@Override
	public Estudiante obtenerEstudianteId(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public Estudiante actualizarEstudiante(Estudiante estudiante) {
		return repository.save(estudiante);
	}

	@Override
	public void eliminarEstudianteId(Integer id) {
		repository.deleteById(id);
	}

}
