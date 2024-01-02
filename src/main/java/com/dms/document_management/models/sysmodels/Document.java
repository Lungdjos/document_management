package com.dms.document_management.models.sysmodels;

import com.dms.document_management.enums.Status;
import com.dms.document_management.models.abstracts.AuditableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;


import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Document extends AuditableEntity {
    @NonNull
    private String title;
    @NonNull
    private String description;
    private String submittedBy;
    private boolean isConfidential;
    private Status status = Status.CREATE;
    private Timestamp submittedOn;
    @NonNull
    private String code;
    @ManyToOne
    private Library library;

    @OneToMany
    private List<PageFile> pageFiles;
}
