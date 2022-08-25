package com.kirbeygarcia.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kirbeygarcia.exception.ValidationExceptionsHandler;
import com.kirbeygarcia.model.Contacto;
import com.kirbeygarcia.service.ContactoService;

@RestController
@RequestMapping("/api")

public class ContactoRest {
    
    @Autowired
    private ContactoService contactoService;
    
	@CrossOrigin()
    @GetMapping("/contacts")
    public ResponseEntity<Object> getContactos() {
        Iterable<Contacto> contactos = contactoService.getContactos();
        return ResponseEntity.status(HttpStatus.OK).body(contactos);
    }
    
    @GetMapping("/contacts")
    public ResponseEntity<Object> getContactosFiltrados(@RequestHeader("phrase") String phrase) {
        Iterable<Contacto> contactos = contactoService.findContactos(phrase);
        return ResponseEntity.status(HttpStatus.OK).body(contactos);
    }

    @CrossOrigin()
    @PostMapping("/contact")
    public ResponseEntity<Object> postContacto() {
        Iterable<Contacto> contactos = contactoService.getContactos();
        return ResponseEntity.status(HttpStatus.OK).body(contactos);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> validateExceptions(MethodArgumentNotValidException ex) {
        ValidationExceptionsHandler exHandler = new ValidationExceptionsHandler(ex);
        return exHandler.handleValidationExceptions();
    }
}
