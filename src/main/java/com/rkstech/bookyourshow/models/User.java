package com.rkstech.bookyourshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
@Entity
public class User extends BaseModel{
    private String name;
    private String email;
}
