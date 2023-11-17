package com.cecilia.noticias.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cecilia.noticias.entidades.Noticia;
import com.cecilia.noticias.servicios.NoticiaServicios;

@Controller
@RequestMapping("/noticia")
public class NoticiaControlador {

    @Autowired
    NoticiaServicios noticiaServicios;

    @GetMapping("/crear")
    public String crearNoticia() {

        return "noticia_form.html";
    }

    @PostMapping("/cargar")
    public String cargarNoticia(@RequestParam String titulo,
            @RequestParam String cuerpo, ModelMap modelo) {

        try {
           System.out.println(noticiaServicios.crearNoticia(titulo, cuerpo));
            modelo.put("exito", "noticia cargada exitosamente!");

        } catch (Exception e) {
           modelo.put("error", e.getMessage());
           return "noticia_form.html";
        }

        return "noticia_form.html";

    }

    @GetMapping("/listar")
    public String listarNoticias(String titulo, String cuerpo, ModelMap modelo){

        List<Noticia> noticias = noticiaServicios.listarNoticias();

        modelo.addAttribute("noticias", noticias);

        return "noticia_list.html";

        

        
    }


}
