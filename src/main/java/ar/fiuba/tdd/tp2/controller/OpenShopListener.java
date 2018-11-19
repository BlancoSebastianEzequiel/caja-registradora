package ar.fiuba.tdd.tp2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import ar.fiuba.tdd.tp2.gui.ProductListPanel;

public class OpenShopListener implements ActionListener {

    private JFrame window;
    private JScrollPane shopList;

    public OpenShopListener(JFrame frame, JScrollPane sp){
        this.window = frame;
        this.shopList = sp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProductListPanel shopListPanel = new ProductListPanel(this.window);

        this.window.getContentPane().removeAll();
        this.window.getContentPane().add(shopListPanel.getPanel());
        this.window.revalidate();
	}

}