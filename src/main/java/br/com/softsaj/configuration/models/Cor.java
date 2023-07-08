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
@Table(name = "cores")
public class Cor {
    
     @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
     
     private String vendedor;
     private String primary_color;
     private String secondary;
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
	public String getPrimary_color() {
		return primary_color;
	}
	public void setPrimary_color(String primary_color) {
		this.primary_color = primary_color;
	}
	public String getSecondary() {
		return secondary;
	}
	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}
	public Cor(Long id, String vendedor, String primary_color, String secondary) {
		super();
		this.id = id;
		this.vendedor = vendedor;
		this.primary_color = primary_color;
		this.secondary = secondary;
	}
	public Cor() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cor [id=" + id + ", vendedor=" + vendedor + ", primary_color=" + primary_color + ", secondary="
				+ secondary + "]";
	}
	
     
}
