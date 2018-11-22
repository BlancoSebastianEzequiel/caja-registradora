package ar.fiuba.tdd.tp2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import ar.fiuba.tdd.tp2.gui.Panel;

public class AccessPanelListener implements ActionListener {

    private JFrame window;
    private Panel panel;

    public AccessPanelListener(JFrame frame, Panel panel){
        this.window = frame;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.window.getContentPane().removeAll();
        this.window.getContentPane().add(panel.getPanel());
        this.window.revalidate();
        this.window.setEnabled(true);
	}

}