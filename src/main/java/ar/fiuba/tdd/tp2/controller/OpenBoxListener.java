package ar.fiuba.tdd.tp2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ar.fiuba.tdd.tp2.gui.ShoppingListSupervisorPanel;

public class OpenBoxListener implements ActionListener {

    private JFrame window;

    public OpenBoxListener(JFrame frame){
        this.window = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ShoppingListSupervisorPanel shopListPanel = new ShoppingListSupervisorPanel(this.window, true);

        this.window.getContentPane().removeAll();
        this.window.getContentPane().add(shopListPanel.getPanel());
        this.window.revalidate();
	}

}