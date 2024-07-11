package com.example.crm_system.controller;

import com.example.crm_system.entity.Contact;
import com.example.crm_system.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    // Mapping to display the add contact form
    @GetMapping("/add")
    public String showAddContactForm(Model model) {
        model.addAttribute("contact", new Contact()); // Add empty Contact object to bind form data
        return "add_contact"; // Return the name of your HTML file for the form
    }

    // Mapping to handle form submission and save new contact
    @PostMapping("/add")
    public String addContact(@ModelAttribute("contact") Contact contact) {
        contactRepository.save(contact);
        return "redirect:/contacts"; // Redirect to the contacts list or another page after adding contact
    }

    // REST endpoint to get all contacts
    @GetMapping
    @ResponseBody
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    // REST endpoint to get a contact by ID
    @GetMapping("/{id}")
    @ResponseBody
    public Contact getContactById(@PathVariable Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
    }

    // REST endpoint to update a contact by ID
    @PutMapping("/{id}")
    @ResponseBody
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact contactDetails) {
        Contact contact = contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
        contact.setName(contactDetails.getName());
        contact.setEmail(contactDetails.getEmail());
        return contactRepository.save(contact);
    }

    // REST endpoint to delete a contact by ID
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        Contact contact = contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
        contactRepository.delete(contact);
    }
}
