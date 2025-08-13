package com.rkstech.bookyourshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseModel{
    private String name;
    private String email;
    private String password;

    public User(String name, String email,String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
