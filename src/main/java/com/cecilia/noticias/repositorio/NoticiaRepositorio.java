package com.cecilia.noticias.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cecilia.noticias.entidades.Noticia;

@Repository
public interface NoticiaRepositorio extends JpaRepository<Noticia, String>{

    @Query("select n from Noticia n where lower(n.titulo) like %:titulo%")
    public List<Noticia> findByTitulo(@Param("titulo") String titulo);
        
}
