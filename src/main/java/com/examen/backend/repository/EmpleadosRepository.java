/**
 * 
 */
package com.examen.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.backend.domain.Empleados;

/**
 * @author Norman
 *
 */
@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados, Long> {

}
