package com.microservices.authentication.dto.feignDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private Boolean permissionBlocked;
}
