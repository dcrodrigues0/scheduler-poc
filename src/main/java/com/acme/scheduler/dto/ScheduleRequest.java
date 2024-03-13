package com.acme.scheduler.dto;

import com.acme.scheduler.core.enums.ServiceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleRequest {

    @NotBlank(message = "Fullname is required")
    private String fullname;

    @Pattern(regexp = "^\\d{10}$", message = "Phone number is invalid")
    private String phone;

    private ServiceType serviceType;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

}
