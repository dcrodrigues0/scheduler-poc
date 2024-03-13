package com.acme.scheduler.core.converter;

import com.acme.scheduler.core.enums.ServiceType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public class ServiceTypeConverter implements DynamoDBTypeConverter<String, ServiceType> {

    @Override
    public String convert(ServiceType serviceType) {
        return serviceType.name();
    }

    @Override
    public ServiceType unconvert(String s) {
        return ServiceType.valueOf(s);
    }
}
