package com.acme.scheduler.entrypoint.controller.serviceType;


import com.acme.scheduler.core.entities.ServiceType;
import com.acme.scheduler.core.useCases.serviceType.CreateServiceType;
import com.acme.scheduler.core.useCases.serviceType.DeleteServiceType;
import com.acme.scheduler.core.useCases.serviceType.GetAllServiceType;
import com.acme.scheduler.core.useCases.serviceType.GetServiceTypeById;
import com.acme.scheduler.dto.ServiceTypeRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceTypeRest implements ServiceTypeContract {

    private CreateServiceType createServiceType;
    private GetAllServiceType getAllServiceType;
    private GetServiceTypeById getServiceTypeByid;
    private DeleteServiceType deleteServiceType;

    public ServiceTypeRest(CreateServiceType createServiceType,
                           GetAllServiceType getAllServiceType,
                           GetServiceTypeById getServiceTypeByid,
                           DeleteServiceType deleteServiceType) {
        this.createServiceType = createServiceType;
        this.getAllServiceType = getAllServiceType;
        this.getServiceTypeByid = getServiceTypeByid;
        this.deleteServiceType = deleteServiceType;
    }

    @Override
    public ServiceType createService(ServiceTypeRequest service) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(createServiceType.execute(
                        new ServiceType(service.getServiceName(),
                        service.getAvailableDate())))
                .getBody();
    }

    @Override
    public List<ServiceType> getAllServices() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(getAllServiceType.execute())
                .getBody();
    }

    @Override
    public ServiceType getServices(String uuid) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(getServiceTypeByid.execute(uuid))
                .getBody();
    }

    @Override
    public ServiceType deleteService(String uuid) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(deleteServiceType.execute(uuid))
                .getBody();
    }
}
