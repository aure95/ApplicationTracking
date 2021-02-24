package com.perso.aure.application.repositories;

import org.springframework.data.repository.CrudRepository;

import com.perso.aure.application.domain.Entreprise;

public interface EntreprisesRepository extends CrudRepository<Entreprise, String> {

}
