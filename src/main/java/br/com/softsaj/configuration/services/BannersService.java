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

import br.com.softsaj.configuration.models.Banners;
import br.com.softsaj.configuration.repositories.BannersRopository;

/**
 *
 * @author Marcos
 */
@CrossOrigin("http://localhost:4200")
  @Service
public class BannersService {
    
    @Autowired
    private BannersRopository rp;
    
     public List<Banners> findAll() {
        return rp.findAll();
    }
     
     public Banners findBannersById(Long id) throws Exception {
        return rp.findBannerById(id)
                .orElseThrow(() -> new Exception("Banners by id " + id + " was not found"));
    }
     
     public  List<Banners> findByEmail(String email) {
        return rp.findByEmail(email);
    }
     
     public Banners addBanners(Banners cinefilo) {
        return rp.save(cinefilo);
    }
     
      public Banners updateBanners(Banners cinefilo) {
        return rp.save(cinefilo);
    }
      
      public void deleteBanners(Long id){
        try{
          rp.deleteBannerById(id);  
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException(
                    "Não foi possivel deletar o Banners");
        }
    }
}
