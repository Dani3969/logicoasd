package com.avellaneda.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
