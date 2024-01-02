package com.dms.document_management.dto.sysdtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryDto {
    private String name;
    private String code;
    private UUID cabinetId;
}
