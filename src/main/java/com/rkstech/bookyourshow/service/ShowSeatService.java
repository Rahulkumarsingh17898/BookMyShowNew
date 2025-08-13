package com.rkstech.bookyourshow.service;

import com.rkstech.bookyourshow.models.ShowSeat;
import com.rkstech.bookyourshow.repository.ShowSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShowSeatService {

    private ShowSeatRepository showSeatRepository;

    public List<ShowSeat> getShowSeat(List<Long> showSeatIds) {
        return  showSeatRepository.findAllById(showSeatIds);
    }

    public List<ShowSeat> saveAll(List<ShowSeat> showSeats) {
        return showSeatRepository.saveAll(showSeats);
    }
}
