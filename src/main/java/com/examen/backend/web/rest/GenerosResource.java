/**
 * 
 */
package com.examen.backend.web.rest;

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
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.examen.backend.domain.Generos;
import com.examen.backend.service.GenerosService;
import com.examen.backend.service.dto.GenerosDTO;
import com.examen.backend.utils.RestConstants;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * @author Norman
 *
 */
@RestController
@RequestMapping(RestConstants.PATH_API)
public class GenerosResource {

	/**
	 * Logger
	 */
	private final Logger log = LoggerFactory.getLogger(GenerosResource.class);

	/**
	 * ENTITY_NAME
	 */
	private static final String ENTITY_NAME = "genders";

	/**
	 * applicationName
	 */
	@Value("${jhipster.clientApp.name}")
	private String applicationName;

	/**
	 * GenerosService
	 */
	@Autowired
	private GenerosService generosService;

	/**
	 * GenerosResource
	 * 
	 * @param generosService
	 */
	public GenerosResource(GenerosService generosService) {
		this.generosService = generosService;
	}

	@PostMapping(path = RestConstants.PATH_GENDERS)
	public ResponseEntity<Generos> createGeneros(@RequestBody Generos generos) throws URISyntaxException {
		log.debug("REST request to save Generos : {}", generos);
		Generos result = generosService.save(generos);
		return ResponseEntity
				.created(new URI("/api/genders/" + result.getId())).headers(HeaderUtil
						.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
				.body(result);
	}

	/**
	 * Put para genero
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@PutMapping(path = RestConstants.PATH_GENDERS)
	public ResponseEntity<Optional<Generos>> updateGeneros(@RequestBody GenerosDTO dto) throws Exception {
		log.debug("REST request to update Generos : {}", dto);
		Optional<Generos> result = generosService.updateGeneros(dto);
		Optional<Generos> genero = generosService.findOne(result.get().getId());
		log.debug("Update   : {}", genero);
		return ResponseEntity.ok().headers(
				HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, result.get().getId().toString()))
				.body(genero);
	}

	/**
	 * Get
	 * 
	 * @param pageable
	 * @return
	 */
	@GetMapping(path = RestConstants.PATH_GENDERS_ALL)
	public ResponseEntity<List<Generos>> getAllGeneros(Pageable pageable) {
		log.debug("REST request to get a page of Empleados");
		Page<Generos> page = generosService.findAll(pageable);
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
	@GetMapping(path = RestConstants.PATH_GENDERS_ID)
	public ResponseEntity<Generos> getGeneros(@PathVariable Long id) {
		log.debug("REST request to get Generos : {}", id);
		Optional<Generos> genero = generosService.findOne(id);
		return ResponseUtil.wrapOrNotFound(genero);
	}
}
