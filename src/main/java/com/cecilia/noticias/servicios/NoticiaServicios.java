package com.cecilia.noticias.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.cecilia.noticias.entidades.Noticia;
import com.cecilia.noticias.exceptions.MiException;
import com.cecilia.noticias.repositorio.NoticiaRepositorio;

@Service
public class NoticiaServicios {
    @Autowired
    NoticiaRepositorio noticiaRepositorio;

    @Transactional
    public Noticia crearNoticia(String titulo, String cuerpo) throws MiException{
       
		validar(titulo, cuerpo);        
		

        Noticia noticia = new Noticia();
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
        System.out.println(noticia);

        return  noticiaRepositorio.save(noticia);
     
    }

    public void validar(String titulo, String cuerpo) throws MiException{

        if(titulo==null || titulo.isEmpty()){
          throw new MiException("el titulo no pueder ser nulo ni estar vacio");
        }

        if(cuerpo==null || cuerpo.isEmpty()){
            throw new MiException("el cuerpo no pueder ser nulo ni estar vacio");
        }
    }

    public List<Noticia> listarNoticias(){
        List<Noticia> noticias = new ArrayList<>();
        noticias = noticiaRepositorio.findAll();

        return noticias;       

    }

    @Deprecated 
    public Noticia getOne(String id){
        return noticiaRepositorio.getById(id);
    }
}
