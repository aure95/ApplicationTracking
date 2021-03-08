package com.perso.aure.application.repositories;

import org.springframework.data.repository.CrudRepository;

import com.perso.aure.application.domain.Status;

public interface StatusRepository extends CrudRepository<Status, String> {

}
