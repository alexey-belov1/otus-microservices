package com.otus.microservices.rest.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
