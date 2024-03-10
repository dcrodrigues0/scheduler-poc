package com.acme.scheduler.entrypoint.controller;

import com.acme.scheduler.core.entities.Schedule;
import com.acme.scheduler.dto.ScheduleRequest;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ScheduleRest implements ScheduleContract {

    @Override
    public Schedule createSchedule(ScheduleRequest request) {
        return null;
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
