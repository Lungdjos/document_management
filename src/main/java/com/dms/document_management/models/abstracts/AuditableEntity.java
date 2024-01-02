package com.dms.document_management.models.abstracts;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class AuditableEntity extends DocAbstractEntity{
    private Date createdDate;
    private long createdBy;
    private Date modifiedDate;
    private long modifiedBy;
}
