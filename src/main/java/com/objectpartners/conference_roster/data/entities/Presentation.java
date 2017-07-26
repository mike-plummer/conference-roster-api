package com.objectpartners.conference_roster.data.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Presentation extends AbstractEntity {
    @OneToMany
    private Set<Person> presenters;

    private String title;
    private String description;
    @ElementCollection
    private Set<String> tags;
    private String presentationLink;
    private String codeLink;
}
