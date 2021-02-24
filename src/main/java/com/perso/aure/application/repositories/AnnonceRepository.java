package com.perso.aure.application.repositories;

import org.springframework.data.repository.CrudRepository;

import com.perso.aure.application.domain.Annonce;


public interface AnnonceRepository extends CrudRepository<Annonce, String> {

}
