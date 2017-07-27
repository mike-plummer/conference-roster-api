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
public class Presentation extends AbstractEntity {
    private String title;
    private String description;
    private String slidesUrl;
    private String codeUrl;

    private Set<String> tags = new HashSet<>(0);

    @DBRef
    private Set<Person> presenters = new HashSet<>(0);
}
