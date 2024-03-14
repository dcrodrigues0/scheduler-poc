package com.acme.scheduler.core.dataProviders.repository;

import com.acme.scheduler.core.entities.ServiceType;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ServiceRepository extends CrudRepository<ServiceType, String> {
}
