package com.objectpartners.conference_roster.data.entities;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class AbstractEntity {
    @Id
    @GeneratedValue
    private Long id;
}
