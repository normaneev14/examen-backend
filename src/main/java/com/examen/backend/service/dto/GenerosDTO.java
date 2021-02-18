/**
 * 
 */
package com.examen.backend.service.dto;

/**
 * @author norma
 *
 */
public class GenerosDTO {

	
	/**
	 * Long id
	 */
	private Long id;
	

	/**
	 * String name
	 */
	private String name;


	/**
	 * Get
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * Set
	 * @param id the id to set
	 */
	public void setId(final Long id) {
		this.id = id;
	}


	/**
	 * Get
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Set
	 * @param name the name to set
	 */
	public void setNamefinal (String name) {
		this.name = name;
	}


	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "GenerosDTO [id=" + id + ", name=" + name + "]";
	}

	
	
	
}
