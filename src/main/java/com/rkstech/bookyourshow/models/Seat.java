package com.rkstech.bookyourshow.models;

import com.rkstech.bookyourshow.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private Integer rowNo;
    private Integer columnNo;
    @Enumerated
    private SeatType seatType;
}
