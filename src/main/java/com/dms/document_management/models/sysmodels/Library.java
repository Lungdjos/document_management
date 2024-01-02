package com.dms.document_management.models.sysmodels;

import com.dms.document_management.models.abstracts.AuditableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Library extends AuditableEntity {
    private String name;
    private String code;
    @OneToMany
    private List<Document> documents;
    @ManyToOne
    private Cabinet cabinet;

    public boolean hasFiles() {
        return documents != null && !documents.isEmpty();
    }
}
