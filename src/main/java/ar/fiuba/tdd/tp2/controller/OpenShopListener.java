package ar.fiuba.tdd.tp2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;

import ar.fiuba.tdd.tp2.gui.ProductListPanel;

public class OpenShopListener implements ActionListener {

    private JFrame window;
    private JTable shopList;

    public OpenShopListener(JFrame frame, JTable shoppingList){
        this.window = frame;
        this.shopList = shoppingList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProductListPanel shopListPanel = new ProductListPanel(this.window);

        this.window.getContentPane().removeAll();
        this.window.getContentPane().add(shopListPanel.getPanel());
        this.window.revalidate();
	}

}