package com.objectpartners.conference_roster.data.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class Person extends AbstractEntity {
    private String name;
    private String email;

    @DBRef
    private Set<Attendance> attendances = new HashSet<>(0);

    @DBRef
    private Set<Presentation> presentations = new HashSet<>(0);
}
