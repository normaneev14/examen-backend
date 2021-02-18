/**
 * 
 */
package com.examen.backend.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.backend.domain.Generos;
import com.examen.backend.repository.GenerosRepository;
import com.examen.backend.service.GenerosService;
import com.examen.backend.service.dto.GenerosDTO;

/**
 * @author Norman
 *
 */
@Service
@Transactional
public class GenerosServiceImpl implements GenerosService {

	/**
	 * Logger
	 */
	private final Logger log = LoggerFactory.getLogger(GenerosServiceImpl.class);

	/**
	 * Repository
	 */
	private final GenerosRepository generosRepository;

	/**
	 * GenerosServiceImpl
	 * 
	 * @param generosRepository
	 */
	public GenerosServiceImpl(GenerosRepository generosRepository) {
		this.generosRepository = generosRepository;
	}

	/**
	 * Save Genero
	 */
	@Override
	public Generos save(Generos generos) {
		log.debug("Request to save Generos : {}", generos);
		return generosRepository.save(generos);
	}

	/**
	 * FindAll
	 */
	@Override
	public Page<Generos> findAll(Pageable pageable) {
		log.debug("Request to get all Generos");
		return generosRepository.findAll(pageable);
	}

	/**
	 * FindOne
	 */
	@Override
	public Optional<Generos> findOne(Long id) {
		log.debug("Request to get Generos : {}", id);
		return generosRepository.findById(id);
	}

	/**
	 * Delete by id
	 */
	@Override
	public void delete(Long id) {
		log.debug("Request to delete Generos : {}", id);
		generosRepository.deleteById(id);

	}

	
	/**
	 * Update Generos
	 */
	@Override
	public Optional<Generos> updateGeneros(GenerosDTO dto) throws Exception {
		return Optional.of(generosRepository
	            .findById(dto.getId()))
	            .filter(Optional::isPresent)
	            .map(Optional::get)
	            .map( generos -> {
	            	generos.setId(dto.getId());
	            	generos.setName(dto.getName());	
	            	return generos;
	            }
	            		);	
	}

}
