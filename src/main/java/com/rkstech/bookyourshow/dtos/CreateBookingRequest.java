package com.rkstech.bookyourshow.dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class CreateBookingRequest {
    private Long userId;
    private Long ShowId;
    private List<Long> showSeatIds = new ArrayList<>();

}
