package com.dms.document_management.dto.confis;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class JwtResponseToken {
    private String accessToken;
}
