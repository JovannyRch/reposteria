/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reposteriasweetcake.DTO;

import java.util.Date;

public class Pedido {

    private int idPedido;
    private Date fecha;
    private int numPedido;
    private int idCliente;
    private boolean esADomicilio;
    
    public Pedido(){
        
    }

    public Pedido(int idPedido, Date fecha, int numPedido, int idCliente, boolean esADomicilio) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.numPedido = numPedido;
        this.idCliente = idCliente;
        this.esADomicilio = esADomicilio;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public boolean isEsADomicilio() {
        return esADomicilio;
    }

    public void setEsADomicilio(boolean esADomicilio) {
        this.esADomicilio = esADomicilio;
    }
    
}
