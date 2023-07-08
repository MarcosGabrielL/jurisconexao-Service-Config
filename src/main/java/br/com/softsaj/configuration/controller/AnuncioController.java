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

import br.com.softsaj.configuration.models.Anuncio;
import br.com.softsaj.configuration.services.AnuncioService;


/**
 *
 * @author Marcos
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/anuncios")
public class AnuncioController {
    
     @Autowired
    private AnuncioService vs;
    
    @GetMapping
    public ResponseEntity<List<Anuncio>> getAll() {
        List<Anuncio> movies =  vs.findAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    
    //GEt Anuncio
     @GetMapping("/Anuncio/{id}")
    public ResponseEntity<?> getCienfiloById (@PathVariable("id") Long id
             ,@RequestParam("token") String token) {
        
        Anuncio Anuncio = null;
		try {
			Anuncio = vs.findAnuncioById(id);
		} catch (Exception e) {
			 return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
		}
        return new ResponseEntity<>(Anuncio, HttpStatus.OK);
    }
    
     @GetMapping("/Anuncio/usuario/{email}")
    public ResponseEntity<List<Anuncio>> findByEmail (@PathVariable("email") String email
             ,@RequestParam("token") String token) {
        
       
        
        List<Anuncio> movies = vs.findByEmail(email);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    
    
    @PostMapping("/Anuncio/add")
    public ResponseEntity<Anuncio> addAnuncio(@RequestBody Anuncio movie, @RequestParam("token") String token) {
        
        Anuncio newAnuncio = vs.addAnuncio(movie);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/Anuncio/{id}").buildAndExpand(movie.getId()).toUri();
        
        return new ResponseEntity<>(newAnuncio, HttpStatus.CREATED);
    }
    
    //Update nome,telefone,idade,foto;
    @PutMapping("/Anuncio/update/{id}")
    public ResponseEntity<Anuncio> updateAnuncio(@PathVariable("id") Long id, @RequestBody Anuncio newAnuncio
            ,@RequestParam("token") String token) throws Exception {
        
        
        
        Anuncio Anuncio = vs.findAnuncioById(id);
        //Anuncio.setNome(newAnuncio.getNome());
        //c//inefilo.setTelefone(newAnuncio.getTelefone());
        //Anuncio.setIdade(newAnuncio.getIdade());
        //Anuncio.setFoto(newAnuncio.getFoto());
        Anuncio updateAnuncio = vs.updateAnuncio(Anuncio);//s
        return new ResponseEntity<>(updateAnuncio, HttpStatus.OK);
    }
    
    
    
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAnuncio(@PathVariable("id") Long id
            ,@RequestParam("token") String token) {
        
      
        
        vs.deleteAnuncio(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
