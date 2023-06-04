/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reposteriasweetcake.DTO;

import java.util.Date;

public class Usuario {

    private int idUsuario;
    private String email;
    private String password;
    private Date fechaCumpleanios;

    public Usuario(int idUsuario, String email, String password, Date fechaCumpleanios) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.password = password;
        this.fechaCumpleanios = fechaCumpleanios;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechaCumpleanios() {
        return fechaCumpleanios;
    }

    public void setFechaCumpleanios(Date fechaCumpleanios) {
        this.fechaCumpleanios = fechaCumpleanios;
    }

    
}
