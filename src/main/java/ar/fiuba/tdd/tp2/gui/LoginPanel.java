package ar.fiuba.tdd.tp2.gui;

import java.awt.Color;

import javax.swing.*;

import ar.fiuba.tdd.tp2.controller.AboutDialogListener;
import ar.fiuba.tdd.tp2.controller.HideMsgListener;
import ar.fiuba.tdd.tp2.controller.LoginController;

public class LoginPanel extends Panel {

    public LoginPanel(JFrame frame){
        this.window = frame;
        panel.setLayout(null);

        JButton iniciar = new JButton("Iniciar");
        iniciar.setBounds(348, 410, 100, 30);
        iniciar.setBackground(new Color(53,131,199));
        iniciar.setFocusPainted(false);
        iniciar.setForeground(Color.white);

        JButton acercaDe = new JButton("Info");
        acercaDe.setBounds(690, 20, 70, 20);
        acercaDe.setBackground(new Color(53,131,199));
        acercaDe.setFocusPainted(false);
        acercaDe.setForeground(Color.white);

        JLabel userText = new JLabel("Usuario:");
        userText.setBounds(230, 225, 330, 20);

        JLabel passText = new JLabel("Contraseña:");
        passText.setBounds(230, 290, 330, 20);

        JLabel rolText = new JLabel("Iniciar como:");
        rolText.setBounds(230, 362, 100, 20);

        JLabel incorrectText = new JLabel("Los datos ingresados son incorrectos");
        incorrectText.setBounds(265, 480, 280, 20);
        incorrectText.setForeground(Color.red);
        incorrectText.setVisible(false);

        JTextField userBox = new JTextField();
        userBox.setBounds(220, 250, 350, 30);
        userBox.addMouseListener(new HideMsgListener(incorrectText));
        userBox.addKeyListener(new HideMsgListener(incorrectText));

        JTextField passBox = new JTextField();
        passBox.setBounds(220, 315, 350, 30);
        passBox.addMouseListener(new HideMsgListener(incorrectText));
        passBox.addKeyListener(new HideMsgListener(incorrectText));

        JComboBox<String> rolSelect = new JComboBox<String>();
        rolSelect.setBounds(350, 360, 190, 25);
        rolSelect.addItem("Cajero");
        rolSelect.addItem("Supervisor");
        rolSelect.addMouseListener(new HideMsgListener(incorrectText));

        JLabel aboutText = new JLabel("Trabajo Práctico:" + 
        " Técnicas de Diseño - 2do Cuatrimestre 2018");
        aboutText.setBounds(180, 525, 440, 20);
        aboutText.setOpaque(false); 
        
        iniciar.addActionListener(new LoginController(this.window, userBox, passBox, rolSelect, incorrectText));
        acercaDe.addActionListener(new AboutDialogListener(this.window));

        panel.add(iniciar);
        panel.add(acercaDe);
        panel.add(userText);
        panel.add(passText);
        panel.add(userBox);
        panel.add(passBox);
        panel.add(rolSelect);
        panel.add(rolText);
        panel.add(aboutText);
        panel.add(incorrectText);
    }
}