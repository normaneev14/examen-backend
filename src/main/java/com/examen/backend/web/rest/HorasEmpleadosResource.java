/**
 * 
 */
package com.examen.backend.web.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.examen.backend.domain.HorasEmpleados;
import com.examen.backend.service.HorasEmpleadosService;
import com.examen.backend.utils.RestConstants;

import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * @author Norman
 *
 */
@RestController
@RequestMapping(RestConstants.PATH_API)
public class HorasEmpleadosResource {

	
	/**
	 * Logger
	 */
	private final Logger log = LoggerFactory.getLogger(HorasEmpleadosResource.class);


	/**
	 * applicationName
	 */
	@Value("${jhipster.clientApp.name}")
	private String applicationName;

	/**
	 * HorasEmpleadosService
	 */
	@Autowired
	private HorasEmpleadosService horasEmpleadosService;

	/**
	 * HorasEmpleadosResource
	 * 
	 * @param horasEmpleadosService
	 */
	public HorasEmpleadosResource(HorasEmpleadosService horasEmpleadosService) {
		this.horasEmpleadosService = horasEmpleadosService;
	}
	
	/**
	 * Get
	 * 
	 * @param pageable
	 * @return
	 */
	@GetMapping(path = RestConstants.PATH_EMPLOYEE_HOURS_ALL)
	public ResponseEntity<List<HorasEmpleados>> getAllHorasEmpleados(Pageable pageable) {
		log.debug("REST request to get a page of Trabajos");
		Page<HorasEmpleados> page = horasEmpleadosService.findAll(pageable);
		HttpHeaders headers = PaginationUtil
				.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
		return ResponseEntity.ok().headers(headers).body(page.getContent());
	}

	/**
	 * Get by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = RestConstants.PATH_EMPLOYEE_HOURS_ID)
	public ResponseEntity<HorasEmpleados> getHorasEmpleados(@PathVariable Long id) {
		log.debug("REST request to get Trabajos : {}", id);
		Optional<HorasEmpleados> horas = horasEmpleadosService.findOne(id);
		return ResponseUtil.wrapOrNotFound(horas);
	}
}
