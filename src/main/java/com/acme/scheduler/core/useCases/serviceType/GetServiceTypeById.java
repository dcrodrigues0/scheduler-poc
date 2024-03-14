package com.acme.scheduler.core.useCases.serviceType;

import com.acme.scheduler.core.dataProviders.repository.ServiceRepository;
import com.acme.scheduler.core.entities.ServiceType;
import org.springframework.stereotype.Service;

@Service
public class GetServiceTypeById {

    private final ServiceRepository serviceTypeRepository;

    public GetServiceTypeById(ServiceRepository serviceTypeRepository) {
        this.serviceTypeRepository = serviceTypeRepository;
    }

    public ServiceType execute(String uuid){
        return serviceTypeRepository.findById(uuid)
                .orElse(null);
    }

}
