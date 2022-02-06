package com.example.rgomar.HolaMundo.Dao;

import com.example.rgomar.HolaMundo.Dominio.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona, Long> {
}
