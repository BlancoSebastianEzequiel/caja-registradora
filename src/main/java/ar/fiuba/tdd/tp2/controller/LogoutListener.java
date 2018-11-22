package ar.fiuba.tdd.tp2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ar.fiuba.tdd.tp2.CashRegister;
import ar.fiuba.tdd.tp2.gui.Panel;

public class LogoutListener implements ActionListener {

    private JFrame window;
    private Panel panel;
    private CashRegister cashReg;

    public LogoutListener(JFrame frame, CashRegister cash, Panel panel){
        this.window = frame;
        this.panel = panel;
        this.cashReg = cash;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.cashReg.logout();

        this.window.getContentPane().removeAll();
        this.window.getContentPane().add(panel.getPanel());
        this.window.revalidate();
        this.window.setEnabled(true);
	}

}