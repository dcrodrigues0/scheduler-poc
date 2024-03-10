package com.acme.scheduler.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
public class ScheduleRequest {

    private String UUID;
    private String fullname;
    private String phone;
    private String serviceType;
    private LocalDateTime date;

}
