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

import com.examen.backend.domain.Trabajos;
import com.examen.backend.repository.TrabajosRepository;
import com.examen.backend.service.TrabajosService;

/**
 * @author Norman
 *
 */
@Service
@Transactional
public class TrabajosServiceImpl implements TrabajosService {

	/**
	 * Logger
	 */
	private final Logger log = LoggerFactory.getLogger(TrabajosServiceImpl.class);

	/**
	 * Repository
	 */
	private final TrabajosRepository trabajosRepository;

	/**
	 * TrabajosServiceImpl
	 * 
	 * @param trabajosRepository
	 */
	public TrabajosServiceImpl(TrabajosRepository trabajosRepository) {
		this.trabajosRepository = trabajosRepository;
	}

	/**
	 * Save Trabajos
	 */
	@Override
	public Trabajos save(Trabajos trabajos) {
		log.debug("Request to save Trabajos : {}", trabajos);
		return trabajosRepository.save(trabajos);
	}

	/**
	 * Find All
	 */
	@Override
	public Page<Trabajos> findAll(Pageable pageable) {
		log.debug("Request to get all Trabajos");
		return trabajosRepository.findAll(pageable);
	}

	/**
	 * Find One
	 */
	@Override
	public Optional<Trabajos> findOne(Long id) {
		log.debug("Request to get Trabajos : {}", id);
		return trabajosRepository.findById(id);
	}

	/**
	 * Delete by id
	 */
	@Override
	public void delete(Long id) {
		log.debug("Request to delete Trabajos : {}", id);
		trabajosRepository.deleteById(id);

	}

}
