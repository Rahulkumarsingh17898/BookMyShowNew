package com.rkstech.bookyourshow.dtos;

import com.rkstech.bookyourshow.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class CreateUserRequest {
    private String name;
    private String email;
    private String password;

    public User toUser () {
        return new User(name,email,password);
    }

}
