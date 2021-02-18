/**
 * 
 */
package com.examen.backend.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.examen.backend.domain.Empleados;
import com.examen.backend.service.dto.EmpleadosDTO;

/**
 * @author Norman
 *
 */
public interface EmpleadosService {

	/**
	 * Save Empleados
	 * 
	 * @param empleados
	 * @return
	 */
	Empleados save(Empleados empleados);

	/**
	 * Get all the empleados.
	 *
	 * @param pageable the pagination information.
	 * @return the list of entities.
	 */
	Page<Empleados> findAll(Pageable pageable);
	
	/**
	 * Update
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	Optional<Empleados> updateEmpleados(EmpleadosDTO dto) throws Exception;

	/**
	 * Get the "id" empleados.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	Optional<Empleados> findOne(Long id);

	/**
	 * Delete the "id" empleados.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id);
}
