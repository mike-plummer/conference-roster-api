package com.objectpartners.conference_roster.data.entities;

import com.objectpartners.conference_roster.data.types.TravelMethod;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class Attendance extends AbstractEntity {
    @DBRef
    private Conference conference;

    @DBRef
    private Person person;

    @DBRef
    private Set<Presentation> presentations = new HashSet<>(0);

    private TravelMethod travelMethod;
    private LocalDateTime start;
    private LocalDateTime end;
}
