package com.rkstech.bookyourshow.service;

import com.rkstech.bookyourshow.dtos.CreateBookingRequest;
import com.rkstech.bookyourshow.enums.BookingStatus;
import com.rkstech.bookyourshow.enums.SeatStatus;
import com.rkstech.bookyourshow.models.Booking;
import com.rkstech.bookyourshow.models.Show;
import com.rkstech.bookyourshow.models.ShowSeat;
import com.rkstech.bookyourshow.models.User;
import com.rkstech.bookyourshow.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class BookingService {
    private BookingRepository bookingRepository;
    private UserService userService;
    private ShowService showService;
    private ShowSeatService showSeatService;

//    We want to make sure at one time only one person can work on the bookingtable
//    for this we have to serializable transaction at database level(It will make sure multiple people don't book the same seat at the same time)
//    thus use Transactional

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(CreateBookingRequest createBookingequest) {
        //step 1 get user from user ID
            // step 1b) if user is not present throw error
        User user = userService.getUser(createBookingequest.getUserId());
        if(user == null) {
            throw new NoSuchElementException("User not found");
        }
        // step 2 get show from show Id
            //step 2b) if show is not present throw error
           Show show = showService.getShow(createBookingequest.getShowId());
        // step3 - Get the show seat for show seat id
            //step 3a) check if seatis present valid
            //step 3b) check if all the seats are available
            // step 3c) mark all the seats as blocked
            List<ShowSeat> showSeats = showSeatService.getShowSeat(createBookingequest.getShowSeatIds());
        for(ShowSeat showSeat : showSeats) {
            if(showSeat.getStatus()!= SeatStatus.AVAILABLE){
                throw new InvalidParameterException("Seat is not available");
            }
        }
        for(ShowSeat showSeat : showSeats) {
            showSeat.setStatus(SeatStatus.LOCKED);
        }
       List<ShowSeat> savedSeats = showSeatService.saveAll(showSeats);
        // step4 - we can calculate the amount of the Booking
//        We can have multiple ways of calculating an amount
//        use Strategy here and calculate the amount
        Double amount = 0.0;

        // step5 - create and save the booking
        Booking booking = Booking.builder()
                .user(user)
                .show(show)
                .seats(savedSeats)
                .amount(amount)
                .status(BookingStatus.PENDING)
                .bookedAt(new Date())
                .build();

        return bookingRepository.save(booking);

    }
}
