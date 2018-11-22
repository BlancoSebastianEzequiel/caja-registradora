package ar.fiuba.tdd.tp2.gui;

import javax.swing.*;

import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import ar.fiuba.tdd.tp2.CashRegister;
import ar.fiuba.tdd.tp2.controller.AccessPanelListener;

public class TicketPanel extends Panel{

    public TicketPanel(JFrame frame, CashRegister cash, boolean modoSupervisor, JTextField user, JTextField pass){
        this.window = frame;
        this.cashReg = cash;
        panel.setLayout(null);

        JLabel textTitle = new JLabel("Ticket");
        textTitle.setBounds(30, 30, 740, 40);

        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(325, 505, 150, 35);
        botonAceptar.setBackground(new Color(53,131,199));
        botonAceptar.setFocusPainted(false);
        botonAceptar.setForeground(Color.white);

        String lines[];
        
        if (modoSupervisor){
            lines = this.cashReg.getControlTicket().split("\\r?\\n");
            botonAceptar.addActionListener(new AccessPanelListener(this.window, new ShoppingListSupervisorPanel(this.window, this.cashReg, user, pass)));
        } else {
            lines = this.cashReg.getSummaryTicket().split("\\r?\\n");
            botonAceptar.addActionListener(new AccessPanelListener(this.window, new ShoppingListCashierPanel(this.window, this.cashReg)));
        }

        JEditorPane textTicket = new JEditorPane();
        textTicket.setContentType("text/html");

        String data = "<html>";
        for (int i=0; i < lines.length; i++){
            data = data + lines[i] + "<br />";
        }

        data = data + "</html>";

        textTicket.setText(data);
        textTicket.setEditable(false);

        JScrollPane sp = new JScrollPane(textTicket);

        sp.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0,0,0,0), new EtchedBorder()));
        sp.setBounds(30, 95, 740, 360);
        textTitle.setFont(textTitle.getFont().deriveFont(22.0f));

        ImageIcon imagen = new ImageIcon("src/main/java/ar/fiuba/tdd/tp2/gui/data/img/rcback.png");
        JLabel background = new JLabel(imagen);
        background.setBounds(0,0,800,600);
        
        panel.add(textTitle);
        panel.add(sp);
        panel.add(botonAceptar);
        panel.add(background);
    }

}