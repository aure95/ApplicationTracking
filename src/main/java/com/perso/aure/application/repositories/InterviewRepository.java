package com.perso.aure.application.repositories;

import org.springframework.data.repository.CrudRepository;

import com.perso.aure.application.domain.Interview;

public interface InterviewRepository extends CrudRepository<Interview, String> {

}
