package ar.fiuba.tdd.tp2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class CancelAddProductListener implements ActionListener {

    private JFrame window;
    private JDialog dialog;

    public CancelAddProductListener(JFrame frame, JDialog dialog) {
        this.window = frame;
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.dialog.dispose();
        this.window.setEnabled(true);
	}

}