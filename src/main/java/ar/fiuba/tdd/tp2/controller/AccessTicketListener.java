package ar.fiuba.tdd.tp2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import ar.fiuba.tdd.tp2.CashRegister;
import ar.fiuba.tdd.tp2.gui.TicketPanel;

public class AccessTicketListener implements ActionListener {

    private JFrame window;
    private JTextField user;
    private JTextField pass;
    private CashRegister cashReg;

    public AccessTicketListener(JFrame frame, CashRegister cash, JTextField user, JTextField pass){
        this.window = frame;
        this.user = user;
        this.pass = pass;
        this.cashReg = cash;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TicketPanel panel = new TicketPanel(this.window, this.cashReg, true, this.user, this.pass);
        this.cashReg.getControlTicket();

        this.window.getContentPane().removeAll();
        this.window.getContentPane().add(panel.getPanel());
        this.window.revalidate();
        this.window.setEnabled(true);
	}

}