package com.rkstech.bookyourshow.models;

import com.rkstech.bookyourshow.enums.MovieFeature;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Hall extends BaseModel{
    private String name;

    @OneToMany
    private List<Seat> seats = new ArrayList<>();

    @ElementCollection  // bcz it is a list of enums if single enum this is not required
    @Enumerated // benefit is storage it accepts EnumType Default value is Ordinal  -> it means store it as tiny int  -> its not compulsory but efficient in storage
    private  List<MovieFeature> features = new ArrayList<>();


}
