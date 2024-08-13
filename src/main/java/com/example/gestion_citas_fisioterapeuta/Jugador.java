package com.example.gestion_citas_fisioterapeuta;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Jugador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String fechaNacimiento;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private String antecedentesEnfermedades;
    private String antecedentesLesiones;
    private String antecedentesQuirurgicos;
    private String observacionesActuales;
    private String fotoPerfil;
    
    // Constructor por defecto
    public Jugador() {
    	
    }

    // Constructor
    public Jugador(String nombre, String fechaNacimiento, String direccion, String telefono, String correoElectronico, 
                    String antecedentesEnfermedades, String antecedentesLesiones, 
                    String antecedentesQuirurgicos, String observacionesActuales, String fotoPerfil) {
    	this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.antecedentesEnfermedades = antecedentesEnfermedades;
        this.antecedentesLesiones = antecedentesLesiones;
        this.antecedentesQuirurgicos = antecedentesQuirurgicos;
        this.observacionesActuales = observacionesActuales;
        this.fotoPerfil = fotoPerfil;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getAntecedentesEnfermedades() {
        return antecedentesEnfermedades;
    }

    public void setAntecedentesEnfermedades(String antecedentesEnfermedades) {
        this.antecedentesEnfermedades = antecedentesEnfermedades;
    }

    public String getAntecedentesLesiones() {
        return antecedentesLesiones;
    }

    public void setAntecedentesLesiones(String antecedentesLesiones) {
        this.antecedentesLesiones = antecedentesLesiones;
    }

    public String getAntecedentesQuirurgicos() {
        return antecedentesQuirurgicos;
    }

    public void setAntecedentesQuirurgicos(String antecedentesQuirurgicos) {
        this.antecedentesQuirurgicos = antecedentesQuirurgicos;
    }

    public String getObservacionesActuales() {
        return observacionesActuales;
    }

    public void setObservacionesActuales(String observacionesActuales) {
        this.observacionesActuales = observacionesActuales;
    }
    
    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
}
