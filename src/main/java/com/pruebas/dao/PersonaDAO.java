package com.pruebas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pruebas.model.Persona;
//@Repository
/**@author ropold@yahoo.fr
**/
public interface PersonaDAO extends JpaRepository<Persona, Long>{


}
