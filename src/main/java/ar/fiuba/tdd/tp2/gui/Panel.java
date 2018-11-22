package ar.fiuba.tdd.tp2.gui;

import javax.swing.*;

import ar.fiuba.tdd.tp2.CashRegister;

public abstract class Panel{

    protected JPanel panel = new JPanel();
    protected JFrame window;
    protected CashRegister cashReg;

    public JPanel getPanel(){
        return panel;
    }

} 