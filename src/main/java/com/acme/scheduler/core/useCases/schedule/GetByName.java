package com.acme.scheduler.core.useCases.schedule;

import com.acme.scheduler.core.dataProviders.repository.ScheduleRepository;
import com.acme.scheduler.core.entities.Schedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetByName {
    private final ScheduleRepository scheduleRepository;

    public GetByName(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> execute(String fullname){
        return scheduleRepository.findByFullname(fullname);
    }
}
