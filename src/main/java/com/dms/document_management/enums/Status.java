package com.dms.document_management.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    ERROR("ERROR"),
    SUCCESS("SUCCESS"),
    CREATE("CREATE");

    private final String status;
}
