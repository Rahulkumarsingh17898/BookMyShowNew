package com.rkstech.bookyourshow.models;

import com.rkstech.bookyourshow.enums.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "shows") // show is a keyword in DB so change the table name
public class Show extends BaseModel{

    @ManyToOne
    private Movie movie;


    private Date startTime;

    private Integer duration;

    @OneToMany
    private List<ShowSeat> showSeats = new ArrayList<>();

    @ManyToOne  // here mapping table is not created by hibernate
    private Hall hall;

    @ElementCollection
    @Enumerated
    private List<MovieFeature> movieFeatures = new ArrayList<>();

}
