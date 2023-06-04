/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reposteriasweetcake.DTO;

import java.util.Date;

public class Cliente {

    private int idCliente;
    private String nombre;
    private String telefono;
    private Date fechaCumpleanios;
    

    public Cliente(int idCliente, String nombre, String telefono, Date fechaCumpleanios) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaCumpleanios = fechaCumpleanios;
    }

    // Getters and Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
     public Date getFechaCumpleanios() {
        return fechaCumpleanios;
    }

    public void setFechaCumpleanios(Date fechaCumpleanios) {
        this.fechaCumpleanios = fechaCumpleanios;
    }
   
}
