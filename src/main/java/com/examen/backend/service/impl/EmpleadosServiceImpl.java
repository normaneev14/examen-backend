/**
 * 
 */
package com.examen.backend.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.backend.domain.Empleados;
import com.examen.backend.repository.EmpleadosRepository;
import com.examen.backend.service.EmpleadosService;
import com.examen.backend.service.dto.EmpleadosDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Norman
 *
 */
@Service
@Transactional
public class EmpleadosServiceImpl implements EmpleadosService {

	/**
	 * Logger
	 */
	private final Logger log = LoggerFactory.getLogger(EmpleadosServiceImpl.class);

	/**
	 * Repository
	 */
	private final EmpleadosRepository empleadosRepository;

	/**
	 * EmpleadosServiceImpl
	 * 
	 * @param empleadosRepository
	 */
	public EmpleadosServiceImpl(EmpleadosRepository empleadosRepository) {
		this.empleadosRepository = empleadosRepository;
	}

	/**
	 * Save Employye
	 */
	@Override
	public Empleados save(Empleados empleados) {
		log.debug("Request to save Empleados : {}", empleados);
		return empleadosRepository.save(empleados);
	}

	/**
	 * FindAll
	 */
	@Override
	public Page<Empleados> findAll(Pageable pageable) {
		log.debug("Request to get all Empleados");
		return empleadosRepository.findAll(pageable);
	}

	/**
	 * Find One
	 */
	@Override
	public Optional<Empleados> findOne(Long id) {
		log.debug("Request to get Empleados : {}", id);
		return empleadosRepository.findById(id);
	}

	/**
	 * Delete by id
	 */
	@Override
	public void delete(Long id) {
		log.debug("Request to delete Empleados : {}", id);
		empleadosRepository.deleteById(id);

	}

	/**
	 * Update
	 */
	@Override
	public Optional<Empleados> updateEmpleados(EmpleadosDTO dto) throws Exception {
		return Optional.of(empleadosRepository.findById(dto.getId())).filter(Optional::isPresent).map(Optional::get)
				.map(employee -> {
					employee.setName(dto.getName());
					employee.setLastName(dto.getLastName());
					employee.setBirthdate(dto.getBirthdate());
					return employee;
				});
	}

}
