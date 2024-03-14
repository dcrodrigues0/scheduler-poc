package com.acme.scheduler.core.useCases.serviceType;

import com.acme.scheduler.core.dataProviders.repository.ServiceRepository;
import com.acme.scheduler.core.entities.ServiceType;
import org.springframework.stereotype.Service;

@Service
public class CreateServiceType {

    private ServiceRepository serviceRepository;

    public CreateServiceType(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public ServiceType execute(ServiceType service) {
        return serviceRepository.save(service);
    }

}
