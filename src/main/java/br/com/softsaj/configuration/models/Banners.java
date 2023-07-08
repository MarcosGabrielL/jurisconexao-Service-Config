/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.softsaj.configuration.models;



/**
 *
 * @author Marcos
 */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Banners")
public class Banners {
    
     @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
     
     private String vendedor;
     private String id_imagem;
     private String titulo;
     private String subtitulo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public String getId_imagem() {
		return id_imagem;
	}
	public void setId_imagem(String id_imagem) {
		this.id_imagem = id_imagem;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	public Banners(Long id, String vendedor, String id_imagem, String titulo, String subtitulo) {
		super();
		this.id = id;
		this.vendedor = vendedor;
		this.id_imagem = id_imagem;
		this.titulo = titulo;
		this.subtitulo = subtitulo;
	}
	@Override
	public String toString() {
		return "Banners [id=" + id + ", vendedor=" + vendedor + ", id_imagem=" + id_imagem + ", titulo=" + titulo
				+ ", subtitulo=" + subtitulo + "]";
	}
	
     
}
