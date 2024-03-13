package com.acme.scheduler.core.useCases.schedule;

import com.acme.scheduler.core.dataProviders.repository.ScheduleRepository;
import com.acme.scheduler.core.entities.Schedule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAll {

    private final ScheduleRepository scheduleRepository;

    public GetAll(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> execute(){
        List<Schedule> schedules = new ArrayList<>();
        scheduleRepository.findAll().iterator()
                .forEachRemaining(schedules::add);
        return schedules;
    }

}
