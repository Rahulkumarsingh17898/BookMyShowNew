package com.rkstech.bookyourshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel {
    private String name;
    @OneToMany
    private List<Theatre> theatres = new ArrayList<>();

}


//@OneToMany  It creates a mapping table
//@Many to One t stores the reference
//We can control this behaviour by using @JoinColumn And All
//todo: ee the difference what happens with @JoinColumn