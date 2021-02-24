package com.perso.aure.application.repositories;

import org.springframework.data.repository.CrudRepository;

import com.perso.aure.application.domain.Domain;

public interface DomainsRepository extends CrudRepository<Domain, String> {

}
