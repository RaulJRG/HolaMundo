package com.example.rgomar.HolaMundo.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {
    @GetMapping("/")
    public String holaMundo(){
        return "Holamundo";
    }
}
