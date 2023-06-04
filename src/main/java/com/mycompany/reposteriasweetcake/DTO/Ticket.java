/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reposteriasweetcake.DTO;

import java.util.Date;


public class Ticket {

    private int idTicket;
    private String tipo;
    private Date fecha;
    private double total;
    private int idPedido;
    
    public Ticket(){
        
    }

    public Ticket(int idTicket, String tipo, Date fecha, double total, int idPedido) {
        this.idTicket = idTicket;
        this.tipo = tipo;
        this.fecha = fecha;
        this.total = total;
        this.idPedido = idPedido;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    
}