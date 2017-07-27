package com.objectpartners.conference_roster.data.entities;

import com.objectpartners.conference_roster.data.types.State;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class Conference extends AbstractEntity {
    private String name;
    private String city;
    private State state;
    private String url;
    private Boolean opiSponsored;
    private String discountCode;

    private LocalDate start;
    private LocalDate end;

    @DBRef
    private Set<Attendance> attendees = new HashSet<>(0);
}
