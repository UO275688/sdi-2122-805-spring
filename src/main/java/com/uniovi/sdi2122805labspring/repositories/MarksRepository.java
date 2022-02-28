package com.uniovi.sdi2122805labspring.repositories;

import com.uniovi.sdi2122805labspring.entities.Mark;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface MarksRepository extends CrudRepository<Mark, Long> { //utilizando Crud ya es un Bean

    @Modifying
    @Transactional
    @Query("UPDATE Mark SET resend = ?1 WHERE id = ?2")
    void updateResend(Boolean resend, Long id);
}