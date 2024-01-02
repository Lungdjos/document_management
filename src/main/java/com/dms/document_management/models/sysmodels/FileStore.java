package com.dms.document_management.models.sysmodels;

import com.dms.document_management.models.abstracts.AuditableEntity;
import jakarta.persistence.Entity;
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
public class FileStore extends AuditableEntity {
    private String name;
    private String shortName;
    private String path;
    @OneToMany
    private List<Cabinet> cabinets;
}
