/**
 * 
 */
package com.examen.backend.service.dto;

import java.sql.Date;



/**
 * @author Norman
 *
 */
public class EmpleadosDTO {

	
	/**
	 * Long id
	 */
	private Long id;

	/**
	 * String name
	 */
	private String name;

	/**
	 * String last_name
	 */
	private String lastName;

	/**
	 * Date birthdate
	 */
	private Date birthdate;

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
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Get
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set
	 * @param lastName the lastName to set
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * Set
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(final Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "EmpleadosDTO [id=" + id + ", name=" + name + ", lastName=" + lastName + ", birthdate=" + birthdate
				+ "]";
	}
	
	
	
}
