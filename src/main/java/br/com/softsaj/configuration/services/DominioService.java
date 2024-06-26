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

import br.com.softsaj.configuration.models.Dominio;
import br.com.softsaj.configuration.repositories.DominioRopository;

/**
 *
 * @author Marcos
 */
@CrossOrigin("http://localhost:4200")
  @Service
public class DominioService {
    
    @Autowired
    private DominioRopository rp;
    
     public List<Dominio> findAll() {
        return rp.findAll();
    }
     
     public Dominio findDominioById(Long id) throws Exception {
        return rp.findDominioById(id)
                .orElseThrow(() -> new Exception("Dominio by id " + id + " was not found"));
    }
     
     public  List<Dominio> findByEmail(String email) {
        return rp.findByEmail(email);
    }
     
     public Dominio addDominio(Dominio cinefilo) {
        return rp.save(cinefilo);
    }
     
      public Dominio updateDominio(Dominio cinefilo) {
        return rp.save(cinefilo);
    }
      
      public void deleteDominio(Long id){
        try{
          rp.deleteDominioById(id);  
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException(
                    "Não foi possivel deletar o Dominio");
        }
    }
}
