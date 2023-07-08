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
@Table(name = "Dominio")
public class Dominio {
    
     @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
     
     private String vendedor;
     private String urlfree;
     private String urlpersonal;
     private String appurl;
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
	public String getUrlfree() {
		return urlfree;
	}
	public void setUrlfree(String urlfree) {
		this.urlfree = urlfree;
	}
	public String getUrlpersonal() {
		return urlpersonal;
	}
	public void setUrlpersonal(String urlpersonal) {
		this.urlpersonal = urlpersonal;
	}
	public String getAppurl() {
		return appurl;
	}
	public void setAppurl(String appurl) {
		this.appurl = appurl;
	}
	public Dominio(Long id, String vendedor, String urlfree, String urlpersonal, String appurl) {
		super();
		this.id = id;
		this.vendedor = vendedor;
		this.urlfree = urlfree;
		this.urlpersonal = urlpersonal;
		this.appurl = appurl;
	}
	public Dominio() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Dominio [id=" + id + ", vendedor=" + vendedor + ", urlfree=" + urlfree + ", urlpersonal=" + urlpersonal
				+ ", appurl=" + appurl + "]";
	}


     
}
