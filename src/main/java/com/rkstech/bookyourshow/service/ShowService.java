package com.rkstech.bookyourshow.service;

import com.rkstech.bookyourshow.dtos.CreateShowRequest;
import com.rkstech.bookyourshow.models.Movie;
import com.rkstech.bookyourshow.models.Show;
import com.rkstech.bookyourshow.models.ShowSeat;
import com.rkstech.bookyourshow.repository.ShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ShowService {

    private ShowRepository showRepository;

    public Show getShow(Long id) {
        return showRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Show with id " + id + " not found"));

    }

    public Show createShow(CreateShowRequest request) {
        // Task 1 Get the movie Id by calling MovieService
        Movie movie = null;

        Show show = Show.builder()
                .startTime(request.getStartTime())
                .duration(request.getDuration())
                .movie(movie)
                .build();

        Show savedShow = showRepository.save(show);

        //task 2
        //Get the seats in the hall using HallId
        //create the showSeats using the saved Show  (bcz ShowSeat needs show)
        //save the show again
        List<ShowSeat> seats = Collections.emptyList();
        return showRepository.save(savedShow.toBuilder().showSeats(seats).build());

    }
}
