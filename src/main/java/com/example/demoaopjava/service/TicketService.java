package com.example.demoaopjava.service;

import com.example.demoaopjava.entity.Ticket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TicketService {
    public void createNewTicket(String startDate, String endDate) {
        Ticket newTicket = new Ticket(startDate, endDate);
        log.info("Create ticket successfully!" + newTicket.toString());
    }
}
