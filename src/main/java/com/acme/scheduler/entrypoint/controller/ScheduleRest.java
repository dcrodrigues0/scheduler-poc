package com.acme.scheduler.entrypoint.controller;

import com.acme.scheduler.core.entities.Schedule;
import com.acme.scheduler.core.useCases.schedule.*;
import com.acme.scheduler.dto.ScheduleRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ScheduleRest implements ScheduleContract {
    private Create create;
    private GetAll getAll;
    private GetByDate getByDate;
    private GetByName getByName;
    private GetByPhone getByPhone;

    public ScheduleRest(Create create,
                        GetAll getAll,
                        GetByDate getByDate,
                        GetByName getByName,
                        GetByPhone getByPhone) {
        this.create = create;
        this.getAll = getAll;
        this.getByDate = getByDate;
        this.getByName = getByName;
        this.getByPhone = getByPhone;
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
    public List<Schedule> getAllSchedules() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(getAll.execute())
                .getBody();
    }

    @Override
    public List<Schedule> getScheduleByName(String name) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(getByName.execute(name))
                .getBody();
    }

    @Override
    public List<Schedule> getScheduleByPhone(String phone) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(getByPhone.execute(phone))
                .getBody();
    }

    @Override
    public List<Schedule> getScheduleByDate(String date) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(getByDate.execute(date.toString()))
                .getBody();
    }
}
