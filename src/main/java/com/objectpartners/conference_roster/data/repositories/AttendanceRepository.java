package com.objectpartners.conference_roster.data.repositories;

import com.objectpartners.conference_roster.data.entities.Attendance;
import com.objectpartners.conference_roster.data.entities.Conference;
import com.objectpartners.conference_roster.data.entities.Presentation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AttendanceRepository extends PagingAndSortingRepository<Attendance, String> {
    Iterable<Attendance> getByConference(Conference conference);
    Iterable<Attendance> getByPerson(Conference conference);
    Iterable<Attendance> getByPresentationsContaining(Presentation presentation);
}
