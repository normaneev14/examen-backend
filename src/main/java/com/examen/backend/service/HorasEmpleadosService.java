/**
 * 
 */
package com.examen.backend.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.examen.backend.domain.HorasEmpleados;

/**
 * @author Norman
 *
 */
public interface HorasEmpleadosService {

	
	/**
	 * Save HorasEmpleados
	 * 
	 * @param horasEmpleados
	 * @return
	 */
	HorasEmpleados save(HorasEmpleados horasEmpleados);

	/**
	 * Get all the horasEmpleados.
	 *
	 * @param pageable the pagination information.
	 * @return the list of entities.
	 */
	Page<HorasEmpleados> findAll(Pageable pageable);

	/**
	 * Get the "id" horasEmpleados.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	Optional<HorasEmpleados> findOne(Long id);

	/**
	 * Delete the "id" horasEmpleados.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id);
}
