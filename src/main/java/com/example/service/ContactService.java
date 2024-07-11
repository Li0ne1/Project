package com.example.service;

import com.example.entity.Contact;
import org.springframework.stereotype.Service;

@Service
public interface ContactService {
    Contact saveContact(Contact contact);
}
