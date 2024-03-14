package com.acme.scheduler.core.useCases.serviceType;

import com.acme.scheduler.core.dataProviders.repository.ServiceRepository;
import com.acme.scheduler.core.entities.ServiceType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllServiceType {

    private final ServiceRepository serviceRepository;

    public GetAllServiceType(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<ServiceType> execute() {
        List<ServiceType> serviceTypes
                = new ArrayList<>();
        serviceRepository.findAll().iterator()
                .forEachRemaining(serviceTypes::add);
        return serviceTypes;
    }

}
