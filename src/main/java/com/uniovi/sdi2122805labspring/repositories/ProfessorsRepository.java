package com.uniovi.sdi2122805labspring.repositories;

import com.uniovi.sdi2122805labspring.entities.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorsRepository extends CrudRepository<Professor, Long>{

    Professor findByDni(String dni);

}
