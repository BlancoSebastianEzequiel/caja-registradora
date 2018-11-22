package ar.fiuba.tdd.tp2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import ar.fiuba.tdd.tp2.CashRegister;
import ar.fiuba.tdd.tp2.gui.TicketPanel;

public class FinishSaleListener implements ActionListener {

    private JFrame window;
    private CashRegister cashReg;
    private JDialog dialog;

    public FinishSaleListener(JFrame frame, CashRegister cash, JDialog dialog){
        this.window = frame;
        this.cashReg = cash;
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.cashReg.finishSale();
        TicketPanel panel = new TicketPanel(this.window, this.cashReg);

        this.dialog.dispose();
        this.window.getContentPane().removeAll();
        this.window.getContentPane().add(panel.getPanel());
        this.window.revalidate();
        this.window.setEnabled(true);
	}

}