package ar.fiuba.tdd.tp2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ar.fiuba.tdd.tp2.CashRegister;
import ar.fiuba.tdd.tp2.gui.TicketPanel;

public class FinishSaleListener implements ActionListener {

    private JFrame window;
    private CashRegister cashReg;

    public FinishSaleListener(JFrame frame, CashRegister cash){
        this.window = frame;
        this.cashReg = cash;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.cashReg.finishSale();
        TicketPanel panel = new TicketPanel(this.window, this.cashReg);

        this.window.getContentPane().removeAll();
        this.window.getContentPane().add(panel.getPanel());
        this.window.revalidate();
        this.window.setEnabled(true);
	}

}