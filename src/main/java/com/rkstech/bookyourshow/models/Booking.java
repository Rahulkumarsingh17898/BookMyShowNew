package com.rkstech.bookyourshow.models;

import com.rkstech.bookyourshow.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @ManyToMany // BCZ there could be cancelled booking also
    private List<ShowSeat> seats = new ArrayList<>();

    private Double amount;
    private Date bookedAt;

    @Enumerated
    private BookingStatus status;

    @OneToMany // many payments for a booking is here bcz we can do emi or two different type of payments
    private List<Payment> payments = new ArrayList<>();


}
