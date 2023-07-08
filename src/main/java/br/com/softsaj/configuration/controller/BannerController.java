/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.softsaj.configuration.controller;


import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.softsaj.configuration.models.Banners;
import br.com.softsaj.configuration.services.BannersService;


/**
 *
 * @author Marcos
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/banners")
public class BannerController {
    
     @Autowired
    private BannersService vs;
    
    @GetMapping
    public ResponseEntity<List<Banners>> getAll() {
        List<Banners> movies =  vs.findAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    
    //GEt Banners
     @GetMapping("/Banners/{id}")
    public ResponseEntity<?> getCienfiloById (@PathVariable("id") Long id
             ,@RequestParam("token") String token) {
        
        Banners Banners = null;
		try {
			Banners = vs.findBannersById(id);
		} catch (Exception e) {
			 return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
		}
        return new ResponseEntity<>(Banners, HttpStatus.OK);
    }
    
     @GetMapping("/Banners/usuario/{email}")
    public ResponseEntity<List<Banners>> findByEmail (@PathVariable("email") String email
             ,@RequestParam("token") String token) {
        
       
        
        List<Banners> movies = vs.findByEmail(email);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    
    
    @PostMapping("/Banners/add")
    public ResponseEntity<Banners> addBanners(@RequestBody Banners movie, @RequestParam("token") String token) {
        
        Banners newBanners = vs.addBanners(movie);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/Banners/{id}").buildAndExpand(movie.getId()).toUri();
        
        return new ResponseEntity<>(newBanners, HttpStatus.CREATED);
    }
    
    //Update nome,telefone,idade,foto;
    @PutMapping("/Banners/update/{id}")
    public ResponseEntity<Banners> updateBanners(@PathVariable("id") Long id, @RequestBody Banners newBanners
            ,@RequestParam("token") String token) throws Exception {
        
        
        
        Banners Banners = vs.findBannersById(id);
        //Banners.setNome(newBanners.getNome());
        //c//inefilo.setTelefone(newBanners.getTelefone());
        //Banners.setIdade(newBanners.getIdade());
        //Banners.setFoto(newBanners.getFoto());
        Banners updateBanners = vs.updateBanners(Banners);//s
        return new ResponseEntity<>(updateBanners, HttpStatus.OK);
    }
    
    
    
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBanners(@PathVariable("id") Long id
            ,@RequestParam("token") String token) {
        
      
        
        vs.deleteBanners(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
