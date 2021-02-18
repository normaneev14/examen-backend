/**
 * 
 */
package com.examen.backend.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Norman
 *
 */
@Entity
@Table(name = "employee")
public class Empleados implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 189012725779996067L;

	/**
	 * Long id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * String name
	 */
	@Column(name = "name")
	private String name;

	/**
	 * String last_name
	 */
	@Column(name = "last_name")
	private String lastName;

	/**
	 * Date birthdate
	 */
	@Column(name = "birthdate")
	private Date birthdate;

	/**
	 * The bloque employee worked hours
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "employee_id", nullable = false)
	private HorasEmpleados horasEmpleados;

	/**
	 * Generos
	 */
	@ManyToOne
	@JsonIgnoreProperties("employees")
	private Generos generos;

	/**
	 * Trabajos
	 */
	@ManyToOne
	@JsonIgnoreProperties("employees")
	private Trabajos trabajos;

	/**
	 * Get
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set
	 * 
	 * @param id the id to set
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Get
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set
	 * 
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
	 * 
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * Set
	 * 
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(final Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * Get
	 * 
	 * @return the horasEmpleados
	 */
	public HorasEmpleados getHorasEmpleados() {
		return horasEmpleados;
	}

	/**
	 * Set
	 * 
	 * @param horasEmpleados the horasEmpleados to set
	 */
	public void setHorasEmpleados(final HorasEmpleados horasEmpleados) {
		this.horasEmpleados = horasEmpleados;
	}

	/**
	 * Get
	 * 
	 * @return the generos
	 */
	public Generos getGeneros() {
		return generos;
	}

	/**
	 * Set
	 * 
	 * @param generos the generos to set
	 */
	public void setGeneros(final Generos generos) {
		this.generos = generos;
	}

	/**
	 * Get
	 * 
	 * @return the trabajos
	 */
	public Trabajos getTrabajos() {
		return trabajos;
	}

	/**
	 * Set
	 * 
	 * @param trabajos the trabajos to set
	 */
	public void setTrabajos(final Trabajos trabajos) {
		this.trabajos = trabajos;
	}

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "Empleados [id=" + id + ", name=" + name + ", lastName=" + lastName + ", birthdate=" + birthdate
				+ ", horasEmpleados=" + horasEmpleados + ", generos=" + generos + ", trabajos=" + trabajos + "]";
	}

}
