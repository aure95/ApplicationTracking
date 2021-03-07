package com.perso.aure.application.repositories;

import org.springframework.data.repository.CrudRepository;

import com.perso.aure.application.domain.Website;

public interface WebsiteRepository extends CrudRepository<Website, String> {

}
