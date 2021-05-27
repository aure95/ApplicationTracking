package com.perso.aure.application.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.perso.aure.application.domain.Status;
import com.perso.aure.application.enums.StatusEnum;
import com.perso.aure.application.repositories.StatusRepositoryExt;

@Service
public class StatusService {
	
	private final StatusRepositoryExt statusRepositoryExt;
	
	public StatusService(StatusRepositoryExt statusRepositoryExt) {
		this.statusRepositoryExt = statusRepositoryExt;
	}
	
	public Status getStatus(StatusEnum status) {
		return statusRepositoryExt.findById(status.name()).orElseThrow();	
	}
}
