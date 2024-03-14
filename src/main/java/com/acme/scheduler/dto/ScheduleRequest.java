package com.acme.scheduler.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public class ScheduleRequest {

    @NotBlank(message = "Fullname is required")
    @JsonProperty("fullname")
    private String fullname;

    @Pattern(regexp = "^(\\(?[1-9]{2}\\)?\\s?)9\\d{8}$", message = "Phone number is invalid")
    @JsonProperty("phone")
    private String phone;

    @JsonProperty("serviceType")
    private String serviceType;

    @JsonProperty("date")
    private LocalDateTime date;

    public ScheduleRequest(String fullname, String phone, String serviceType, LocalDateTime date) {
        this.fullname = fullname;
        this.phone = phone;
        this.serviceType = serviceType;
        this.date = date;
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
}
