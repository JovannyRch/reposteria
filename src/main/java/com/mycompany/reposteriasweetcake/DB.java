/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reposteriasweetcake;


import com.mycompany.reposteriasweetcake.DTO.Cliente;
import com.mycompany.reposteriasweetcake.DTO.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DB {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/reposteria_sweet_cake_db";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";
    
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
    
    public Cliente checkLogin(String email, String password) {
        String query = "SELECT * FROM Cliente WHERE Email = ? AND Password = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, email);
            statement.setString(2, password);
        
            ResultSet rs = statement.executeQuery();
            
            
            if(rs.next()) {
                return new Cliente(rs.getInt("IDCliente"), rs.getString("Nombre"), rs.getString("Telefono"), rs.getDate("fechaCumpleanios"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean registerUser(String email, String password, Cliente cliente) {
        String query = "INSERT INTO Cliente (Email, Password, Telefono, Nombre, FechaCumpleanios) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, cliente.getTelefono());
            statement.setString(4, cliente.getNombre());
            statement.setDate(5, new java.sql.Date(cliente.getFechaCumpleanios().getTime()));
            statement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM Cliente";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("IDCliente"), rs.getString("Nombre"), rs.getString("Telefono"), rs.getDate("fechaCumpleanios")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientes;
    }
    
    public ArrayList<Producto> getProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM Producto";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("IDProducto"));
                producto.setNombreProducto(rs.getString("NombreProducto"));
                producto.setPrecio(rs.getFloat("Precio"));
                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productos;
    }

}
