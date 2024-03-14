package com.acme.scheduler.core.useCases.schedule;

import com.acme.scheduler.core.dataProviders.repository.ScheduleRepository;
import com.acme.scheduler.core.entities.Schedule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeleteSchedule {

    private final ScheduleRepository scheduleRepository;

    public DeleteSchedule(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule execute(String uuid){
        Optional<Schedule> schedule =
                scheduleRepository.findById(uuid);
        schedule.ifPresent(findedSchedule ->
                scheduleRepository.deleteById(findedSchedule.getScheduleId()));
        return schedule.orElse(null);
    }

}
