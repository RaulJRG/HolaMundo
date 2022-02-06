package com.example.rgomar.HolaMundo.Service;

import com.example.rgomar.HolaMundo.Dao.PersonaDao;
import com.example.rgomar.HolaMundo.Dominio.Persona;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonaServiceImp implements PersonaService{

    @Autowired
    private PersonaDao personaDao;

    @Override
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdpersona()).orElse(null);
    }
}
