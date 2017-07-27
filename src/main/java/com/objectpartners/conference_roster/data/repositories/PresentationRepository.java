package com.objectpartners.conference_roster.data.repositories;

import com.objectpartners.conference_roster.data.entities.Person;
import com.objectpartners.conference_roster.data.entities.Presentation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

@RepositoryRestResource
public interface PresentationRepository extends PagingAndSortingRepository<Presentation, String> {
    Iterable<Presentation> getByTitle(String title);
    Iterable<Presentation> getAllByTagsIn(Set<String> tag);
    Iterable<Presentation> getByPresentersIn(Set<Person> person);
}
