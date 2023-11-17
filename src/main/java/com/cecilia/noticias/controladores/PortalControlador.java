package com.cecilia.noticias.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PortalControlador {
     @GetMapping("/")
    public String inicio() {

        return "inicio.html";
    }

    @GetMapping("/registrar")
    public String registrar(){
                
        return "registro.html";    
    }

    @GetMapping("/login")
    public String login(){       
   
        return "login.html";    
    }
    
    

    
}
