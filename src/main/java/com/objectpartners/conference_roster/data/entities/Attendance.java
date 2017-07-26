package com.objectpartners.conference_roster.data.entities;

import com.objectpartners.conference_roster.data.types.TravelMethod;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Attendance extends AbstractEntity {
    @ManyToOne
    @JoinColumn
    private Conference conference;

    @ManyToOne
    @JoinColumn
    private Person person;

    @OneToMany
    @JoinColumn
    private Set<Presentation> presentations;

    private TravelMethod travelMethod;
    private LocalDateTime start;
    private LocalDateTime end;
}
