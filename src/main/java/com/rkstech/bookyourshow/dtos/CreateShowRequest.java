package com.rkstech.bookyourshow.dtos;

import com.rkstech.bookyourshow.models.Movie;
import com.rkstech.bookyourshow.models.Show;
import lombok.Data;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Data
public class CreateShowRequest {
    private Long hallId;
    private Long movieId;
    private Date startTime;
    private Integer duration;

}
