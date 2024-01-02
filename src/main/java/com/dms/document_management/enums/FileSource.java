package com.dms.document_management.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FileSource {
    MAIN("MAIN"),
    ARCHIVE("ARCHIVE");
    private final String fileSource;
}
