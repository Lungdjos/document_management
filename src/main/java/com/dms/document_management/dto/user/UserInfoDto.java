package com.dms.document_management.dto.user;


import com.dms.document_management.models.roles.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class UserInfoDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String role;

}
