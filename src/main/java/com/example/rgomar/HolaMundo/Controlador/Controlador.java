package com.example.rgomar.HolaMundo.Controlador;

import com.example.rgomar.HolaMundo.Dominio.Persona;
import com.example.rgomar.HolaMundo.Service.PersonaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class Controlador {

    @Autowired
    private PersonaServiceImp personaService;

    @GetMapping("/")
    public String holaMundo(Model model){
        ArrayList<Persona> personas = (ArrayList<Persona>) personaService.listarPersonas();
        model.addAttribute("personas",personas);
        return "Holamundo";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }

    //Se almacenará persona en la base de datos
    @PostMapping("/guardar")
    public String guardar(Persona persona,Model model){
        personaService.guardar(persona);
        //Retorna redireccion al inicio, una vez guardada la persona
        return "redirect:/";
    }

    //Para encontrar persona se necesita un dato (idpersona) cuidar mayúsculas
    //@PutMapping("/editar/{idpersona}")
    @GetMapping("/editar/{idpersona}")
    public String editar(Persona persona,Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    //Aqui también se necesitaria lo mismo pero se implementaria otra cosa
    //@PostMapping(value="/eliminar")
    //@RequestMapping(method = RequestMethod.POST)
    //@RequestMapping()
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}
