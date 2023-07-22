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

import br.com.softsaj.configuration.models.Cor;
import br.com.softsaj.configuration.repositories.CorRopository;

/**
 *
 * @author Marcos
 */
@CrossOrigin("http://localhost:4200")
  @Service
public class CorService {
    
    @Autowired
    private CorRopository rp;
    
     public List<Cor> findAll() {
        return rp.findAll();
    }
     
     public Cor findCorById(Long id) throws Exception {
        return rp.findCorById(id)
                .orElseThrow(() -> new Exception("Cor by id " + id + " was not found"));
    }
     
     
     public  List<Cor> findByEmail(String idvendedor) {
        return rp.findByVendedor(idvendedor);
    }
     
     public Cor addCor(Cor cinefilo) {
        return rp.save(cinefilo);
        
    }
     
      public Cor updateCor(Cor cinefilo) {
        return rp.save(cinefilo);
    }
      
      public void deleteCor(Long id){
        try{
          rp.deleteCorById(id);  
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException(
                    "Não foi possivel deletar o Cor");
        }
    }
      
      public boolean Exists(String idVendedor) {
    	  return rp.existsByVendedor(idVendedor); 
      }
}
