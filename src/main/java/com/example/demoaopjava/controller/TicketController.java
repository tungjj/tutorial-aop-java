package com.example.demoaopjava.controller;

import com.example.demoaopjava.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    @Autowired
    private TicketService service ;

    @PostMapping(value = "ticket")
    public void createTicket(
            @RequestParam(value = "startDate") String startDate,
            @RequestParam(value = "endDate") String endDate
            ) {
        service.createNewTicket(startDate, endDate);

    }
}
