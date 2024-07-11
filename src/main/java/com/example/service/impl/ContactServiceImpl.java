package com.example.service.impl;

import com.example.entity.Contact;
import com.example.repository.ContactRepository;
import com.example.service.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepo;

    public ContactServiceImpl(ContactRepository contactRepo) {
        super();
        this.contactRepo = contactRepo;
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepo.save(contact);
    }


}
