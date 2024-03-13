package com.acme.scheduler.entrypoint.controller;


import com.acme.scheduler.core.entities.Schedule;
import com.acme.scheduler.dto.ScheduleRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("${ms.api.path.schedule:/api/v1/schedule}")
public interface ScheduleContract {

    @PostMapping
    public Schedule createSchedule(@RequestBody @Valid ScheduleRequest request);

    @GetMapping
    public List<Schedule> getAllSchedules();

    @GetMapping("/name/{name}")
    public List<Schedule> getScheduleByName(@PathVariable String name);

    @GetMapping("/phone/{phone}")
    public List<Schedule> getScheduleByPhone(@PathVariable String phone);

    @GetMapping("/date/{date}")
    public List<Schedule> getScheduleByDate(@PathVariable String date);

}
