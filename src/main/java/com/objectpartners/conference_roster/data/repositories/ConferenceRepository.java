package com.objectpartners.conference_roster.data.repositories;

import com.objectpartners.conference_roster.data.entities.Conference;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ConferenceRepository extends PagingAndSortingRepository<Conference, Long> {
}
