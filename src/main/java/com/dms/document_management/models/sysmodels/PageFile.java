package com.dms.document_management.models.sysmodels;

import com.dms.document_management.models.abstracts.DocAbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PageFile extends DocAbstractEntity {
    private String path;
    private String format;
    private String fileName;
    private Timestamp dateUploaded;
    @ManyToOne
    private Document document;
}
