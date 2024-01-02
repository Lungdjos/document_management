package com.dms.document_management.dto.sysdtos;

import com.dms.document_management.enums.Status;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto {
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
    private UUID libraryId;
}
