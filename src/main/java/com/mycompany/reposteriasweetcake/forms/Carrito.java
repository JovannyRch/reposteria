/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.reposteriasweetcake.forms;

import com.mycompany.reposteriasweetcake.DB;
import com.mycompany.reposteriasweetcake.DTO.Pedido;
import com.mycompany.reposteriasweetcake.DTO.PedidoDomicilio;
import com.mycompany.reposteriasweetcake.DTO.PedidoLocal;
import com.mycompany.reposteriasweetcake.DTO.Producto;
import com.mycompany.reposteriasweetcake.DTO.ProductoPersonalizado;
import com.mycompany.reposteriasweetcake.DTO.ProductoPredeterminado;
import com.mycompany.reposteriasweetcake.DTO.Ticket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

public class Carrito extends javax.swing.JFrame {

    Home home;

    ArrayList<Producto> productosPredeterminados;
    ArrayList<ProductoPersonalizado> productosPersonalizados;
    PedidoDomicilio pedidoDomicilio;
    PedidoLocal pedidoLocal;

    String fechaActual;

    public Carrito(Home home, ArrayList<Producto> productosPredeterminados, ArrayList<ProductoPersonalizado> productosPersonalizados, double total) {
        initComponents();
        this.home = home;
        this.productosPersonalizados = productosPersonalizados;
        this.productosPredeterminados = productosPredeterminados;
        this.txtTotal.setText("TOTAL: $" + total);
        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        fechaActual = currentDate.format(formateador);

        this.labelFecha.setText("Fecha: " + fechaActual);

        this.renderList();
    }

    public void renderList() {
        DefaultListModel<String> listModel = new DefaultListModel<>();

        for (ProductoPersonalizado p : this.productosPersonalizados) {
            listModel.addElement(p.getProducto().getNombreProducto() + " -> " + " Ingredientes: " + p.getIngredientes() + " -> Figura: " + p.getFigura() + " -> Tamaño: " + p.getTamanio());
        }

        for (Producto p : this.productosPredeterminados) {
            listModel.addElement(p.getNombreProducto());
        }

        this.listProductos.setModel(listModel);
    }

    public void updatePedidoDescription() {
        if (this.pedidoDomicilio != null) {
            String text = "";
            text += "Dirección: " + this.pedidoDomicilio.getDireccion() + "\n";
            text += "Telefono: " + this.pedidoDomicilio.getTelefonoCliente() + "\n";

            this.txtDescripcion.setText(text);
        } else if (this.pedidoLocal != null) {

            String text = "";
            text += "Cliente: " + this.pedidoLocal.getNombreCliente() + "\n";
            text += "Codigo venta: " + this.pedidoLocal.getCodigoVenta() + "\n";

            this.txtDescripcion.setText(text);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProductos = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        radioEfectivo = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        radioTarjeta = new javax.swing.JRadioButton();
        txtTotal = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPedido = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listProductos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listProductos);

        jLabel1.setText("Finalizar compra");

        jLabel2.setText("Productos");

        jLabel3.setText("Tipo de entrega");

        jButton1.setText("A domicilio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("En el local");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jButton3.setText("Pagar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioEfectivo);
        radioEfectivo.setSelected(true);
        radioEfectivo.setText("En efectivo");

        jLabel4.setText("Tipo de pago");

        buttonGroup1.add(radioTarjeta);
        radioTarjeta.setText("Tarjeta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radioEfectivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radioTarjeta)
                        .addGap(54, 54, 54))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioEfectivo)
                    .addComponent(radioTarjeta))
                .addGap(27, 27, 27))
        );

        txtTotal.setText("TOTAL:");

        labelFecha.setText("Fecha: ");

        jLabel5.setText("Número pedido:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton1)
                        .addGap(50, 50, 50)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtPedido))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelFecha)
                                    .addComponent(txtTotal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(labelFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(txtTotal))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
        new ADomicilioForm(this).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
        new EnLocalForm(this).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        if (this.pedidoDomicilio == null && this.pedidoLocal == null) {
            JOptionPane.showMessageDialog(null, "Elija tipo de entrega");
            return;
        }

        if (!isValidInteger(this.txtPedido.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese un número de pedido válido (Valor entero)");
            return;
        }

        int numPedido = Integer.parseInt(this.txtPedido.getText());
        boolean esAdomicilio = this.pedidoDomicilio != null;
        
        Pedido pedido = new Pedido();
        pedido.setEsADomicilio(esAdomicilio);

        pedido.setFecha(new Date());
        pedido.setIdCliente(home.cliente.getIdCliente());
        pedido.setNumPedido(numPedido);
        

        DB db = new DB();

        int idPedido = db.createPedido(pedido);

        if (idPedido == -1) {
            JOptionPane.showMessageDialog(null, "Error al crear el pedido");
            return;
        }
        
        for (ProductoPersonalizado p : this.productosPersonalizados) {
            p.setIdPedido(idPedido);
            db.createProductoPersonalizado(p);
        }

        for (Producto p : this.productosPredeterminados) {
            ProductoPredeterminado productoPredeterminado = new ProductoPredeterminado();
            productoPredeterminado.setIdProducto(idPedido);
            productoPredeterminado.setIdPedido(idPedido);
            db.createProductoPredeterminado(productoPredeterminado);
        }
        
        
        if(esAdomicilio){
            this.pedidoDomicilio.setIdPedido(idPedido);
            db.createPedidoDomicilio(pedidoDomicilio);
        }else{
            this.pedidoLocal.setIdPedido(idPedido);
             db.createPedidoLocal(pedidoLocal);
        }
        
        //Crear el ticket
        Ticket ticket = new Ticket();
        
        ticket.setFecha(new Date());
        ticket.setIdPedido(idPedido);
       
        if(this.radioEfectivo.isSelected()){
            ticket.setTipo("Pago en efectivo");
        }else{
            ticket.setTipo("Pago con tarjeta");
        }
        
        ticket.setTotal(home.total);
        
        int idTicket = db.createTicket(ticket);
        
        JOptionPane.showMessageDialog(null, "Se creó el ticket con el id: "+idTicket);
        this.dispose();
        this.home = new Home(this.home.cliente);
        this.home.setVisible(true);
        

    }//GEN-LAST:event_jButton3ActionPerformed

    public static boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JList<String> listProductos;
    private javax.swing.JRadioButton radioEfectivo;
    private javax.swing.JRadioButton radioTarjeta;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtPedido;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
