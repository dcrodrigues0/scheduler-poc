package com.acme.scheduler.entrypoint.controller.schedule;

import com.acme.scheduler.core.entities.Schedule;
import com.acme.scheduler.core.useCases.schedule.*;
import com.acme.scheduler.dto.ScheduleRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScheduleRest implements ScheduleContract {
    private CreateSchedule createSchedule;
    private GetAllSchedule getAllSchedule;
    private GetScheduleByDate getScheduleByDate;
    private GetScheduleByName getScheduleByName;
    private GetScheduleByPhone getScheduleByPhone;
    private DeleteSchedule deleteSchedule;

    public ScheduleRest(CreateSchedule createSchedule,
                        GetAllSchedule getAllSchedule,
                        GetScheduleByDate getScheduleByDate,
                        GetScheduleByName getScheduleByName,
                        GetScheduleByPhone getScheduleByPhone,
                        DeleteSchedule deleteSchedule) {
        this.createSchedule = createSchedule;
        this.getAllSchedule = getAllSchedule;
        this.getScheduleByDate = getScheduleByDate;
        this.getScheduleByName = getScheduleByName;
        this.getScheduleByPhone = getScheduleByPhone;
        this.deleteSchedule = deleteSchedule;
    }

    @Override
    public Schedule createSchedule(ScheduleRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(createSchedule.execute(new Schedule(
                        request.getFullname(),
                        request.getPhone(),
                        request.getServiceType(),
                        request.getDate())))
                .getBody();
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(getAllSchedule.execute())
                .getBody();
    }

    @Override
    public List<Schedule> getScheduleByName(String name) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(getScheduleByName.execute(name))
                .getBody();
    }

    @Override
    public List<Schedule> getScheduleByPhone(String phone) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(getScheduleByPhone.execute(phone))
                .getBody();
    }

    @Override
    public List<Schedule> getScheduleByDate(String date) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(getScheduleByDate.execute(date.toString()))
                .getBody();
    }

    @Override
    public Schedule deleteSchedule(String uuid) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(deleteSchedule.execute(uuid))
                .getBody();
    }


}
