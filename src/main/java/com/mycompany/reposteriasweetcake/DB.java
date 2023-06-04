/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reposteriasweetcake;

import com.mycompany.reposteriasweetcake.DTO.Cliente;
import com.mycompany.reposteriasweetcake.DTO.Pedido;
import com.mycompany.reposteriasweetcake.DTO.PedidoDomicilio;
import com.mycompany.reposteriasweetcake.DTO.PedidoLocal;
import com.mycompany.reposteriasweetcake.DTO.Producto;
import com.mycompany.reposteriasweetcake.DTO.ProductoPersonalizado;
import com.mycompany.reposteriasweetcake.DTO.ProductoPredeterminado;
import com.mycompany.reposteriasweetcake.DTO.Ticket;
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
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Cliente(rs.getInt("IDCliente"), rs.getString("Nombre"), rs.getString("Telefono"), rs.getDate("fechaCumpleanios"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean registerUser(String email, String password, Cliente cliente) {
        String query = "INSERT INTO Cliente (Email, Password, Telefono, Nombre, FechaCumpleanios) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

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
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

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
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

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

    public int createPedido(Pedido pedido) {
        String query = "INSERT INTO Pedido (Fecha, NumPedido, IDCliente, EsADomicilio) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setDate(1, new java.sql.Date(pedido.getFecha().getTime()));
            statement.setInt(2, pedido.getNumPedido());
            statement.setInt(3, pedido.getIdCliente());
            statement.setBoolean(4, pedido.isEsADomicilio());
            statement.executeUpdate();

            // Get generated ID
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    return -1;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int createProductoPersonalizado(ProductoPersonalizado producto) {
        String query = "INSERT INTO ProductoPersonalizado (IDProducto, Ingredientes, Tamanio, Figura, IDPedido) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, producto.getIdProducto());
            statement.setString(2, producto.getIngredientes());
            statement.setString(3, producto.getTamanio());
            statement.setString(4, producto.getFigura());
            statement.setInt(5, producto.getIdPedido());
            statement.executeUpdate();

            // Get generated ID
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    return -1;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int createProductoPredeterminado(ProductoPredeterminado producto) {
        String query = "INSERT INTO ProductoPredeterminado (IDProducto, IDPedido) VALUES (?, ?)";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, producto.getIdProducto());
            statement.setInt(2, producto.getIdPedido());
            statement.executeUpdate();

            // Get generated ID
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    return -1;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    public int createTicket(Ticket ticket) {
        String query = "INSERT INTO Ticket (Tipo, Fecha, Total, IdPedido) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, ticket.getTipo());
            statement.setDate(2, new java.sql.Date(ticket.getFecha().getTime()));
            statement.setDouble(3, ticket.getTotal());
            statement.setInt(4, ticket.getIdPedido());
            statement.executeUpdate();

            // Get generated ID
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    return -1;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    
    public int createPedidoDomicilio(PedidoDomicilio pedido) {
        String query = "INSERT INTO PedidoDomicilio (IDPedido, Direccion, Telefono_cliente) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, pedido.getIdPedido());
            statement.setString(2, pedido.getDireccion());
            statement.setString(3, pedido.getTelefonoCliente());
            statement.executeUpdate();

            // Get generated ID
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    return -1;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int createPedidoLocal(PedidoLocal pedido) {
        String query = "INSERT INTO PedidoLocal (IDPedido, NombreCliente, CodigoVenta) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, pedido.getIdPedido());
            statement.setString(2, pedido.getNombreCliente());
            statement.setString(3, pedido.getCodigoVenta());
            statement.executeUpdate();

            // Get generated ID
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    return -1;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

}
