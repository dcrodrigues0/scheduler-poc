package com.acme.scheduler.entrypoint.controller.serviceType;

import com.acme.scheduler.core.entities.ServiceType;
import com.acme.scheduler.dto.ServiceTypeRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("${ms.api.path.schedule:/api/v1/serviceType}")
public interface ServiceTypeContract {

    @PostMapping
    public ServiceType createService(@RequestBody ServiceTypeRequest service);

    @GetMapping
    public List<ServiceType> getAllServices();

    @GetMapping(value = "/{uuid}")
    public ServiceType getServices(String uuid);

    @DeleteMapping(value = "/{uuid}")
    public ServiceType deleteService(String uuid);
}
