package com.rkstech.bookyourshow.controller;

import com.rkstech.bookyourshow.dtos.CreateBookingRequest;
import com.rkstech.bookyourshow.models.Booking;
import com.rkstech.bookyourshow.service.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    private BookingService bookingService;

    @PostMapping("/booking")
    public Booking createBooking(@RequestBody CreateBookingRequest createBookingequest){
        return bookingService.createBooking(createBookingequest);
    }

}
