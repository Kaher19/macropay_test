package com.kirbeygarcia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.kirbeygarcia.exception.NotFoundException;
import com.kirbeygarcia.model.Contacto;
import com.kirbeygarcia.repository.ContactoRepository;

public class ContactoService {
    
    @Autowired
    private ContactoRepository contactoRepository;

    
    public Contacto getContacto(String id) {
        Optional<Contacto> contacto = contactoRepository.findById(id);
        if (!contacto.isPresent())
            throw new NotFoundException("No se encontró un usuario con id " +id);
        return contacto.get();
    }

    public Contacto findContacto(String phrase) {
        Optional<Contacto> contacto = contactoRepository.findById(phrase);
        if (!contacto.isPresent())
            throw new NotFoundException("No se encontró un usuario con id " +phrase);
        return contacto.get();
    }

    public Iterable<Contacto> getContactos(){
        return contactoRepository.findAll();
    }
    
}