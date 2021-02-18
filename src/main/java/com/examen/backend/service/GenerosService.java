/**
 * 
 */
package com.examen.backend.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.examen.backend.domain.Generos;
import com.examen.backend.service.dto.GenerosDTO;

/**
 * @author Norman
 *
 */
public interface GenerosService {

	
	/**
	 * Save Generos
	 * 
	 * @param generos
	 * @return
	 */
	Generos save(Generos generos);

	/**
	 * Get all the generos.
	 *
	 * @param pageable the pagination information.
	 * @return the list of entities.
	 */
	Page<Generos> findAll(Pageable pageable);
	
	/**
	 * Update
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	Optional<Generos> updateGeneros(GenerosDTO dto) throws Exception;

	/**
	 * Get the "id" generos.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	Optional<Generos> findOne(Long id);

	/**
	 * Delete the "id" generos.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id);
}
