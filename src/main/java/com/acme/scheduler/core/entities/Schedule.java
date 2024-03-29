package com.acme.scheduler.core.entities;

import com.acme.scheduler.core.converter.LocalDateTimeConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.time.LocalDateTime;

@DynamoDBTable(tableName = "Schedule")
public class Schedule {

    @DynamoDBHashKey(attributeName = "scheduleId")
    @DynamoDBAutoGeneratedKey
    private String scheduleId;

    @DynamoDBAttribute(attributeName = "fullname")
    private String fullname;
    @DynamoDBAttribute(attributeName = "phone")
    private String phone;
    @DynamoDBAttribute(attributeName = "serviceType")
    private String serviceType;
    @DynamoDBAttribute(attributeName = "date")
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    private LocalDateTime date;

    public Schedule() {
    }

    public Schedule(String fullname, String phone, String serviceType, LocalDateTime date) {
        this.fullname = fullname;
        this.phone = phone;
        this.serviceType = serviceType;
        this.date = date;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhone() {
        return phone;
    }

    public String getServiceType() {
        return serviceType;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
