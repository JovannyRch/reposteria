/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reposteriasweetcake.DTO;

public class PedidoLocal {

    private int idPedido;
    private String nombreCliente;
    private String codigoVenta;

    public PedidoLocal(int idPedido, String nombreCliente, String codigoVenta) {
        this.idPedido = idPedido;
        this.nombreCliente = nombreCliente;
        this.codigoVenta = codigoVenta;
    }

    // Getters and Setters ...

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(String codigoVenta) {
        this.codigoVenta = codigoVenta;
    }
}
