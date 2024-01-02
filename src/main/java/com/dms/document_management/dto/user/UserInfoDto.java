package com.dms.document_management.dto.user;


import com.dms.document_management.models.roles.Role;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class UserInfoDto {
    private String fName;
    private String mName;
    private String lName;
    private String email;
    private String username;
    private String password;
    private Set<String> roles;

}
