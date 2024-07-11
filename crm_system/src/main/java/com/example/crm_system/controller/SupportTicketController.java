package com.example.crm_system.controller;

import com.example.crm_system.model.SupportTicket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/tickets")
public class SupportTicketController {
    private static final Logger logger = LoggerFactory.getLogger(SupportTicketController.class);

    @PostMapping("/submit")
    public ResponseEntity<String> submitTicket(@RequestBody SupportTicket ticket) {
        // Process the submitted subject (e.g., store in database, send email)
        logger.info("Submitted subject: " + ticket.getSubject());

        // Placeholder for actual processing logic
        // Example: supportTicketService.processTicket(ticket);

        return new ResponseEntity<>("Ticket submitted successfully", HttpStatus.OK);
    }
}

