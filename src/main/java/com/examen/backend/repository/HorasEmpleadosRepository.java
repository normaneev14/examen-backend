/**
 * 
 */
package com.examen.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.backend.domain.HorasEmpleados;

/**
 * @author Norman
 *
 */
@Repository
public interface HorasEmpleadosRepository extends JpaRepository<HorasEmpleados, Long> {

}
