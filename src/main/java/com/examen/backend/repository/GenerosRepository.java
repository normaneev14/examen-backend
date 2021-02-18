/**
 * 
 */
package com.examen.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.backend.domain.Generos;

/**
 * @author Norman
 *
 */
@Repository
public interface GenerosRepository  extends JpaRepository<Generos, Long>{

}
