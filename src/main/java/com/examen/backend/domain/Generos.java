/**
 * 
 */
package com.examen.backend.domain;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Norman
 *
 */
@Entity
@Table(name = "genders")
public class Generos implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -6964013751778451684L;

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
	 * Set Genders
	 */
	@OneToMany(mappedBy = "genders")
	@JsonIgnore
	private Set<Empleados> empleados = new HashSet<>();

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
	 * @return the empleados
	 */
	public Set<Empleados> getEmpleados() {
		return empleados;
	}

	/**
     * Generos empleados
     * 
     * @param empleados
     * @return the this 
     */
    public Generos empleados(Set<Empleados> empleados) {
        this.empleados = empleados;
        return this;
    }

    /**
     * Generos addEmpleado
     * 
     * @param empleados
     * @return the this
     */
    public Generos addEmpleados(Empleados empleados) {
        this.empleados.add(empleados);
        empleados.setGeneros(this);
        return this;
    }

    /**
     * Generos removeEmpleados
     * 
     * @param empleados
     * @return the this 
     */
    public Generos removeEmpleados(Empleados empleados) {
        this.empleados.remove(empleados);
        empleados.setGeneros(null);
        return this;
    }

	/**
	 * Set
	 * @param empleados the empleados to set
	 */
	public void setEmpleados(final Set<Empleados> empleados) {
		this.empleados = empleados;
	}
	
	/**
	 * Equals
	 */
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Generos)) {
            return false;
        }
        return id != null && id.equals(((Generos) o).id);
    }

    /**
     * hashCode
     */
    @Override
    public int hashCode() {
        return 31;
    }

    /**
     * ToString
     */
	@Override
	public String toString() {
		return "Generos [id=" + id + ", name=" + name + ", empleados=" + empleados + "]";
	}
	
    
}
