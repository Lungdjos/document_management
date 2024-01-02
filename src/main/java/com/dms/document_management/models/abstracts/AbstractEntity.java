package com.dms.document_management.models.abstracts;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class AbstractEntity {
    // attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

}
