package com.dms.document_management.models.abstracts;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class DocAbstractEntity {
    @Id
    private UUID id;
}
