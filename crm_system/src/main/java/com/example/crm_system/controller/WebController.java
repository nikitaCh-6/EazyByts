package com.example.crm_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/add_contact")
    public String addContactPage() {
        return "add_contact"; // Corresponds to add_contact.html in resources/static
    }

    @GetMapping("/add_lead")
    public String addLeadPage() {
        return "add_lead"; // Corresponds to add_lead.html in resources/static
    }

    @GetMapping("/add_ticket")
    public String addTicketPage() {
        return "add_ticket"; // Corresponds to add_ticket.html in resources/static
    }
}
