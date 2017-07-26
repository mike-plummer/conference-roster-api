package com.objectpartners.conference_roster.data.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Person extends AbstractEntity {
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy = "person")
    private Set<Attendance> conferences;

    @OneToMany
    private Set<Presentation> presentations;
}
