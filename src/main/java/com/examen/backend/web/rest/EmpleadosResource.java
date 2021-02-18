/**
 * 
 */
package com.examen.backend.web.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.examen.backend.domain.Empleados;
import com.examen.backend.service.EmpleadosService;
import com.examen.backend.service.dto.EmpleadosDTO;
import com.examen.backend.utils.RestConstants;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * @author Norman
 *
 */
@RestController
@RequestMapping(RestConstants.PATH_API)
public class EmpleadosResource {

	/**
	 * Logger
	 */
	private final Logger log = LoggerFactory.getLogger(EmpleadosResource.class);

	/**
	 * ENTITY_NAME
	 */
	private static final String ENTITY_NAME = "employee";

	/**
	 * applicationName
	 */
	@Value("${jhipster.clientApp.name}")
	private String applicationName;

	/**
	 * ContenidoService
	 */
	@Autowired
	private EmpleadosService empleadosService;

	/**
	 * EmpleadosResource
	 * 
	 * @param empleadosService
	 */
	public EmpleadosResource(EmpleadosService empleadosService) {
		this.empleadosService = empleadosService;
	}

	/**
	 * Post
	 * 
	 * @param empleados
	 * @return
	 * @throws URISyntaxException
	 */
	@PostMapping(path = RestConstants.PATH_EMPLOYEE)
	public ResponseEntity<Empleados> createEmpleados(@RequestBody Empleados empleados) throws URISyntaxException {
		log.debug("REST request to save Empleados : {}", empleados);
		Empleados result = empleadosService.save(empleados);
		return ResponseEntity
				.created(new URI("/api/employee/" + result.getId())).headers(HeaderUtil
						.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
				.body(result);
	}

	/**
	 * Put 
	 * @param empleados
	 * @return
	 * @throws URISyntaxException
	 */
	@PutMapping(path = RestConstants.PATH_EMPLOYEE)
	public ResponseEntity<Optional<Empleados>> updateEmpleados(@RequestBody EmpleadosDTO dto) throws Exception {
		log.debug("REST request to update Empleados : {}", dto);
		Optional<Empleados> result = empleadosService.updateEmpleados(dto);
		Optional<Empleados> employee = empleadosService.findOne(result.get().getId());
		log.debug("Update   : {}", employee);
		return ResponseEntity.ok().headers(
				HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, result.get().getId().toString()))
				.body(employee);
	}

	/**
	 * Get
	 * 
	 * @param pageable
	 * @return
	 */
	@GetMapping(path = RestConstants.PATH_EMPLOYEE)
	public ResponseEntity<List<Empleados>> getAllEmpleados(Pageable pageable) {
		log.debug("REST request to get a page of Empleados");
		Page<Empleados> page = empleadosService.findAll(pageable);
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
	@GetMapping(path = RestConstants.PATH_EMPLOYEE_ID)
	public ResponseEntity<Empleados> getEmpleados(@PathVariable Long id) {
		log.debug("REST request to get Empleados : {}", id);
		Optional<Empleados> empleados = empleadosService.findOne(id);
		return ResponseUtil.wrapOrNotFound(empleados);
	}

	/**
	 * Delete by id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = RestConstants.PATH_EMPLOYEE_ID)
	public ResponseEntity<Void> deleteEmpleados(@PathVariable Long id) {
		log.debug("REST request to delete Empleados : {}", id);
		empleadosService.delete(id);
		return ResponseEntity.noContent()
				.headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
				.build();
	}
}
