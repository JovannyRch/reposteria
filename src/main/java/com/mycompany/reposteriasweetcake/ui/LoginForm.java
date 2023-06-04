
package com.mycompany.reposteriasweetcake.ui;
import com.mycompany.reposteriasweetcake.DB;
import com.mycompany.reposteriasweetcake.DTO.Cliente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginForm extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel emailLabel;
    private JLabel passwordLabel;

    public LoginForm() {
        setLayout(new BorderLayout());
        
        // Panel for the image
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        // Add your image here
        
        // Panel for the form
        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        emailLabel = new JLabel("Email:");
        passwordLabel = new JLabel("Password:");
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Iniciar sesión");
        
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(new JLabel());  // Empty space
        formPanel.add(loginButton);

        add(imagePanel, BorderLayout.WEST);
        add(formPanel, BorderLayout.EAST);

        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);  // Center the frame

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                DB db = new DB();
                Cliente cliente = db.checkLogin(email, password);
                if (cliente != null) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión correcto!");
                    // Perform login operations...
                } else {
                    JOptionPane.showMessageDialog(null, "Email o contraseña incorrectos.");
                }
            }
        });
    }
}
