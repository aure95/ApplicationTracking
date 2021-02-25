package com.perso.aure.application.repositories;

import org.springframework.data.repository.CrudRepository;

import com.perso.aure.application.domain.Application;

public interface ApplicationRepository extends CrudRepository<Application, Integer> {

}
