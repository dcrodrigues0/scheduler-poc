package com.acme.scheduler.core.useCases.serviceType;

import com.acme.scheduler.core.dataProviders.repository.ServiceRepository;
import com.acme.scheduler.core.entities.ServiceType;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteServiceType {

    private final ServiceRepository serviceTypeRepository;

    public DeleteServiceType(ServiceRepository serviceTypeRepository) {
        this.serviceTypeRepository = serviceTypeRepository;
    }

    public ServiceType execute(String uuid){
        Optional<ServiceType> serviceType =
                serviceTypeRepository.findById(uuid);
        serviceType.ifPresent(findedService ->
                serviceTypeRepository.deleteById(findedService.getServiceId()));
        return serviceType.orElse(null);
    }

}
