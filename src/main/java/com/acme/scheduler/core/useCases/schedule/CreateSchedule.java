package com.acme.scheduler.core.useCases.schedule;

import com.acme.scheduler.core.dataProviders.repository.ScheduleRepository;
import com.acme.scheduler.core.entities.Schedule;
import org.springframework.stereotype.Service;

@Service
public class CreateSchedule {
    private final ScheduleRepository scheduleRepository;

    public CreateSchedule(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule execute(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

}
