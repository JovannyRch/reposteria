/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reposteriasweetcake.DTO;

public class ProductoPersonalizado {

    private int idProducto;
    private String ingredientes;
    private String tamanio;
    private String figura;
    private int idPedido;
    private Producto producto;
    
    public ProductoPersonalizado(){
        
    }

    public ProductoPersonalizado(int idProducto, String ingredientes, String tamanio, String figura, int idPedido) {
        this.idProducto = idProducto;
        this.ingredientes = ingredientes;
        this.tamanio = tamanio;
        this.figura = figura;
        this.idPedido = idPedido;
    }

    // Getters and Setters ...

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
}