package ar.fiuba.tdd.tp2.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ar.fiuba.tdd.tp2.gui.BoxesPanel;
import ar.fiuba.tdd.tp2.gui.ShoppingListCashierPanel;

public class LoginController implements ActionListener {

    private JFrame window;
    private JTextField user;
    private JTextField pass;
    private JComboBox mode; 
    private JLabel msg;

    public LoginController(JFrame frame, JTextField user, JTextField pass, JComboBox mode, JLabel msg){
        this.window = frame;
        this.user = user;
        this.pass = pass;
        this.mode = mode;
        this.msg = msg;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((this.user.getText().equals("rootC")) && (this.pass.getText().equals("rootC")) && (String.valueOf(this.mode.getSelectedItem()).equals("Cajero"))){
            ShoppingListCashierPanel bp = new ShoppingListCashierPanel(this.window);

            this.window.getContentPane().removeAll();
            this.window.getContentPane().add(bp.getPanel());
            this.window.revalidate();
        }

        if((this.user.getText().equals("rootS")) && (this.pass.getText().equals("rootS")) && (String.valueOf(this.mode.getSelectedItem()).equals("Supervisor"))){
            BoxesPanel bp = new BoxesPanel(this.window);

            this.window.getContentPane().removeAll();
            this.window.getContentPane().add(bp.getPanel());
            this.window.revalidate();
        }

        this.msg.setVisible(true);
        this.window.revalidate();
        
	}

}