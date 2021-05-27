package com.perso.aure.application.repositories;

import com.perso.aure.application.domain.Status;

public interface StatusRepositoryExt extends StatusRepository {

	public Status findStatusByLabel(String label);
}
