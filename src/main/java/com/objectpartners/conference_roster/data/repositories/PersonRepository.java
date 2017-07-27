package com.objectpartners.conference_roster.data.repositories;

import com.objectpartners.conference_roster.data.entities.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends PagingAndSortingRepository<Person, String> {
    Person findByName(String name);
}
