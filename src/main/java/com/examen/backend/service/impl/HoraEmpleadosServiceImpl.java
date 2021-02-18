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

import com.examen.backend.domain.HorasEmpleados;
import com.examen.backend.repository.HorasEmpleadosRepository;
import com.examen.backend.service.HorasEmpleadosService;

/**
 * @author Norman
 *
 */
@Service
@Transactional
public class HoraEmpleadosServiceImpl implements HorasEmpleadosService {

	/**
	 * Logger
	 */
	private final Logger log = LoggerFactory.getLogger(HoraEmpleadosServiceImpl.class);

	/**
	 * Repository
	 */
	private final HorasEmpleadosRepository horasEmpleadosRepository;

	/**
	 * HoraEmpleadosServiceImpl
	 * 
	 * @param horasEmpleadosRepository
	 */
	public HoraEmpleadosServiceImpl(HorasEmpleadosRepository horasEmpleadosRepository) {
		this.horasEmpleadosRepository = horasEmpleadosRepository;
	}

	/**
	 * Save HorasEmpleados
	 */
	@Override
	public HorasEmpleados save(HorasEmpleados horasEmpleados) {
		log.debug("Request to save HorasEmpleados : {}", horasEmpleados);
		return horasEmpleadosRepository.save(horasEmpleados);
	}

	/**
	 * Find All
	 */
	@Override
	public Page<HorasEmpleados> findAll(Pageable pageable) {
		log.debug("Request to get all HorasEmpleados");
		return horasEmpleadosRepository.findAll(pageable);
	}

	/**
	 * Find One
	 */
	@Override
	public Optional<HorasEmpleados> findOne(Long id) {
		log.debug("Request to get HorasEmpleados : {}", id);
		return horasEmpleadosRepository.findById(id);
	}

	/**
	 * Delete by id
	 */
	@Override
	public void delete(Long id) {
		log.debug("Request to delete HorasEmpleados : {}", id);
		horasEmpleadosRepository.deleteById(id);

	}

}
