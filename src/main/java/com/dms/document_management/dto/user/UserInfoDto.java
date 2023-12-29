package com.dms.document_management.dto.user;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class UserInfoDto {
    private String fName;
    private String lName;
    private String email;
    private String username;
    private String password;
    private String role;

}
