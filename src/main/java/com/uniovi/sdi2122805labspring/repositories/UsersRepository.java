package com.uniovi.sdi2122805labspring.repositories;

import com.uniovi.sdi2122805labspring.entities.*;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
}