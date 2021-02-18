/**
 * 
 */
package com.examen.backend.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "jobs")
public class Trabajos implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -3992799376505370001L;

	/**
	 * Long id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	/**
	 * String name
	 */
	@Column(name= "name")
	private String name;
	
	/**
	 * double salary 
	 */
	@Column(name = "salary")
	private Double salary;
	
	/**
	 * Set Trabajos
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
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}

	/**
	 * Set
	 * @param salary the salary to set
	 */
	public void setSalary(final Double salary) {
		this.salary = salary;
	}
	
	/**
	 * Get
	 * @return the empleados
	 */
	public Set<Empleados> getEmpleados() {
		return empleados;
	}
	
	/**
     * Trabajos empleados
     * 
     * @param empleados
     * @return the this 
     */
    public Trabajos empleados(Set<Empleados> empleados) {
        this.empleados = empleados;
        return this;
    }

    /**
     * Trabajos addEmpleado
     * 
     * @param empleados
     * @return the this
     */
    public Trabajos addEmpleados(Empleados empleados) {
        this.empleados.add(empleados);
        empleados.setTrabajos(this);
        return this;
    }

    /**
     * Trabajos removeEmpleados
     * 
     * @param empleados
     * @return the this 
     */
    public Trabajos removeEmpleados(Empleados empleados) {
        this.empleados.remove(empleados);
        empleados.setTrabajos(null);
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
	
	/**
	 * Equals
	 */
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Trabajos)) {
            return false;
        }
        return id != null && id.equals(((Trabajos) o).id);
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
		return "Trabajos [id=" + id + ", name=" + name + ", salary=" + salary + ", empleados=" + empleados + "]";
	}
	
	
	
	
}


