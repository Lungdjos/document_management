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
public class Cabinet extends AuditableEntity {
    private String name;
    private String code;
    @ManyToOne
    private FileStore fileStore;
    @OneToMany
    private List<Library> libraries;
}
