package ar.fiuba.tdd.tp2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ar.fiuba.tdd.tp2.CashRegister;
import ar.fiuba.tdd.tp2.gui.ProductListPanel;

public class OpenShopListener implements ActionListener {

    private JFrame window;
    private CashRegister cashReg;

    public OpenShopListener(JFrame frame, CashRegister cash){
        this.window = frame;
        this.cashReg = cash;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProductListPanel shopListPanel = new ProductListPanel(this.window, this.cashReg);
        this.cashReg.initSale();

        this.window.getContentPane().removeAll();
        this.window.getContentPane().add(shopListPanel.getPanel());
        this.window.revalidate();
	}

}