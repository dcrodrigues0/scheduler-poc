package com.acme.scheduler.entrypoint.controller;


import com.acme.scheduler.core.entities.Schedule;
import com.acme.scheduler.dto.ScheduleRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@RequestMapping("/v1/schedule")
public interface ScheduleContract {

    @PostMapping("/")
    public Schedule createSchedule(ScheduleRequest request);

    @GetMapping("/")
    public Schedule getAllSchedules();

    @GetMapping("/{name}")
    public Schedule getScheduleByName(@PathVariable String name);

    @GetMapping("/{phone}")
    public Schedule getScheduleByPhone(@PathVariable String phone);

    @GetMapping("/{date}")
    public Schedule getScheduleByDate(@PathVariable LocalDateTime date);

}
