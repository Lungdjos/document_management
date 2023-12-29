package com.dms.document_management.dto.confis;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class AuthRequestDto {
    private String username;
    private String password;
}
