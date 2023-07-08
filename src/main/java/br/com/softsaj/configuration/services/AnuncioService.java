/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.softsaj.configuration.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.softsaj.configuration.models.Anuncio;
import br.com.softsaj.configuration.repositories.AnuncioRopository;

/**
 *
 * @author Marcos
 */
@CrossOrigin("http://localhost:4200")
  @Service
public class AnuncioService {
    
    @Autowired
    private AnuncioRopository rp;
    
     public List<Anuncio> findAll() {
        return rp.findAll();
    }
     
     public Anuncio findAnuncioById(Long id) throws Exception {
        return rp.findAnuncioById(id)
                .orElseThrow(() -> new Exception("Anuncio by id " + id + " was not found"));
    }
     
     public  List<Anuncio> findByEmail(String email) {
        return rp.findByEmail(email);
    }
     
     public Anuncio addAnuncio(Anuncio cinefilo) {
        return rp.save(cinefilo);
    }
     
      public Anuncio updateAnuncio(Anuncio cinefilo) {
        return rp.save(cinefilo);
    }
      
      public void deleteAnuncio(Long id){
        try{
          rp.deleteAnuncioById(id);  
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException(
                    "Não foi possivel deletar o Anuncio");
        }
    }
}
