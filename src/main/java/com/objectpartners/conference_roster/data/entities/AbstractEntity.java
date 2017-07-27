package com.objectpartners.conference_roster.data.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public abstract class AbstractEntity {
    @Id
    private String id;
}
