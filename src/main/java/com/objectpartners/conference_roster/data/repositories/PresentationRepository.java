package com.objectpartners.conference_roster.data.repositories;

import com.objectpartners.conference_roster.data.entities.Presentation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PresentationRepository extends PagingAndSortingRepository<Presentation, Long> {
}
