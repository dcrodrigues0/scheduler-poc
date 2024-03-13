package com.acme.scheduler.core.dataProviders.repository;

import com.acme.scheduler.core.entities.Schedule;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

@EnableScan
public interface ScheduleRepository extends CrudRepository<Schedule, String> {

    List<Schedule> findByDate(LocalDateTime date);
    List<Schedule> findByFullname(String fullname);
    List<Schedule> findByPhone(String phone);

}
