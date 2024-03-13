package com.acme.scheduler.entrypoint.controller;

import com.acme.scheduler.core.entities.Schedule;
import com.acme.scheduler.core.useCases.schedule.Create;
import com.acme.scheduler.dto.ScheduleRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ScheduleRest implements ScheduleContract {
    private Create create;

    public ScheduleRest(Create create) {
        this.create = create;
    }

    @Override
    public Schedule createSchedule(ScheduleRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(create.execute(new Schedule(
                        request.getFullname(),
                        request.getPhone(),
                        request.getServiceType(),
                        request.getDate())))
                .getBody();
    }

    @Override
    public Schedule getAllSchedules() {
        return null;
    }

    @Override
    public Schedule getScheduleByName(String name) {
        return null;
    }

    @Override
    public Schedule getScheduleByPhone(String phone) {
        return null;
    }

    @Override
    public Schedule getScheduleByDate(LocalDateTime date) {
        return null;
    }
}
