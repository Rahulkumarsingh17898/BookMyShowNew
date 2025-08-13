package com.rkstech.bookyourshow.controller;

import com.rkstech.bookyourshow.dtos.CreateShowRequest;
import com.rkstech.bookyourshow.models.Show;
import com.rkstech.bookyourshow.service.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v1") we can't dothis as we have already one controller with same path
// added the common prefix in prop file server.servlet.context-path=/api/v1
@AllArgsConstructor
public class ShowController {

    ShowService showService;
    //reap api for Show
    @GetMapping("/show/{id}")
    public Show getShow(@PathVariable Long id) {
        return showService.getShow(id);
    }
    //create show
    @PostMapping("/show")
    public Show createShow(CreateShowRequest createShowRequest) {
        return showService.createShow(createShowRequest);
    }

}
