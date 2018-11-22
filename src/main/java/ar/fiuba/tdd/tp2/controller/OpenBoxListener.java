package ar.fiuba.tdd.tp2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import ar.fiuba.tdd.tp2.CashRegister;
import ar.fiuba.tdd.tp2.gui.ShoppingListSupervisorPanel;
import ar.fiuba.tdd.tp2.gui.TicketPanel;

public class OpenBoxListener implements ActionListener {

    private JFrame window;
    private CashRegister cashReg;
    private JTextField user;
    private JTextField pass;

    public OpenBoxListener(JFrame frame, CashRegister cash, JTextField user, JTextField pass){
        this.window = frame;
        this.cashReg = cash;
        this.user = user;
        this.pass = pass;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!this.cashReg.isOpen()){
            this.cashReg.open(this.user.getText(), this.pass.getText());

            ShoppingListSupervisorPanel shopListPanel = new ShoppingListSupervisorPanel(this.window, this.cashReg, this.user, this.pass);

            this.window.getContentPane().removeAll();
            this.window.getContentPane().add(shopListPanel.getPanel());
        } else {
            this.cashReg.close(this.user.getText(), this.pass.getText());

            TicketPanel panel = new TicketPanel(this.window, this.cashReg, true, this.user, this.pass);

            this.window.getContentPane().removeAll();
            this.window.getContentPane().add(panel.getPanel());
        }

        this.window.revalidate();
	}

}