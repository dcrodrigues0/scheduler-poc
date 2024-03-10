package com.acme.scheduler.core.dataProviders.repository;

import com.acme.scheduler.core.entities.Service;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<Service, String> {
}
