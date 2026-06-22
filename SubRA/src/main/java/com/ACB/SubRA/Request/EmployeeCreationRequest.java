package com.ACB.SubRA.Request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreationRequest {

    private String userName;

    private String fullName;

    private String email;

    private String phoneNumber;

    private String ipAddress;

    private boolean isActive;

    private Date createdTime;

    private String groupName;

    private String roleName ;


    @Size(min=6, message = "PASSWORD_INVALID")
    private  String password;

    private  String userParent;
}
