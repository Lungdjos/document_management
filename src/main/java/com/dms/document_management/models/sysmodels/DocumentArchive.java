package com.dms.document_management.models.sysmodels;

import com.dms.document_management.models.abstracts.AuditableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DocumentArchive extends AuditableEntity {
    private int Status;
    @ManyToOne
    private Document document;
}
