/**
 * 
 */
package com.examen.backend.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.examen.backend.domain.Trabajos;

/**
 * @author Norman
 *
 */
public interface TrabajosService {

	/**
	 * Save Trabajos
	 * 
	 * @param trabajos
	 * @return
	 */
	Trabajos save(Trabajos trabajos);

	/**
	 * Get all the trabajos.
	 *
	 * @param pageable the pagination information.
	 * @return the list of entities.
	 */
	Page<Trabajos> findAll(Pageable pageable);

	/**
	 * Get the "id" trabajos.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	Optional<Trabajos> findOne(Long id);

	/**
	 * Delete the "id" trabajos.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id);
}
