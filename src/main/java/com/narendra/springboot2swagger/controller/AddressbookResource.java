package com.narendra.springboot2swagger.controller;

import com.narendra.springboot2swagger.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class AddressbookResource {

    ConcurrentHashMap<String, Contact> conMap = new ConcurrentHashMap<String, Contact>();

    @GetMapping("/")
    public List<Contact> getContact() {
        return new ArrayList<Contact>(conMap.values());
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable String id) {
        return conMap.get(id);
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact) {
        conMap.put(contact.getId(), contact);
        return contact;
    }
}
