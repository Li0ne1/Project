package com.example.controller;

import com.example.entity.Contact;
import com.example.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ContactController {
    private ContactService contactService;

    public ContactController(ContactService contactService) {
        super();
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String fillContactForm(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "contact";
    }

    @PostMapping("/contact")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/responsePage";
    }

    @GetMapping("/responsePage")
    public String showResponsePage(@RequestParam Map<String, String> params, Model model) {
        model.addAttribute("params", params);
        return "responsePage";
    }
}
