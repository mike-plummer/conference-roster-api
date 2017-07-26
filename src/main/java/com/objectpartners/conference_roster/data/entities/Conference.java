package com.objectpartners.conference_roster.data.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Conference extends AbstractEntity {
    private String name;
    private String city;
    private String state;
    private Boolean opiSponsored;

    private LocalDate start;
    private LocalDate end;

    @OneToMany(mappedBy = "conference")
    private Set<Attendance> attendees;
}
