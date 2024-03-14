package com.acme.scheduler.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.HashMap;
import java.util.List;

public class ServiceTypeRequest {

    @NotBlank(message = "Service name is required")
    private String serviceName;
    @NotNull(message = "Available date is required")
    private HashMap<String, List<String>> availableDate;

    public ServiceTypeRequest(String serviceName, HashMap<String, List<String>> availableDate) {
        this.serviceName = serviceName;
        this.availableDate = availableDate;
    }

    public String getServiceName() {
        return serviceName;
    }

    public HashMap<String, List<String>> getAvailableDate() {
        return availableDate;
    }


}
