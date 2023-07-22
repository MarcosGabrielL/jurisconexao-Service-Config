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

import br.com.softsaj.configuration.models.Cor;
import br.com.softsaj.configuration.services.CorService;


/**
 *
 * @author Marcos
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/cores")
public class CorController {
    
     @Autowired
    private CorService vs;
    
    @GetMapping
    public ResponseEntity<List<Cor>> getAll() {
        List<Cor> movies =  vs.findAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    
    //GEt Cor
     @GetMapping("/Cor/{idvendedor}")
    public ResponseEntity<?> getCienfiloById (@PathVariable("id") Long id
             ,@RequestParam("token") String token) {
        
        Cor Cor = new Cor();
		try {
			Cor = vs.findCorById(id);
		} catch (Exception e) {
			 return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
		}
        return new ResponseEntity<>(Cor, HttpStatus.OK);
    }
    
     @GetMapping("/Cor/usuario/{email}")
    public ResponseEntity<List<Cor>> findByEmail (@PathVariable("email") String email
             ,@RequestParam("token") String token) {
        
       
        
        List<Cor> movies = vs.findByEmail(email);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    
    
    @PostMapping("/Cor/add")
    public ResponseEntity<Cor> addCor(@RequestBody Cor movie, @RequestParam("token") String token) {
        
        Cor newCor = vs.addCor(movie);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/Cor/{id}").buildAndExpand(movie.getId()).toUri();
        
        return new ResponseEntity<>(newCor, HttpStatus.CREATED);
    }
    
    //Update nome,telefone,idade,foto;
    @PutMapping("/Cor/update/{idvendedor}")
    public ResponseEntity<Cor> updateCor(@PathVariable("id") Long id, @RequestBody Cor newCor
            ,@RequestParam("token") String token) throws Exception {
        
        
        
        Cor Cor = vs.findCorById(id);
        //Cor.setNome(newCor.getNome());
        //c//inefilo.setTelefone(newCor.getTelefone());
        //Cor.setIdade(newCor.getIdade());
        //Cor.setFoto(newCor.getFoto());
        Cor updateCor = vs.updateCor(Cor);//s
        return new ResponseEntity<>(updateCor, HttpStatus.OK);
    }
    
    
    
    @Transactional
    @DeleteMapping("/delete/{idvendedor}")
    public ResponseEntity<?> deleteCor(@PathVariable("id") Long id
            ,@RequestParam("token") String token) {
        
      
        
        vs.deleteCor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
