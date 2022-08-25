package com.kirbeygarcia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kirbeygarcia.model.Contacto;

@Repository
public interface ContactoRepository extends CrudRepository<Contacto, String> {
    
    public Optional<Contacto> findById(String id);

    List<Contacto> findByNameIgnoreCase(String name);

}
