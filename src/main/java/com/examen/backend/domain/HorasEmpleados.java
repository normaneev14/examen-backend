/**
 * 
 */
package com.examen.backend.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "horas_empleados")
public class HorasEmpleados implements Serializable {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 6113151831917032247L;

	
	/**
	 * Long id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Long employee_id
     */
	@Column(name = "employee_id")
    private Long employeeId;
	  
    /**
     * Long worked_hours
     */
	@Column(name = "worked_hours")
    private Long workedHours;
	
	/**
     * Date workend_date
     */
	@Column(name = "worked_date")
    private Date workedDate;
	
	/**
	 * Set Employees
	 */
	@OneToMany(mappedBy="horasEmpleados", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Empleados> empleados;

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
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * Set
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(final Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Get
	 * @return the workedHours
	 */
	public Long getWorkedHours() {
		return workedHours;
	}

	/**
	 * Set
	 * @param workedHours the workedHours to set
	 */
	public void setWorkedHours(final Long workedHours) {
		this.workedHours = workedHours;
	}

	/**
	 * Get
	 * @return the workedDate
	 */
	public Date getWorkedDate() {
		return workedDate;
	}

	/**
	 * Set
	 * @param workedDate the workedDate to set
	 */
	public void setWorkedDate(final Date workedDate) {
		this.workedDate = workedDate;
	}

	/**
	 * Get
	 * @return the empleados
	 */
	public Set<Empleados> getEmpleados() {
		return empleados;
	}

	/**
	 * Set
	 * @param empleados the empleados to set
	 */
	public void setEmpleados(final Set<Empleados> empleados) {
		this.empleados = empleados;
	}

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "HorasEmpleados [id=" + id + ", employeeId=" + employeeId + ", workedHours=" + workedHours
				+ ", workedDate=" + workedDate + ", empleados=" + empleados + "]";
	}
	
	
}
