/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reposteriasweetcake.DTO;

public class PedidoDomicilio {

    private int idPedido;
    private String direccion;
    private String telefonoCliente;
    
    public PedidoDomicilio(){
        
    }

    public PedidoDomicilio(int idPedido, String direccion, String telefonoCliente) {
        this.idPedido = idPedido;
        this.direccion = direccion;
        this.telefonoCliente = telefonoCliente;
    }

    // Getters and Setters ...

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
}
