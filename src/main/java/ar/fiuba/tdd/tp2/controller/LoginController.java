package ar.fiuba.tdd.tp2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ar.fiuba.tdd.tp2.CashRegister;
import ar.fiuba.tdd.tp2.gui.ShoppingListCashierPanel;
import ar.fiuba.tdd.tp2.gui.ShoppingListSupervisorPanel;

public class LoginController implements ActionListener {

    private JFrame window;
    private JTextField user;
    private JTextField pass;
    private JLabel msg;
    private CashRegister cashReg;

    public LoginController(JFrame frame, JTextField user, JTextField pass, JLabel msg, CashRegister cash){
        this.window = frame;
        this.user = user;
        this.pass = pass;
        this.msg = msg;
        this.cashReg = cash;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            this.cashReg.login(this.user.getText(), this.pass.getText());
            this.window.getContentPane().removeAll();

            if(this.cashReg.getCashier() != null){
                ShoppingListCashierPanel bp = new ShoppingListCashierPanel(this.window, this.cashReg);
                this.window.getContentPane().add(bp.getPanel());
            } else {
                ShoppingListSupervisorPanel bp = new ShoppingListSupervisorPanel(this.window, this.cashReg, this.user, this.pass);
                this.window.getContentPane().add(bp.getPanel());
            }

            this.window.revalidate();
        } catch (RuntimeException ex) {
            this.msg.setText(ex.getMessage());
            this.msg.setVisible(true);
            this.window.revalidate();
        }
	}

}